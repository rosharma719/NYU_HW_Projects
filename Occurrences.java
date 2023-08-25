//Rohan Sharma, 12/6/22, program counts letters in a file

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Occurrences {
    public static void main(String[] args) {
        System.out.println("Enter the full file path: ");
        System.out.println("Format like " + "//C:/Users/________/Downloads/TheGoldBug1.txt");
        File f = new File(new Scanner(System.in).next()); //reader for the file

        if (!f.exists()) {
            System.out.println("This file doesn't exist");
            System.exit(1);
        }
        int[] arr = new int[26]; //array of characters
        String str = "";
        

        try {
            Scanner scan = new Scanner(f); 
            while (scan.hasNext()) { //has more characters
                str = scan.nextLine();
                    for (char x : str.toCharArray()) {
                        x = Character.toUpperCase(x);
                        if (isLetter(x)) {
                            arr[x - 'A']++; //if letter, appends to final string
                        }
                        
                    }
            }
            
            scan.close();
        }
        catch (FileNotFoundException ex) { //handles file exception
            ex.printStackTrace();
        }

        for (int x = 0; x < arr.length; x++) { //final print
            System.out.println((char)(x + 'A') + " occurrence = " + arr[x]);
        }

    }
    private static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z'); //checks if letter
    }
}