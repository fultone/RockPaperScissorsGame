import java.lang.Math.*;

public class ComputerPlayer implements Player{
   String selection;

   @Override
   public void makeSelection(){
      String[] options = {"rock", "paper", "scissors"};
      int randomIndex = (int)(Math.random()*3);
      selection = options[randomIndex];
   }

   @Override
   public String getSelection(){
      return selection;
   }
}
