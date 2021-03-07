package classicalcryptography;
import java.util.Scanner;

/*
For example:
The message is “MEET YOU IN THE PARK” 
First replace the letters in the message with numbers. This produces

MEET YOU IN THE PARK
12 4 4 19   24 14 20   8 13   19 7 4   15 0 17 10

15 7 7 22   1 17 23   11 16   22 10 7   18 3 20 13
Translating this back to letters produces the encrypted message is “PHHW BRX LQ WKH SDUN”
                                          the decrypted message is “MEET YOU IN THE PARK”

*/


public class ClassicalCryptography {

    public static void main(String[] args) {
        
        char charcacters[] = {'A','B','C','D','E','F','G','H','I','J','K','L',
                        'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("WARNING ==> You have to use ONE space for each letter \n"
                         + "   \t    and TWO space for each word while you enter the message.\n");
        
        System.out.print("Enter the secret numbers :");
        String pswrd = input.nextLine();
        
        String num[] = pswrd.split(" ");
        
        for(int i = 0; i<num.length; i++){
            
            System.out.print(num[i]+" ");
        }
        
        System.out.println("");
        char encrypted[] = new char[num.length];
        
        System.out.print("The encrypted message ==> ");
        for(int i= 0; i<num.length; i++){
            
            if("".equals(num[i])){ // if password has empty
                
                encrypted[i] = ' ';
                i++;
                System.out.print(" ");
            }
                
            
            encrypted[i] = charcacters[Integer.valueOf(num[i])]; 
            System.out.print(encrypted[i]+" ");
        }
        System.out.println("");
        
        char decrypted[] = new char[num.length];
        
        System.out.print("The decrypted message ==> ");
        for(int i = 0; i<num.length; i++){
            
            if("".equals(num[i])){ // if password has empty
                
                decrypted[i] = ' ';
                i++;
                System.out.print(" ");
            }
            
            
            switch ((Integer.valueOf(num[i])) - 3) {
                case -1:
                    decrypted[i] = 'Z';
                    System.out.print(decrypted[i]+" ");
                    i++;
                    break;
                case -2:
                    decrypted[i] = 'Y';
                    System.out.print(decrypted[i]+" ");
                    i++;
                    break;
                case -3:
                    decrypted[i] = 'X';
                    System.out.print(decrypted[i]+" ");
                    i++;
                    break;
                default:
                    break;
            }
            
            
            decrypted[i] = charcacters[(Integer.valueOf(num[i])) - 3];
            System.out.print(decrypted[i]+" ");
        }
        System.out.println("");
        
        
    }
    
}
