package game2;
import java.util.Scanner;

//Classic a hangman game
public class Game2 {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //the words of game
        String words[]={"istanbul","ankara","izmir","bursa","kocaeli",
                            "manisa",  "balikesir","tekirdag","edirne","sakarya",
                            "sinop","ordu","samsun","zonguldak","sivas",
                            "ardahan","kars","sanliurfa","rize","antalya",
                            "adana","hatay","gaziantep","mugla","aydin"  };
        //variables
        
        String usedLetters ,  wordToShow;
        String wordPrediction = "";
        
        int remaining ;  //the remaining right to guess
        int totalRight = 2;  // total right to guess kullanılmamaış
        
        char currentLetter,playAgain ;
        
        boolean completed , matchingLetter;
        
        
        // do-while loops (for game)
        
        do{
            
            int randomWord =(int)( Math.random()*(words.length));
            String selectedWord = words[randomWord];
            
            System.out.println("------WELCOME TO HANGAMAN GAME------\n");
            System.out.println("What is your name and surname ? ");
            String isim = input.nextLine();
            System.out.println("Secret Word ==> "+selectedWord);
            wordToShow = kelimeYazma(selectedWord);
            
            remaining = selectedWord.length()*2;
            completed = false;
            usedLetters = "";
            
            
            
            while(remaining>0 && !completed){
               
                System.out.println("WORD = "+wordToShow);
                System.out.print("Used Letters : ");
                
                if(usedLetters.length() == 0){
                    System.out.println(" none ");
                }
                else{
                    
                    for( int i = 0; i < usedLetters.length(); i++ )
                    {
                        System.out.print( usedLetters.charAt( i ) + " " );
                    }
                    
                    System.out.println( "\n" );
                    
                }
                System.out.println("Enter a letter. You have "+(remaining)+" left. Please enter 0 for guessing all word. ");
                
                do{
                    
                    currentLetter = input.next().charAt(0);
                    
                    if(currentLetter == '0'){
                            System.out.println("You can enter your guess. ");
                            wordPrediction = input.nextLine();
                            
                            
                            if(wordPrediction.equals(words[randomWord])){
                                
                                System.out.println("Correct! Please enter 0 for replay or enter 1 for exit. ");
                                
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
                    currentLetter = (char) Character.toLowerCase( (int) currentLetter );
                    
                }
                while( !yeniHarf( currentLetter, usedLetters ) || (int) currentLetter < 97 || (int) currentLetter > 122 || (int) currentLetter == 0 ); // 97: A and 122: Z in ASCII table
                
                matchingLetter = false;
                
                for(int i = 0; i<selectedWord.length(); i++){
                    
                    if(Character.toLowerCase(selectedWord.charAt(i)) == currentLetter){
                        
                        if( i == 0 )
                        {
                            wordToShow = currentLetter + wordToShow.substring( 1 );
                        }
                        else if( i == selectedWord.length() - 1 )
                        {
                            wordToShow = wordToShow.substring( 0, wordToShow.length() - 1 ) + currentLetter;
                        }
                        else
                        {
                            wordToShow = wordToShow.substring( 0, i ) + currentLetter + wordToShow.substring( i + 1 );
                        }
 
                        matchingLetter = true;
                        
                    }
                }
                if( !matchingLetter){
                    kalanHak--;
                }
                
                usedLetters = yeniHarfEkleme(usedLetters, currentLetter );
                
                completed = true;
                for( int i = 0; i < wordToShow.length(); i++ )
                {
                    if( wordToShow.charAt( i ) == '-' )
                    {
                        completed = false;
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
    
    // USING METHODS 
    
    public static String yeniHarfEkleme( String usedLetters, char currentLetter ){
        
        // GİRİLEN HARFLERİ ALFABETİK SIRAYA KOYMA
        int i;
 
        if( usedLetters.length() == 0 )
        {
            usedLetters = "" + currentLetter;
        }
        else
        {
            i = 0;
            while( i < usedLetters.length() && (int) usedLetters.charAt( i ) < (int) currentLetter )
            {
                i++;
            }
 
            if( i == usedLetters.length() )
            {
                usedLetters = usedLetters + currentLetter;
            }
            else
            {
                usedLetters = usedLetters.substring( 0, i ) + currentLetter + usedLetters.substring( i );
            }
        }
        return usedLetters;
    }
    
    
    public static boolean yeniHarf( char harf, String usedLetters )
    {
        for( int i = 0; i < usedLetters.length(); i++ )
        {
            if( usedLetters.charAt( i ) == harf )
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
