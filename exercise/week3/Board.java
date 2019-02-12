import java.util.Arrays; 

class Board {
  private Type [][] board = new Type [3][3];
  Board() 
  {
    for (int i = 0 ; i < 3 ; i ++)
    {
      for (int j = 0; j< 3 ; j ++)
      {
        board[i][j] =  Type.BLANK; 
      }
    }
  }
  Result game_result(Type any)
  {
    if(col_has_three(any, 1, 0) || col_has_three(any, 1, 1)||col_has_three(any, 1, 2)){return Result.WIN;}
    else if (row_has_three(any, 0, 1) || row_has_three(any, 1, 1)||row_has_three(any, 2, 1)){return Result.WIN;}
    else if (cross_has_three(any,1,1)){return Result.WIN;}
    else if (!board_is_filled()){return Result.DRAW;}
    return Result.NONE;
  } 
  boolean board_is_filled()
  {
    boolean filled = false;
    for (int i= 0 ;i<3;i++)
    {
      for(int j=0 ; j<3;j++)
      {
        if (board[i][j]==Type.BLANK){filled=true;}
      }
    }
    return filled;
  }
  boolean col_has_three(Type any, int row,int col)
  {
    if( board[row-1][col] == any &&  board[row][col]==any && board[row+1][col]==any){return true;}
    return false;
  }
  boolean row_has_three(Type any, int row,int col)
  {
    if(board[row][col-1] == any && board[row][col]==any && board[row][col+1]==any){return true;}
    return false;
  }
  boolean cross_has_three(Type any, int row,int col)
  {
    if(board[row-1][col-1] == any && board[row][col]==any && board[row+1][col+1]==any){return true;}
    else if (board[row-1][col+1] == any && board[row][col]==any && board[row+1][col-1]==any){return true;}
    return false;
  }
  boolean move_isvalid (int row, int col)
  {
    if (board[row][col]==Type.BLANK){return true;}
    return false;
  } 
  void move (Type draw, int row, int col)
  {
    board[row][col] = draw;
  }
  Type [][] get_board(){return board;}

  // ---------- Testing -----------

  public static void main(String[] args) {
    Board program = new Board();
    program.run();
  }

  // Run the tests
  private void run() {
    TestInitialiseBoard();
    TestMoveValid();
    TestRowResult();
    TestColResult();
    TestCrossResult();
    TestResult();
    TestBoardFilled();
    System.out.println("All Pass...");
  }
  private void TestResult()
  {
    move(Type.O,0,0);
    move(Type.X,0,1);
    move(Type.O,0,2);
    move(Type.X,1,0);
    move(Type.O,1,1);
    move(Type.X,1,2);
    move(Type.O,2,0);
    move(Type.X,2,1);
    move(Type.O,2,2);
    assert(game_result(Type.O)==Result.WIN);
    move(Type.O,0,0);
    move(Type.X,0,1);
    move(Type.O,0,2);
    move(Type.X,1,0);
    move(Type.O,1,1);
    move(Type.X,1,2);
    move(Type.X,2,0);
    move(Type.O,2,1);
    move(Type.X,2,2);
    assert(game_result(Type.O)==Result.DRAW);
  }
  private void TestRowResult(){
    move(Type.O,0,0);
    move(Type.O,0,1);
    move(Type.O,0,2);
    assert(row_has_three(Type.O, 0, 1)==true);
    move(Type.O,1,0);
    move(Type.O,1,1);
    move(Type.O,1,2);
    assert(row_has_three(Type.O, 1, 1)==true);
    move(Type.O,2,0);
    move(Type.O,2,1);
    move(Type.O,2,2);
    assert(row_has_three(Type.O, 2, 1)==true);
  }
  private void TestCrossResult(){
    move(Type.O,0,0);
    move(Type.O,1,1);
    move(Type.O,2,2);
    assert(cross_has_three(Type.O, 1, 1)==true);
    move(Type.O,0,2);
    move(Type.O,1,1);
    move(Type.O,2,0);
    assert(cross_has_three(Type.O, 1, 1)==true);
  }
  // Testing Win or draw
  private void TestColResult()
  {
    move(Type.O,0,0);
    move(Type.O,1,0);
    move(Type.O,2,0);
    assert(col_has_three(Type.O, 1, 0)==true);
    move(Type.O,0,1);
    move(Type.O,1,1);
    move(Type.O,2,1);
    assert(col_has_three(Type.O, 1, 1)==true);
    move(Type.O,0,2);
    move(Type.O,1,2);
    move(Type.O,2,2);
    assert(col_has_three(Type.O, 1, 2)==true);
    
  }
  // Testing Intialisation the board to be blank 
  private void TestInitialiseBoard ()
  {
    Type [][] board1 = get_board();
    for (int i = 0; i< 3 ; i++)
    {
      for (int j = 0 ; j<3 ;j++)
      {
        assert(board1[i][j]==Type.BLANK);
      }
    }
  }
  // Testing drawing board is valid or not
  private void TestMoveValid ()
  {
    assert(move_isvalid(0,0)==true);
    move(Type.O, 1, 1);
    assert(move_isvalid(1,1)==false);
  } 
  private void TestBoardFilled()
  {
    for (int i=0;i<3;i++)
    {
      for (int j=0 ; j<3; j++)
      {
        board[i][j] = Type.O;
      }
    }
    assert(!board_is_filled()==true);
  }

}
