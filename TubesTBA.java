/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubestba;

import java.util.Scanner;

/**
 *
 * @author afrianhanafi
 */
public class TubesTBA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean status = true;
        boolean first = true;
        boolean dhError = false;
        
        Scanner s = new Scanner(System.in);
        System.out.print("Input : ");
        String line = s.nextLine();
        
        if(line.length() == 1 && (line.charAt(0) == '+' || line.charAt(0) == '-' || line.charAt(0) == 'x' || line.charAt(0) == ':')) System.out.println("Error");
        else if((line.charAt(0) == 'x' || line.charAt(0) == ':') && Character.isDigit(line.charAt(1))) System.out.println("Error");
        else {
            for(String str : line.split(" ")){
                if(status && first && line.charAt(0) != 'E'){
                    States st = new States(str);
                    System.out.print(st.start()+" ");
                    if(st.stat != true) status = false;
                }
                else dhError = true;
            }
        }
        
        if(line.charAt(0) == 'E' && dhError) System.out.println("Error");
                  
    }
    
}
