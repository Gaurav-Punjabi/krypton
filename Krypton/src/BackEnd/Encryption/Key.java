/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd.Encryption;

import BackEnd.Encryption.conversion.Conversion;
import BackEnd.Encryption.conversion.StringOperations;

/**
 *
 * @author gauravpunjabi
 */
public class Key {
    //The inout key.....
    public StringBuffer key = new StringBuffer("133457799BBCDFF1");
    //This is th 16 keys generated for performing Fiestal rounds...
    public StringBuffer K[] = new StringBuffer[16];
    //Matrix declaration...
    int PC1[][] = {{57,49,41,33,25,17,9},
                                    {1,58,50,42,34,26,18},
                                    {10,2,59,51,43,35,27},
                                    {19,11,3,60,52,44,36},
                                    {63,55,47,39,31,23,15},
                                    {7,62,54,46,38,30,22},
                                    {14,6,61,53,45,37,29},
                                    {21,13,5,28,20,12,4}};
    int PC2[][] = {{14,17,11,24,1,5},
                                    {3,28,15,6,21,10},
                                    {23,19,12,4,26,8},
                                    {16,7,27,20,13,2},
                                    {41,52,31,37,47,55},
                                    {30,40,51,45,33,48},
                                    {44,49,39,56,34,53},
                                    {46,42,50,36,29,32}};
    /*Default Constructor
    *	It initializes the Key value with the default value
    *	no parameters are required.
    */
    public Key()
    {
            generateKey();
    }
    /*Paramerterized constructor accepting the key from user
    * @param : key - String should be passed
    *	This function inputs the key from user and initializes the key with the respective given value
    	0100101
    */
    public Key(String key)
    {
            this.key = new StringBuffer(key);
            generateKey();
    }
    /*	Permute Function
    *	@param : s - StringBuffer the string that needs to be permuted
    *			 matrix - A 2 dimensional matrix that specifiest the values for permutation like - PC1/PC2
    *	This is a general method for permuting the given string it accepts any matrix in the Fiestal Round
    *	Hence it increases the efficency and reducing the lines of code.
    */
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
    /* genrateKey()
    * @param : no parameters are required
    * 	This functions the actual work for generating the keys and stores them in array of Key
    *	The user can access all these keys using getKeys() method.
    */
    public void generateKey()
    {
            String C,D;
            //Converting the string from hex To binary so that 64 bit blocks can be elected.
            key = Conversion.hexToBinary(key.toString());
            //Permuting the Binary 64 bit block with PC-1 according to the given algorithm
            key = permute(key,PC1);
            //Dividing the permuted block into 2 28 bit parts
            C = key.substring(0,28);
            D = key.substring(28);
            for(int i=0;i<16;i++)
            {
                    //Performing the leftshift operation for both of the 28 bit blocks
                    C = StringOperations.leftShift(C,1);
                    D = StringOperations.leftShift(D,1);
                    //permuting the concatination of both the blocks with PC-2 as per the algorithm and storing
                    //them into respective position in the Key 2 dimensional array:
                    K[i] = permute(new StringBuffer(C + D),PC2);
            }
    }
}
