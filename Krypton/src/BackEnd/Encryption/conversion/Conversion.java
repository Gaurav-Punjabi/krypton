/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Encryption.conversion;

/**
 *
 * @author gauravpunjabi
 */
public class Conversion 
{
    /*Hexadecimal to binary conversion
    *@param : temp - String that needs to be converted from hex to binary bits
    *@return-type : it returns the converted string in the form of StringBuffer
    * 	This function simply converts the given hex string to binary bits.
    * 	Also see binaryToHex().
    */
    public static StringBuffer hexToBinary(String temp)
    {
        StringBuffer s = new StringBuffer(temp.toUpperCase());
        String table[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        StringBuffer binary = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) >= 65)
                binary.append(table[s.charAt(i) - 55]);
            else
                binary.append(table[s.charAt(i) - 48]);
        }
        return binary;
    } 
    public static String binaryToHex(StringBuffer s)
    {
        StringBuffer hex = new StringBuffer();
        for(int i=0;i<s.length();i+=4)
        {
            if(s.substring(i,i+4).equals("0000"))
                hex.append(0);
            else if(s.substring(i,i+4).equals("0001"))
                hex.append(1);
            else if(s.substring(i,i+4).equals("0010"))
                hex.append(2);
            else if(s.substring(i,i+4).equals("0011"))
                hex.append(3);
            else if(s.substring(i,i+4).equals("0100"))
                hex.append(4);
            else if(s.substring(i,i+4).equals("0101"))
                hex.append(5);
            else if(s.substring(i,i+4).equals("0110"))
                hex.append(6);
            else if(s.substring(i,i+4).equals("0111"))
                hex.append(7);
            else if(s.substring(i,i+4).equals("1000"))
                hex.append(8);
            else if(s.substring(i,i+4).equals("1001"))
                hex.append(9);
            else if(s.substring(i,i+4).equals("1010"))
                hex.append('A');
            else if(s.substring(i,i+4).equals("1011"))
                hex.append('B');
            else if(s.substring(i,i+4).equals("1100"))
                hex.append('C');
            else if(s.substring(i,i+4).equals("1101"))
                hex.append('D');
            else if(s.substring(i,i+4).equals("1110"))
                hex.append('E');
            else if(s.substring(i,i+4).equals("1111"))
                hex.append('F');
        }
        return hex.toString();
    }   
    public static String decimalToBinary(int n)
    {
        String table[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
        return table[n];
    }
    public static StringBuffer asciiToHex(StringBuffer s)
    {
        StringBuffer temp = new StringBuffer();
        for(int i=0;i<s.length();i++)
            temp.append(StringOperations.leftPad(Integer.toString((int)s.charAt(i),16),2));
        return temp;
    }
    public static StringBuffer hexToAscii(StringBuffer s)
    {
        StringBuffer temp = new StringBuffer();
        for(int i=0;i<s.length()-1;i+=2)
                temp.append((char)Integer.parseInt(s.substring(i,i+2),16));
        return temp;
    }	
    public static StringBuffer add(StringBuffer s,int offset)
    {
        for(int i=0;i<s.length();i++)
            s.setCharAt(i,(char)(s.charAt(i)+offset));
        return s;
    }
}
