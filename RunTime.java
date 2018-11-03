import java.util.Scanner;
import java.util.Random;
public class RunTime{

    public static void main(String args[]){
        
        Doors doors = new Doors();
        Scanner sc = new Scanner(System.in);
        Random rn = new Random(System.currentTimeMillis());
        int gameMode;
        int firstSelectedDoor;
        int openedDoor;
        int doorAfterSwap;
        int gamesWon=0;
        long roundsForSimulation;

        
        
        System.out.println("Simulations Starts.. \n \nPress 1 for Swapping Door or 2 for No-Swapping:" );
        
        do{
            gameMode = sc.nextInt();
            if(gameMode!=1 && gameMode!=2)
                System.out.println("I said, Press 1 OR 2!");
        }while(gameMode!=1 && gameMode!=2);
        if(gameMode == 1)
            System.out.println("\nSwapping Mode selected");
        else
            System.out.println("\nNo-Swapping Mode selected");
        
        System.out.println("\n\nHow many times do you want to run the simulation?");    
        roundsForSimulation = sc.nextInt();
        for(int j=1; j<=roundsForSimulation; j++){
            //inisializying doors

            doors.populateArray();
            
            //randomly choosing first door
            firstSelectedDoor = rn.nextInt(3);
            
            System.out.println("First Selected Door ");
            
            System.out.println("0\t1\t2");
            for(int k=0; k<firstSelectedDoor; k++)
            {
                System.out.print("\t");
            }
            System.out.println("^\n\n");
            
            
            
            //swapping and looking at the price
            if(gameMode == 1){
                //opening the goat Door
                openedDoor = doors.openedDoor(firstSelectedDoor); //open door returns 0,1,2 depending on which door is opened.
                System.out.println("Door Opened");
                System.out.println("0\t1\t2");
                for(int k=0; k<openedDoor; k++)
                {
                    System.out.print("\t");
                }
                System.out.println("X\n\n");
                
                
                // selectedDoor = doors.array[doors.swapDoor(openedDoor, firstSelectedDoor)];
                doorAfterSwap = doors.swapDoor(openedDoor, firstSelectedDoor);
                
                System.out.println("Door after swap ");
                System.out.println("0\t1\t2");
                for(int k=0; k<doorAfterSwap; k++)
                {
                    System.out.print("\t");
                }
                System.out.println("⇈\n\n");
                
                
                if(doors.array[doorAfterSwap] == 1)
                    System.out.println("WON!");
            }
            else 
                doorAfterSwap = firstSelectedDoor;
            
            if(doors.array[doorAfterSwap] == 1)    
                gamesWon++;
            
                

            System.out.println(" Door with price: " + doors.getWinningDoor() +"\n" + "Win Ratio: " + (((double)gamesWon/(double)j)*(double)100) +"%\nGames Won: " + gamesWon +
            "\nGames Played: " + j);
            System.out.println("--------------------------------------------------------------------------------------------");
            doors.clearArray();
        }
        System.out.println("\n\n\n\nBy Homer");
        
        System.out.println("\n\n Press any key to close the application..");
        try {
                System.in.read();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
}