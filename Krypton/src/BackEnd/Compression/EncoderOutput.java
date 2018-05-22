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
                                            ENCODER-OUTPUT
****************************************************************************************************
    @author : Gaurav_Punjabi
    This is the Encoder Output Class which is used to represent the Code and Representing String.
****************************************************************************************************
*/
class EncoderOutput implements Comparable<EncoderOutput>
{
    /***********************************CONSTRUCTOR*************************************************
        @param : representing : Accepts the string to set the representing character.
                         code 		  :	Accepts the code that represents the given string.
        This is the parameterized Constructor
    ************************************************************************************************
    */
    EncoderOutput(String representing,int code)
    {
        this.representing = representing;
        this.code = code;
    }

    /***********************************************************************************************
                                            SETTERS
    ***********************************************************************************************/
    /*
        @param : code : Accepts the code that needs to be set.
    */
    void setCode(int code)
    {
        this.code = code;
    }

    /*
        @param : representing : Accepts the representing String that needs to be set.
    */
    void setRepresenting(String representing)
    {
        this.representing = representing;
    }


    /***********************************************************************************************
                                            GETTERS
    ***********************************************************************************************/
    /*
        @returns : representing : The current representing String of the object.
    */
    String getRepresenting()
    {
        return this.representing;
    }
    /*
        @returns : code : The current code of the object.
    */
    int getCode()
    {
        return this.code;
    }

    /*
        @param : other : Accepts the Encoder-object that needs to be compared with the callee 						 object.
        @returns : int : return the difference between the 2 objects.
        This method Overrides the comapareTo object from the Comparable interface.
        It compares the String-representing of the two objects and returns the difference between them.
    */
    @Override
    public int compareTo(final EncoderOutput other)
    {
        return this.representing.compareTo(other.getRepresenting());
    }

    /*
        @returns : It Returns the string that best describes the current object.
        This method returns a string that describes the Representing String and the respective code.
    */
    @Override
    public String toString()
    {
        return "String = " + representing + " Code = " + code;
    }

    /*----------------------------------------------------------------------------------------------
                                            VARIABLE INITIALIZATION
    ----------------------------------------------------------------------------------------------*/
    private int code;	    
    private String representing;
}

