/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Encryption;

import BackEnd.Encryption.Key;
import BackEnd.Encryption.conversion.Conversion;
import BackEnd.Encryption.conversion.StringOperations;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gauravpunjabi
 */
public class SimpleDes {
    private Key k = new Key();
	private int orignalLength;
	private boolean readable;
	public SimpleDes()
	{
		this(true);
	}
	public SimpleDes(boolean readable)
	{
		this.readable = readable;
	}
	private int IP[][] = {{58,50,42,34,26,18,10,2},
					{60,52,44,36,28,20,12,4},
					{62,54,46,38,30,22,14,6},
					{64,56,48,40,32,24,16,8},
					{57,49,41,33,25,17,9,1},
					{59,51,43,35,27,19,11,3},
					{61,53,45,37,29,21,13,5},
					{63,55,47,39,31,23,15,7}};
	private int eBit[][] = {{32,1,2,3,4,5},
					{4,5,6,7,8,9},
					{8,9,10,11,12,13},
					{12,13,14,15,16,17},
					{16,17,18,19,20,21},
					{20,21,22,23,24,25},
					{24,25,26,27,28,29},
					{28,29,30,31,32,1}};
	private int sBox[][][] = {{{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
						{0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
						{4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
						{15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}},
					  {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
						{3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
						{0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
						{13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}},
					  {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
						{13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
						{13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
						{1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}},
					  {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
						{13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
						{10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
						{3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}},
					  {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
						{14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
						{4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
						{11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}},
					  {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
						{10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
						{9,14,15,5,2,8,12,13,7,0,4,10,1,13,11,6},
						{4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}},
					  {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
						{13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
						{1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
						{6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}},
					  {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
						{1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
						{7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
						{2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}}};
	private int P[][] = {{16,7,20,21},
					{29,12,28,17},
					{1,15,23,26},
					{5,18,31,10},
					{2,8,24,14},
					{32,27,3,9},
					{19,13,30,6},
					{22,11,4,25}};
	private int IPInverse[][] = {{40,8,48,16,56,24,64,32},
							{39,7,47,15,55,23,63,31},
							{38,6,46,14,54,22,62,30},
							{37,5,45,13,53,21,61,29},
							{36,4,44,12,52,20,60,28},
							{35,3,43,11,51,19,59,27},
							{34,2,42,10,50,18,58,26},
							{33,1,41,9,49,17,57,25}};
	private StringBuffer repermute(StringBuffer s,int matrix[][])
	{
		StringBuffer repermutedString = new StringBuffer();
		for(int i=0;i<matrix.length*matrix[0].length;i++)
			repermutedString.append(0);
		for(int i=0,k=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++,k++)
				repermutedString.setCharAt(matrix[i][j]-1,s.charAt(k));
		}
		return repermutedString;
	}
	private StringBuffer permute(StringBuffer s,int matrix[][])
	{
		StringBuffer permutedString = new StringBuffer();
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
				permutedString.append(s.charAt(matrix[i][j]-1));
		}
		return permutedString;
	}
	private StringBuffer sBoxPermute(StringBuffer s)
	{
		StringBuffer temp = new StringBuffer();
		for(int i=0,j=0;i<8;i++,j+=6)
			temp.append(Conversion.decimalToBinary(sBox[i][((2*(s.charAt(j)-48)) + (1*(s.charAt(j+5)-48)))][Integer.parseInt(s.substring(j+1,j+5),2)]));
		return temp;
	}
	private StringBuffer fFunction(StringBuffer R,StringBuffer K)
	{
		R = permute(R,eBit);
		R = StringOperations.exOr(R,K);
		R = sBoxPermute(R);
		R = permute(R,P);
		return R;
	}
	private String encode(String text)
	{
		StringBuffer M;
		StringBuffer L,R,temp;
		M = permute(Conversion.hexToBinary(text),IP);
		L = new StringBuffer(M.substring(0,32));
		R = new StringBuffer(M.substring(32));
		temp = L;
		for(int i=0;i<16;i++)
		{
			L = R;
			R = fFunction(R,k.K[i]);
			R = StringOperations.exOr(R,temp);
			temp = L;
		}
		M = permute(R.append(L),IPInverse);
		text = Conversion.binaryToHex(M);
		
		return (text.toString());
	}
	private String decode(String cipherText)
	{
		StringBuffer L,R,M,temp;
		M = Conversion.hexToBinary(cipherText);
		M = repermute(M,IPInverse);
		L = new StringBuffer(M.substring(32));
		R = new StringBuffer(M.substring(0,32));
		temp = R;
		for(int i=15;i>=0;i--)
		{
			R = L;
			L = fFunction(L,k.K[i]);
			L = StringOperations.exOr(L,temp);
			temp = R;
		}
		M = L.append(R);
		M = repermute(M,IP);
		cipherText = Conversion.binaryToHex(M);
		
		return (cipherText.toString());
	}
	public String encrypt(String t)
	{
		StringBuffer text = new StringBuffer(t);
		text = Conversion.asciiToHex(text);
		orignalLength = text.length();
		StringBuffer temp = new StringBuffer();
		if(text.length()%16 != 0)
			text = StringOperations.rightPad(text,(16*(int)Math.ceil((double)text.length()/16))-text.length());
		Matcher get16 = Pattern.compile(".{16}").matcher(text);
		while(get16.find())
			text.replace(get16.start(),get16.end(),encode(text.substring(get16.start(),get16.end())));
		text = Conversion.hexToAscii(text);
		if(!readable)
			text = Conversion.add(text,256);

		return text.toString();
	}
	public String decrypt(String t)
	{
		StringBuffer text = new StringBuffer(t);
		if(!readable)
			text = Conversion.add(text,-256);
		text = Conversion.asciiToHex(text);
		Matcher get16 = Pattern.compile(".{16}").matcher(text);
		while(get16.find())
			text.replace(get16.start(),get16.end(),decode(text.substring(get16.start(),get16.end())));
		text.setLength(orignalLength);
		text = Conversion.hexToAscii(text);
		
		return text.toString();
	}
}
