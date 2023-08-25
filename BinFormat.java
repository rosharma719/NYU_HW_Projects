//Rohan Sharma, 11/29/22, program prompts user to enter binary string and converts to decimal if possible, throws binary format exception

import java.util.Scanner;

public class BinFormat {
    public static void main(String[] args) {
        //main method
        //creating scanners, calling method etc
        Scanner scan = new Scanner(System.in); 
		System.out.println("Enter a binary string");
        String str = scan.nextLine(); 
       
        int i = bin2Dec(str); 
        System.out.println(i); 
        scan.close(); 
    }

    //converter method
	public static int bin2Dec(String binaryString) throws BinaryFormatException {
		int result = 0;

        //for loop that converts to integer
		for (int x = 0, y = binaryString.length() - 1; x < binaryString.length(); x++, y--) {
			if (binaryString.charAt(x) != '0' && binaryString.charAt(x) != '1') {
				throw new BinaryFormatException("Not a binary string");
            }
			result += (Integer.parseInt(String.valueOf(binaryString.charAt(x)))) * Math.pow(2, y);
		}
		
        
        return result;
	} 
}
class BinaryFormatException extends IllegalArgumentException {
    BinaryFormatException(String s) {
        super(s);
    }
}