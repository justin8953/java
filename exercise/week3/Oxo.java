import java.util.Arrays;
import java.util.Scanner; 

class Oxo {

  private Player player1 = new Player();
  private Player player2 = new Player();;
  private Board board = new Board();
  private Display display = new Display();
  private Scanner input = new Scanner(System.in);
  private int [] movement = new int[2];
  void set_player()
  {
    System.out.println("Please Choose first player is human or computer");
    set_single_player(player1);
    System.out.println("Please Choose Second player is human or computer");
    set_single_player(player2);
  }
  void set_single_player(Player player)
  {
    String playerType;
    playerType = input.nextLine();
    while (player.isHuman_or_Computer(playerType.toLowerCase())==PlayerType.ILEGAL){
      System.out.println("Invalid Typeing. Please Type human or computer");
      playerType= input.nextLine();
    }
    player.set_PlayerType(player.isHuman_or_Computer(playerType.toLowerCase()));
    System.out.println("Please Type your name");
    player.set_player_name(input.nextLine());
  }
  void set_player_choice()
  {
    String firstplayerChoice;
    System.out.println("First player : Please choose O or X ");
    firstplayerChoice = input.nextLine();
    while(player1.is_O_or_X(firstplayerChoice)==Type.ILEGAL)
    {
      firstplayerChoice = input.nextLine();
    }
    player1.set_O_or_cross(player1.is_O_or_X(firstplayerChoice));
    if (player1.is_O_or_X(firstplayerChoice)==Type.O){player2.set_O_or_cross(Type.X);}
    else{player2.set_O_or_cross(Type.O);}
  }
  void start()
  {
    boolean start = true;
    while(start==true)
    {
      System.out.print("Playe1 Move: ");
      move(player1,movement);
      display.print_board(board.get_board());
      if(board.game_result(player1.get_player_choice())!=Result.NONE){
        get_result(player1);
        start = next_round();
        continue;
      }
      System.out.print("Playe2 Move: ");
      move(player2,movement);
      display.print_board(board.get_board());
      if(board.game_result(player2.get_player_choice())!=Result.NONE){
        get_result(player2);
        start = next_round();
        continue;
      }
    }
  }
  boolean next_round()
  {
    int num;
    System.out.println("If playing next Round, Please type 1. Else type 0 to stop ");
    num = input.nextInt();
    while(num!=0&&num!=1)
    {
      System.out.println("Please type 1 to keep playing or type 0 to stop ");
    }
    if (num==1){
      board = new Board();
      return true;
    }
    return false;
  }
  void get_result(Player player)
  {
    if(board.game_result(player.get_player_choice())==Result.WIN)
    {
      System.out.println(player.get_player_name()+ " Win");
    }else if(board.game_result(player.get_player_choice())==Result.DRAW)
    {
      System.out.println("DRAW");
    }
  }
  
  void move(Player player, int [] movement)
  {
    if(player.get_player()==PlayerType.HUMAN)
    {
      movement = display.read_input();
      while (board.move_isvalid(movement[0], movement[1])==false)
      {
        movement = display.read_input();
      }
      board.move(player.get_player_choice(), movement[0], movement[1]);
      System.out.println("( "+movement[0]+", "+movement[1]+" )");
    }else{
      movement = display.random_input();
      while (board.move_isvalid(movement[0], movement[1])==false)
      {
        movement = display.random_input();
      }
      board.move(player.get_player_choice(), movement[0], movement[1]);
      System.out.println("( "+movement[0]+", "+movement[1]+" )");
    }
  }

	// ---------- Testing -----------
  public static void main(String[] args) {
    Oxo program = new Oxo();
  	program.run();
  }
  // Run the tests
  private void run() {
    set_player();
    set_player_choice();
    System.out.println("Player 1: "+player1.get_player()+" name: "+player1.get_player_name());
    System.out.println("Player 2: "+player2.get_player()+" name: "+player2.get_player_name());
    System.out.println("Game Start....");
    start();  
    System.out.println("Game End....");
  }
  
}
