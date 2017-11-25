import java.util.Scanner;

public class HumanPlayer implements Player{
   String selection;

   @Override
   public void makeSelection(){
      Scanner scan = new Scanner(System.in);
      System.out.print("What do you choose: rock, paper, or scissors? ");
      selection = scan.nextLine().toLowerCase();
      while(!selection.equals("rock") && !selection.equals("paper") && !selection.equals("scissors")){
         System.out.print("Please choose: rock, paper, or scissors: ");
         selection = scan.nextLine().toLowerCase();
      }

   }

   @Override
   public String getSelection(){
      return selection;
   }



}
