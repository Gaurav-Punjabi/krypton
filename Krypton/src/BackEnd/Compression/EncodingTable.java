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
                                            ENCODING TABLE
****************************************************************************************************
    @author : Gaurav_Punjabi
    This is the Encoding Table class that contains the ArrayList of EncoderOuput and The Symbols.
    It provides methods to Add,Search and access these data-elements.
****************************************************************************************************
*/
public class EncodingTable {

    /*
        @param : representing : Accepts the string to set the representing character.
                         code 		  :	Accepts the code that represents the given string.
        This method adds the encoderOuput object with the associated values into the ecoderOuptut
        arrayList.
    */
    public void addEncoderOutput(final String representing,final int code)
    {
        this.encoderOutput.add(new EncoderOutput(representing,code));
    }

    /*
        @param : pattern 	: Accepts the string to set the pattern character.
                         codeWord 	: Accepts the code that represents the given string.
        This method adds the Symbol object with the associated values into the symbol
        arrayList.
    */
    public void addSymbol(final String pattern,final int codeword)
    {
        this.symbol.add(new Symbol(pattern,codeword));
    }

    /*
        @param   : representing : Accepts the string whose Code is required by the Callee object.
        @returns : int : It returns the Code of the respective given string from the encoderOuput objects
        This method searches the whole Array-List of EncoderOutput in a Linear search manner.
        If The object is foudn then it returns that object's code ,
        Otherwise it returns -1
        *************************************************************************************************
        Note - We didnt used binarySearch Method given by Collections class as it requires to sort the 
                   Arraylist first which would not be recommended in our case as insertion order is important
                   in this Algorithm.So we didnt used binarySearch 
                   rather we created our own custom Linear Search.
        ************************************************************************************************* 
    */
    public int getCode(final String representing)
    {
        for(int i=0;i<encoderOutput.size();i++)
        {
            if(encoderOutput.get(i).getRepresenting().equals(representing))
                return encoderOutput.get(i).getCode();
        }
        return -1;
    }

    /*
        @param   : pattern : Accepts the string whose Code is required by the Callee object.
        @returns : int : It returns the Code of the respective given string from the Symbol objects
        This method searches the whole Array-List of Symbol in a Linear search manner.
        If The object is found then it returns that object's codeWord ,
        Otherwise it returns -1
        *************************************************************************************************
        Note - We didnt used binarySearch Method given by Collections class as it requires to sort the 
                Arraylist first which would not be recommended in our case as insertion order is important
                in this Algorithm.So we didnt used binarySearch 
                rather we created our own custom Linear Search.
        ************************************************************************************************* 
    */
    public int getCodeWord(final String pattern)
    {
        for(int i=0;i<symbol.size();i++)
        {
            if(symbol.get(i).getSymbol().equals(pattern))
                return symbol.get(i).getCode();;
        }
        return -1;
    }

    /*
        @param : pattern   : Accepts the string that needs to be searched in the Symbol ArrayList.
        @returns : boolean : Returns true if the given String is found in the symbol ArrayList 
                                         otherwise it returns false.
        This method gets the Code of the given String and returns false if the code is -1 otherwise
        it returns true. 
    */
    public boolean searchPattern(final String pattern)
    {
        Integer code = getCodeWord(pattern);
        if(code < 0)
            return false;
        return true;
    }
    /*
        @param   : representin    : Accepts the string that needs to be searched in the 									EncoderOutput ArrayList.
        @returns : boolean        : Returns true if the given String is found in the encoder 								ArrayList otherwise it returns false.
        This method gets the Code of the given String and returns false if the code is -1 otherwise
        it returns true. 
    */
    public boolean searchString(final String representing)
    {
        Integer code = this.getCode(representing);
        if(code < 0)
            return false;
        return true;
    }

    /*
        @returns : List<Integer> : A List of Codes.
        This method returns all the codes in from the Encoder Output ArrayList int the Form of ArrayList of Integer.
    */
    public List<Integer> getList()
    {
        List <Integer> list = new ArrayList<>();
        for(EncoderOutput e : encoderOutput)
            list.add(e.getCode());
        return list;
    }

    /*
            @returns : It Returns the string that best describes the current object.
            This method returns a string that describes the Symbol and the Encoder Object.
    */
    @Override
    public String toString()
    {
        String s = "Symbol : ";
        for(Symbol sym : symbol){
            s += sym + ",";
        }
        s+= "\nEncoderOutput : ";
        for(EncoderOutput e : encoderOutput){
            s += e + ",";
        }
        return s;
    }

    /*
            This is just a method for Testing the current Class.......
    */
    private void unitTesting()
    {
        this.addEncoderOutput("B",66);
        this.addEncoderOutput("A",65);
        this.addEncoderOutput("BA",256);
        System.out.println("Testing encoder table with value of B " + this.getCode("B"));
        System.out.println("Testing encoder table with value that does not exits " + this.getCode("BAC"));
        this.addSymbol("BAA",256);
        this.addSymbol("ABA",257);
        System.out.println("Testing String table with value of exiting key : " + this.getCodeWord("ABA"));
        System.out.println("Testing String table with value of exiting key : " + this.getCodeWord("ABAC"));
        System.out.println("Testing ; " + this.searchPattern("BAA"));
        System.out.println("Testing : " + this.searchString("B"));
        System.out.println("Testing Patter : " + this.searchPattern("ASB"));
    }

    /*----------------------------------------------------------------------------------------------
                                                                            VARIABLE INITIALIZATION
    ----------------------------------------------------------------------------------------------*/
    private ArrayList <EncoderOutput> encoderOutput = new ArrayList<>();    
    private ArrayList <Symbol> symbol = new ArrayList<>();
}

