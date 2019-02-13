import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import java.util.Random;


class Display {

  private Scanner input = new Scanner(System.in);
  // Get human's input for the board 
  int [] read_input()
  {
    int [] movement = new int[2];
    System.out.println("Enter X position :"); 
    movement[0]=get_input_position();
    System.out.println("Enter Y position :");
    movement[1]=get_input_position();
    return movement;
  }
  private int get_input_position()
  {
    int position;
    position = input.nextInt();
    while(position>2 || position<0){
      position = input.nextInt();
    }
    return position;
  }

  // Get computer's input for the board 
  int [] random_input()
  {
    Random rand = new Random(System.currentTimeMillis());
    int [] movement = new int[2];
    movement[0]=rand.nextInt(10000)%3;
    movement[1]=rand.nextInt(10000)%3;    
    return movement;
  }
 
  void print_board(Type [][] board )
  {
    for(int i = 0 ; i< 3 ; i++)
    {
      for (int j = 0; j<3 ; j++)
      {

        System.out.print(Type_to_String(board[i][j]));
      }
      System.out.println("");
    }
    System.out.println("");
  }

  // Convert type to string
  private String Type_to_String(Type type)
  {
    if(type==Type.O){return "O ";}
    else if (type == Type.X){return "X ";}
    return "．";
  }

  // ---------- Testing -----------
  public static void main(String[] args) {
    Display program = new Display();
    program.run();
  }

  // Run the tests
  private void run() {
    TestDisplayBoard();
    TestRandomInput();
    TestReadInput();
    TestTypeToString();
  }

  // Show the board on screen
  private void TestDisplayBoard(){
    Type [][] board = {{Type.O,Type.O,Type.X},
                       {Type.O,Type.O,Type.BLANK},
                       {Type.O,Type.X,Type.BLANK},
                      };
    print_board(board);
  }

  // Test user input
  private void TestReadInput(){
    int [] movement;
    movement = read_input();
    System.out.println("X position is "+movement[0]);
    System.out.println("Y position is "+movement[1]);
  }
  
  // Test computer input
  private void TestRandomInput(){
    int [] movement;
    movement = random_input();
    System.out.println("X position is "+movement[0]);
    System.out.println("Y position is "+movement[1]);
    movement = random_input();

  }

  // Test convert enumerate type to string
  private void TestTypeToString(){
    assert(Type_to_String(Type.O).equals("O "));
    assert(Type_to_String(Type.X).equals("X "));
    assert(Type_to_String(Type.BLANK).equals("．"));
  }
}
