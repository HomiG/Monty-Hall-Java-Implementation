import java.util.Random;

public class Doors {
    int array[] = new int[3];
    Random rn = new Random(System.currentTimeMillis());
    boolean found;
   
   public void populateArray() {
       found=false;
       for (int i = 0; i < 3; i++) {
          array[i] = rn.nextInt(2) % 2;
          if (array[i] == 1) {
               break;
          }
       }
       if (array[1]==0 && array[0]==0)
            array[2]=1;
   }

   public void clearArray(){
        for(int i=0;i<3;i++){
            array[i]=0;
        }
    }
    
   public int openedDoor(int selectedDoor){
       int i;
       for(i=0; i<3; i++){
           if(array[i]==0  &&  i != selectedDoor)
                break;
       }
       if(i==3)
            return i-1;
       else
            return i;
    }
   public int swapDoor(int openedDoor, int firstSelectedDoor){
       if(openedDoor != 2 && firstSelectedDoor!=2)
            return 2;
       else if(openedDoor != 1 && firstSelectedDoor!=1)
            return 1;
       else
             return 0;
   }
   
   public int getWinningDoor(){
       int i;
       for(i=0; i<3; i++){
           if(array[i]==1)
                break;
       }
       return i;
    }
}
       








