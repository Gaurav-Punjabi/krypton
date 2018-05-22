/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Compression;

/**
 *
 * @author sahil-pradhan
 */
/*
****************************************************************************************************
                                            SYMBOL
****************************************************************************************************
    @author : Gaurav_Punjabi
    This is the Symbol Class which is used to represent the CodeWord and Pattern generated from the EncoderOutput Table.
****************************************************************************************************
*/
class Symbol implements Comparable<Symbol>
{

    /***********************************CONSTRUCTOR*************************************************
        @param : symbol : Accepts the string that represents the symbol.
                         code   : Accepts the code for the given symbol.
        The parameterized constructor that initializes the symbol and the symbol code.	
    */
    Symbol(final String symbol,final int code)
    {
        this.symbol = symbol;
        this.code = code;
    }

    /***********************************************************************************************
                                        SETTERS
    ***********************************************************************************************/
    /*
        @param : code : Accepts the code that needs to be set.
    */
    void setCode(final int code)
    {
        this.code = code;
    }

    /*
        @param : symbol : Accepts the symbol that needs to be set.
    */
    void setSymbol(final String symbol)
    {
        this.symbol = symbol;
    }

    /***********************************************************************************************
                                        GETTERS
    ***********************************************************************************************/
    /*
        @returns : symbol : The current symbol String of the object.
    */
    String getSymbol()
    {
        return this.symbol;
    }

    /*
        @returns : symbol : The current symbol String of the object.
    */
    int getCode()
    {
        return this.code;
    }

    /*
        @param : other : Accepts the Symbol object that needs to be compared with the callee object.
        @returns : int : return the difference between the 2 objects.
        This method Overrides the comapareTo object from the Comparable interface.
        It compares the String-symbol of the two objects and returns the difference between them.
    */
    @Override
    public int compareTo(final Symbol other)
    {
        return this.symbol.compareTo(other.getSymbol());
    }

    /*
        @returns : It Returns the string that best describes the current object.
        This method returns a string that describes the Symbol and the respective code.
    */
    @Override
    public String toString()
    {
        return "String = " + symbol + " Code = " + code;
    }

    /*----------------------------------------------------------------------------------------------
                                        VARIABLE INITIALIZATION
    ----------------------------------------------------------------------------------------------*/
    private int code;
    private String symbol;
}

