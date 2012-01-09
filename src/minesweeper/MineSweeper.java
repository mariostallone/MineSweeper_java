/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import minesweeper.spots.Spot;

/**
 *
 * @author Mario Stallone
 */
public class MineSweeper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        MineGenerator generator = new MineGenerator();
        generator.generateMineField(4, 4);
        do {
            generator.drawMineField(4, 4);
            System.out.println("Mine?");
            String read = null;
            try 
            {
                read = InputReader.readString();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(MineSweeper.class.getName()).log(Level.SEVERE, null, ex);
            }
            int i = Integer.parseInt(Character.toString(read.charAt(0)));
            int j = Integer.parseInt(Character.toString(read.charAt(1)));
            Spot mine = generator.getMineField().getMines().get(i - 1).get(j - 1);
            mine.setOpen(true);
        } while (true);
    }
}