/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mario Stallone
 */
public class InputReader 
{   
    public static String readString() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String read = br.readLine();
        return read;
    }
    public static char readCharacter() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char read = (char) br.read();
        return read;
    }
}
