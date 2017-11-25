import java.util.Scanner;

public class Game {
   Player player1;
   Player player2;
   int gameMode;


   public void setUpGame(){
      Scanner scan = new Scanner(System.in);
      System.out.println("Let's play rock, paper, scissors!");
      System.out.print("Enter '1' to play Human vs. Human, " +
            "'2' to play Human vs. Computer, or '3' to player Computer vs. Computer: ");
      gameMode = scan.nextInt();

      while (gameMode != 1 && gameMode != 2 && gameMode != 3) {
         System.out.print("Enter 1, 2, or 3 to begin: ");
         gameMode = scan.nextInt();
      }
      initializePlayers(gameMode);
   }

   public void initializePlayers(int gameMode){
      if (gameMode == 1){
         player1 = new HumanPlayer();
         player2 = new HumanPlayer();
      } else if (gameMode == 2) {
         player1 = new HumanPlayer();
         player2 = new ComputerPlayer();
      } else if (gameMode == 3) {
         player1 = new ComputerPlayer();
         player2 = new ComputerPlayer();
      }
   }
   public void startGame(){
      player1.makeSelection();
      player2.makeSelection();
      gameCountdown();
      displaySelections();
      displayWinner();
   }

   public void gameCountdown(){
      String[] playGame = {"ROCK ", "PAPER ", "SCISSORS ", "SHOOT!\n"};
      for(int i=0; i<4; i++){
         System.out.print(playGame[i]);
         pauseTerminal();
      }
   }

   public void pauseTerminal(){
      try{
         Thread.sleep(500);
      } catch (InterruptedException e){

      }
   }

   public void displaySelections(){
      System.out.println("Player 1 selected: " + player1.getSelection());
      System.out.println("Player 2 selected: " + player2.getSelection());
   }

   public void displayWinner(){
      if(determineWinner() == player1){
         System.out.println("Player 1 wins!");
      } else if(determineWinner() == player2){
         System.out.println("Player 2 wins!");
      } else{
         System.out.println("It's a tie!");
      }
   }

   public Player determineWinner(){
      Player winner = new HumanPlayer();
      if(player1.getSelection().equals("rock")){
         if(player2.getSelection().equals("scissors")){
            winner = player1;
         } else if(player2.getSelection().equals("paper")){
            winner = player2;
         } else{
            // IT'S A TIE
         }
      } else if(player1.getSelection().equals("paper")){
         if(player2.getSelection().equals("rock")){
            winner = player1;
         } else if(player2.getSelection().equals("scissors")){
            winner = player2;
         } else{
            // IT'S A TIE
         }
      } else{
         if(player2.getSelection().equals("paper")){
            winner = player1;
         } else if(player2.getSelection().equals("rock")){
            winner = player2;
         } else{
            // IT'S A TIE
         }
      }
      return winner;
   }

   public boolean keepPlaying(){
      Scanner scan = new Scanner(System.in);
      System.out.println("Would you like to play again (y/n)?");
      String response = scan.nextLine().toLowerCase();
      while (!response.equals("y") && !response.equals("n")) {
         System.out.print("Type 'y' to play again or 'n' to quit: ");
         response = scan.nextLine().toLowerCase();
      }
      if (response.equals("n")) {
         return false;
      }
      return true;
   }


   public static void main(String args[]){
      Game game = new Game();
      boolean playAgain = true;

      while(playAgain) {
         game.setUpGame();
         game.startGame();
         playAgain = game.keepPlaying();
      }
   }

}

