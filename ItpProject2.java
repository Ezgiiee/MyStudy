/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıtpproject2;

import java.util.Scanner;

/**
 *
 * @author Ezgi
 */
public class ItpProject2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // EZGİ EYİCE 180315024
        
        Scanner input = new Scanner(System.in);
        
        // Oyunun kelimeleri
        String kelimeler[]={"istanbul","ankara","izmir","bursa","kocaeli",
                            "manisa",  "balikesir","tekirdag","edirne","sakarya",
                            "sinop","ordu","samsun","zonguldak","sivas",
                            "ardahan","kars","sanliurfa","rize","antalya",
                            "adana","hatay","gaziantep","mugla","aydin"  };
        //Değişkenler
        
        String kullanılanHarfler ,  wordToShow;
        String uzunTahmin = "";
        
        int kalanHak ;
        int tahminHakkı = 2;
        
        char mevcutHarf,playAgain ;
        
        boolean tamamlanan , harfEslesti;
        
        // Oyunun kodları
        
        
        do{
            
            int randomKelime =(int)( Math.random()*(kelimeler.length));
            String secilenKelime = kelimeler[randomKelime];
            
            System.out.println("------WELCOME TO HANGAMAN GAME------\n");
            System.out.println("What is your name and surname ? ");
            String isim = input.nextLine();
            System.out.println("Secret Word ==> "+secilenKelime);
            wordToShow = kelimeYazma(secilenKelime);
            
            kalanHak = secilenKelime.length()*2;
            tamamlanan = false;
            kullanılanHarfler = "";
            
            
            
            while( kalanHak>0 && !tamamlanan){
               
                System.out.println("WORD "+wordToShow);
                System.out.print("Used Letters : ");
                
                if(kullanılanHarfler.length() == 0){
                    System.out.println(" none ");
                }
                else{
                    
                    for( int i = 0; i < kullanılanHarfler.length(); i++ )
                    {
                        System.out.print( kullanılanHarfler.charAt( i ) + " " );
                    }
 
                    System.out.println( "\n" );
                    
                }
                System.out.println("Enter a letter. You have "+(kalanHak)+" left. Please enter 0 for guessing all word. ");
                
                do{
                    
                    mevcutHarf = input.next().charAt(0);
                    
                    if(mevcutHarf == '0'){
                            System.out.println("You can enter your guess. ");
                            uzunTahmin = input.nextLine();
                            
                        
                            if(uzunTahmin.equals(kelimeler[randomKelime])){
                                
                                System.out.println("Correct! Please enter 0 for replay or enter 1 for exit. " );
                                
                                playAgain = input.next().charAt( 0 );
                                
                                if( playAgain == '0'){    //buraya bişey lazım
                                    continue;
                                    
                                }
                                else if ( playAgain == '1'){
                                    System.out.println("You left the game");
                                    System.exit(0);
                                }
                            }
                           
                    }        
                    mevcutHarf = (char) Character.toLowerCase( (int) mevcutHarf );
                    
                }
                while( !yeniHarf( mevcutHarf, kullanılanHarfler ) || (int) mevcutHarf < 97 || (int) mevcutHarf > 122 || (int)mevcutHarf == 0  ); // 97: A and 122: Z in ASCII table
                
                harfEslesti = false;
                
                for(int i = 0; i<secilenKelime.length();i++){
                    
                    if(Character.toLowerCase(secilenKelime.charAt(i)) == mevcutHarf){
                        
                        if( i == 0 )
                        {
                            wordToShow = mevcutHarf + wordToShow.substring( 1 );
                        }
                        else if( i == secilenKelime.length() - 1 )
                        {
                            wordToShow = wordToShow.substring( 0, wordToShow.length() - 1 ) + mevcutHarf;
                        }
                        else
                        {
                            wordToShow = wordToShow.substring( 0, i ) + mevcutHarf + wordToShow.substring( i + 1 );
                        }
 
                        harfEslesti = true;
                        
                    }
                }
                if( !harfEslesti){
                    kalanHak--;
                }
                
                kullanılanHarfler = yeniHarfEkleme(kullanılanHarfler, mevcutHarf );
                
                tamamlanan = true;
                for( int i = 0; i < wordToShow.length(); i++ )
                {
                    if( wordToShow.charAt( i ) == '-' )
                    {
                        tamamlanan = false;
                    }
                }
                
            }
            
            do
            {
                System.out.print( "Correct! Please enter 0 for replay or enter 1 for exit. : " );
                playAgain = input.next().charAt( 0 );
            }
            while( playAgain != '1' && playAgain != '0' );
 
            if( playAgain == '0' )
            {
                // yeni oyuna başlayınca bırakılan boşluk
                for( int i = 0; i < 10; i++ )
                {
                    System.out.println();
                }
                System.out.println("NEW GAME ");
            }
            
            
        }
        while( playAgain != '1' );
    
        System.out.println( "\nYou left the game... " );
        System.out.println();    
        }
    
    // METOTLAR
    
    public static String yeniHarfEkleme( String kullanılanHarfler, char mevcutHarf ){
        
        // GİRİLEN HARFLERİ ALFABETİK SIRAYA KOYMA
        int i;
 
        if( kullanılanHarfler.length() == 0 )
        {
            kullanılanHarfler = "" + mevcutHarf;
        }
        else
        {
            i = 0;
            while( i < kullanılanHarfler.length() && (int) kullanılanHarfler.charAt( i ) < (int) mevcutHarf )
            {
                i++;
            }
 
            if( i == kullanılanHarfler.length() )
            {
                kullanılanHarfler = kullanılanHarfler + mevcutHarf;
            }
            else
            {
                kullanılanHarfler = kullanılanHarfler.substring( 0, i ) + mevcutHarf + kullanılanHarfler.substring( i );
            }
        }
        return kullanılanHarfler;
    }
    
    
    public static boolean yeniHarf( char harf, String kullanılanHarfler )
    {
        for( int i = 0; i < kullanılanHarfler.length(); i++ )
        {
            if( kullanılanHarfler.charAt( i ) == harf )
            {
                return false;
            }
        }
        return true;
    }
    
    
    public static String kelimeYazma( String kelime )
    {
        String result = "";
         
        for( int i = 0; i < kelime.length(); i++ )
        {
            if( kelime.charAt( i ) == ' ' )
            {
                result = result + " ";
            }
            else
            {
                result = result + "-";
            }
        }
 
        return result;
    }
    
        
        
    
    
}
