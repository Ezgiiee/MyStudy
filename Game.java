package game;

// Zar atma oyunu
// iki oyuncu sırayla zar atıyorlar belli kurallar çerçevesinde 100 adımlık oyunda ilerliyorlar ve ilk 100'e ulaşan kazanıyor.

public class Game {

    public static void main(String[] args) {
        
        int player1,player2 ;
        
        String firstPlayer = "";
        String secondPlayer = "";
        
        // Büyük zar atan oyuna başlar.
        // Başlangıçta ikiside 0 olduğu için METHODUN içine 0 yazıyoruz.
        
        if("A".equals(whoStarts(0, 0))){
            firstPlayer =  "A";
            secondPlayer = "B";
            
        }
        else {
            firstPlayer = "B";
            secondPlayer = "A";
        }
            
        
        int sum1 = 0,sum2 = 0;
        int move1 = 0,move2 = 0;
        int round = 1;
        
        do{
            
            player1 = 1 + (int)(Math.random()*6); // ilk oyuncunun attığı zar
            
            System.out.println((round)+". round ("+firstPlayer+") = "+player1);
            sum1 += player1;  //attığı zar değerlerini topluyoruz
            move1++;
            
            System.out.println("Player "+firstPlayer+" your place ==> "+sum1);
            
            if(twoDigit(sum1)){ // 2 basamaklı sayı asallık kontrolü
                
                if( isPrime(sum1) ){
                
                sum1 = sum1 - 1;
                System.out.println("Player "+firstPlayer+" --- Your new place ==> "+sum1);
                move1++; // hareket sayısı 1 artıyor
                }
                
            }
            if( divisible10(sum1) ){  //10'a bölünebilme kontrolü
                
                sum1 = sum1 -2;
                System.out.println("Player "+firstPlayer+" --- Your new place ==> "+sum1);
                move1++; // hareket sayısı 1 artıyor
            }
            
            
            
            player2 = 1 + (int)(Math.random()*6);  // ikinci oyuncunun attığı zar değeri
            
            System.out.println((round)+". round ("+secondPlayer+") = "+player2);
            sum2 += player2; // zar değerlerini topluyoruz ki oyundaki yeri belli olsun
            move2++;
            
            System.out.println("Player "+secondPlayer+" your place ==> "+sum2);
            
            if(twoDigit(sum2)){ // 2 basamaklı sayı asallık kontrolü
                
                if( isPrime(sum2) ){
                
                sum2 = sum2 - 1;
                System.out.println("Player "+secondPlayer+" --- Your new place ==> "+sum2);
                move2++;
                }
            }
            
            if( divisible10(sum2) ){ // 10'a bölünebilme kontrolü
                
                sum2 = sum2 -2;
                System.out.println("Player "+secondPlayer+" --- Your new place ==> "+sum2);
                move2++;
            }
            
            round++; // oyunun bitebilme ihtimaline karşı burda, atılan zar sayısını artırıyoruz
            
            if(sum1>=100 && sum2>=100){ // oyun berabere biterse
                
                System.out.println("\nThe Game is tied...");
                System.out.println("\nThe Player "+firstPlayer+" get moved "+move1+" times during the game.");
                System.out.println("The Player "+secondPlayer+" get moved "+move2+" times during the game.");
                break;
            }
            if(sum1 >=100){  // ilk oyuncunun kazanma kontrolü
                
                System.out.println("\nTHE WINNER IS PLAYER "+firstPlayer+"...\n");
                System.out.println("The Winner get moved "+move1+" times during the game.");
                System.out.println("The Loser get moved "+move2+" times during the game.");
                break;
            }
            if(sum2 >=100){  // ikinci oyuncunun kazanma kontrolü
                
                System.out.println("\nTHE WINNER IS PLAYER "+secondPlayer+"...\n");
                System.out.println("The Winner get moved "+move2+" times during the game.");
                System.out.println("The Loser get moved "+move1+" times during the game.");
                break;
            }
            
            
        }while(true);
        
        System.out.println("Totally, "+ --round + " time was the dice rolled.");
        
        
    }
    
    public static String whoStarts(int p1,int p2){
        
        p1 = 1 + (int)(Math.random()*6); // 1. oyuncunun attığı zar
        
        p2 = 1 + (int)(Math.random()*6); // 2. oyuncunun attığı zar
        
        System.out.println("Player A = "+p1);
        System.out.println("Player B = "+p2);
        
        if(p1>p2){
            System.out.println("\nFirst, Player A starts to game.\n");
            return "A";
            
        }
        else if (p2>p1){
            System.out.println("\nFirst, Player B starts to game.\n");
            return "B";
        }
        else{
            System.out.println("Again...");
            whoStarts(p1, p2); // zarlar aynı gelirse tekrar atmaları için RECURSIVE FUNCT.
        }
        return "";
    }
    
    // 2 basamaklı olma kontrolü methodu
    public static boolean twoDigit(int number){
        
        int digit = 0;
        
        while(number != 0){
            
            number = number/10; // sayıyı kaç kere 10'a bölebildiğimizi hesaplayarak digit sayısını buluyoruz
            digit++;
        }
        
        if(digit == 2){
            return true;
        }
        
        return false;
    }
    
    public static boolean isPrime(int number){
        
        for(int i = 2; i<number; i++){
            
            if(number % i == 0)  // sayı kendisi dışında bir sayıya bölünüyorsa prime değil
                return false;
        }
        
        System.out.println("İs Prime Number... Move back to one step.");
        
        return true;
        
    }
    // 10'a bölünebilme kontrolü yapan method
    public static boolean divisible10(int number){
        
        boolean divided = false;
        
        if(number % 10 == 0){
            
            System.out.println("Go back to 2 steps due to your place is dividing by 10 ("+number+")");
            divided = true;
            return divided;
        }
        
        return divided;
    }
}
