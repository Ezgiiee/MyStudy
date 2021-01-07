package classicalcryptography;

// 180315024

import java.util.Scanner;


// EZGİ EYİCE
// 1st Education

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
            
            if("".equals(num[i])){ // eğer şifrede boşluk varsa 
                
                encrypted[i] = ' ';
                i++;
                System.out.print(" ");
            }
                
            
            encrypted[i] = charcacters[Integer.valueOf(num[i])]; //girilen sayının rakam değerini alıyoruz
            System.out.print(encrypted[i]+" ");
        }
        System.out.println("");
        
        char decrypted[] = new char[num.length];
        
        System.out.print("The decrypted message ==> ");
        for(int i = 0; i<num.length; i++){
            
            if("".equals(num[i])){ // eğer şifrede boşluk varsa 
                
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
