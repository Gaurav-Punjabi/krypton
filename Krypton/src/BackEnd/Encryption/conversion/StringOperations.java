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
public class StringOperations
{
    public static String leftShift(String s,int noOfTimes)
    {
        for(int i=0;i<noOfTimes;i++)
            s = s.substring(1,s.length()) + s.charAt(0);
        return s;
    }
    public static StringBuffer exOr(StringBuffer s,StringBuffer t)
    {
        StringBuffer temp = new StringBuffer();
        for(int i=0;i<s.length();i++)
            temp.append((Integer.parseInt(s.charAt(i) + "") ^ Integer.parseInt(t.charAt(i) + "")));
        return temp;
    }
    public static StringBuffer exNor(StringBuffer s,StringBuffer t)
    {
        StringBuffer temp = new StringBuffer();
        for(int i=0;i<s.length();i++)
            temp.append(((Integer.parseInt(s.charAt(i) + "") ^ (Integer.parseInt(t.charAt(i) + ""))) == 1)?0:1);
        return temp;
    }
    public static StringBuffer rightPad(StringBuffer s,int noOfTimes)
    {
        for(int i=0;i<noOfTimes;i++)
            s.append("0");
        return s;
    }
    public static String leftPad(String s,int noOfTimes)
    {
        StringBuffer temp = new StringBuffer(s);
        for(int i=0;i<noOfTimes-s.length();i++)
            temp.insert(0,'0');
        return temp.toString();
    }
}
