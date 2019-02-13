import java.util.Arrays; 

class Player {

  private PlayerType player;
  private String Playername; 
  private Type O_or_X; 

  void set_player_name(String name){Playername = name;}
  void set_PlayerType (PlayerType any){player = any;}
  void set_O_or_cross (Type any){O_or_X = any;}

  PlayerType get_player(){return player;}
  Type get_player_choice(){return O_or_X;}
  String get_player_name(){return Playername;}

  // Check is human or computer
  PlayerType isHuman_or_Computer(String input)
  {
     if (input.equals("human")){return PlayerType.HUMAN;}
     else if (input.equals("computer")){return PlayerType.COMPUTER;}
     return PlayerType.ILEGAL;
  }

  // Check player choose O or X
  Type is_O_or_X(String input)
  {
      if (input.equals("O")){return Type.O;}
      else if (input.equals("X")){return Type.X;}
      return Type.ILEGAL;
  }

  // ---------- Testing -----------
  // Run the tests
  public static void main(String[] args) {
   Player program = new Player();
   program.run();
 }
  private void run() {
     TestSetPlayerType();
     TestSetPlayerChoice();
     TestSetPlayerName();
     TestGetPlayerType();
     TestGetPlayerChoice();
     TestGetPlayerName();
     System.out.println("All Pass...");

  }

  void TestSetPlayerName()
  {
     set_player_name("Justin");
     assert(Playername.equals("Justin"));
  }

  void TestGetPlayerName()
  {
      set_player_name("Justin");
      assert(get_player_name().equals("Justin"));
  }

  void TestSetPlayerType()
  {
     set_PlayerType(PlayerType.HUMAN);
     assert(player==PlayerType.HUMAN);
     set_PlayerType(PlayerType.COMPUTER);
     assert(player==PlayerType.COMPUTER);
  }

  void TestGetPlayerType()
  {
     set_PlayerType(PlayerType.HUMAN);
     assert(get_player()==PlayerType.HUMAN);
     set_PlayerType(PlayerType.COMPUTER);
     assert(get_player()==PlayerType.COMPUTER);
  }

  void TestSetPlayerChoice()
  {
      set_O_or_cross(Type.O);
      assert(O_or_X==Type.O);
      set_O_or_cross(Type.X);
      assert(O_or_X==Type.X);
  }
  
  void TestGetPlayerChoice()
  {
      set_O_or_cross(Type.O);
      assert(get_player_choice()==Type.O);
  }
}