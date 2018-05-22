/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Compression;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sahil-pradhan
 */
/*
****************************************************************************************************
                                            COMPRESSION
****************************************************************************************************
    @author : Gaurav_Punjabi
    This is the Compression class performs the main LZW style compression of the given string.
    It provides methods like compress and decompress of the given string.
    ------------------------------------------------------------------------------------------------
                                        Limpel-Ziv-Welch-Algorithm
    This algroithm runs on the basis of repition of phrases in the character rather than repition of characters like Huffman.

    <->->->->->->COMPRESSION ALGORTIHM***********************************************************
        First we traverse the string in one iteration.
        We do the following steps when we encounter a character.
        Step 1 : Check if the character is present in the encoderOutput Table or not.
                        If Yes then go to Step 2 else go to Step 3.
        Step 2 : Append The next Character with the current Character and repeat Step 1.
        Step 3 : Check if the current String is present in the Symbol Table or not.
                        If Yes Then add That String and string's Code to the EncoderTable and move forward to next string and repeat Step 1 until EndOfString, If it is not present then go to Step 4.
        Step 4 : Remove The last character from the string and add it to the Encoder Table 
                        with its code.

    <->->->->->->DE-COMPRESSION ALGORTIHM*********************************************************
        First we traverse the String of codes in one iteration.
        We do the following steps when we encounter a Code.
        Step 1 : If The Code is less than 256 then directly add it to the encoder Table 
                         otherwise add String from the Symbol Table that has the code same as the encountered Code and Goto Step 2.
        Step 2 : Add a string to the Symbol Table that has The code incremented by the 		     previous row's value and String as the combination of The previous row's 		   String in the encoder output table and the first character of the String 		 in the encoder Output Table and repeat Step 1 until EndOfString. 		
    -----------------------------------------------------------------------------------------------
****************************************************************************************************
*/

public class Compression 
{
    /*
        @author : Gaurav_Punjabi
        This Constructor is used to initialise the encoding Table object.
    */
    public Compression()
    {
        this.encodingTable = new EncodingTable();
    }
    private int performEntry(final int start,final int end)
    {
        String stringToEnter = dataToCompress.substring(start,end);
        if(encodingTable.searchString(stringToEnter) && (end+1) <= dataToCompress.length())
                return performEntry(start,end+1);
        else if(encodingTable.searchPattern(stringToEnter)) 
        {
                encodingTable.addEncoderOutput(stringToEnter,encodingTable.getCodeWord(stringToEnter));
                return end;
        }
        return -1;
    }
    private void enterPattern(final int start,final int end,final int codeWord)
    {
        if((end+1) <= dataToCompress.length())
        {
                encodingTable.addSymbol(dataToCompress.substring(start,end+1),codeWord);
        }
    }
    private List<Integer> encode(final String dataToCompress)
    {
        this.dataToCompress = dataToCompress;
        int start = 0,end = 1,temp;
        int codeWord = 512;
        while(end <= dataToCompress.length())
        {
                temp = performEntry(start,end);
                if(temp == -1)
                {
                        encodingTable.addEncoderOutput(dataToCompress.substring(start,end),(int)dataToCompress.charAt(start));
                        enterPattern(start,end,codeWord++);
                        start = end;
                }
                else
                {
                        enterPattern(start,temp,codeWord++);
                        start = temp;
                }
                end = start + 1;
        }
        return encodingTable.getList();
    }
    private String listToString(List<Integer> list)
    {
        String s = "";
        for(int x : list)
                s += (char)x;
        return s;
    }
    private List<Integer> stringToList(String dataToDecompress) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<dataToDecompress.length();i++) {
            list.add((int)dataToDecompress.charAt(i));
        }
        return list;
    }
    public String compress(final String dataToCompress)
    {
        List <Integer> codeList = encode(dataToCompress);
        String compressedData = listToString(codeList);
        return compressedData;
    }
    public String decompress(final String dataToDecompress) {
        List<Integer> codeList = stringToList(dataToDecompress);
        String decompressedData = listToString(codeList);
        return this.dataToCompress;
    }
    private String dataToCompress;
    private EncodingTable encodingTable;
}
