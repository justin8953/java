import java.util.Arrays; 

class Board {
  Type [][] board = new Type [3][3];
  
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
  boolean col_has_three(Type any, int row,int col)
  {
    if(board[row-1][col] == any && board[row][col] && board[row+1][col]){return true;}
    return false
  }
  boolean row_has_three(Type any, int row,int col)
  {
    if(board[row][col-1] == any && board[row][col] && board[row][col+1]){return true;}
    return false
  }
  boolean crow_has_three(Type any, int row,int col)
  {
    if(board[row-1][col-1] == any && board[row][col] && board[row+1][col+1]){return true;}
    else if (board[row-1][col+1] == any && board[row][col] && board[row+1][col-1]){return true;}
    return false
  }
  boolean check_is_valid_draw (int row, int col)
  {
    if (board[row][col]==Type.BLANK){return true;}
    return false;
  } 
  void draw_noughts_and_crosses (Type draw, int row, int col)
  {
    board[row][col] = draw;
  }

  // ---------- Testing -----------

  public static void main(String[] args) {
    Board program = new Board();
    program.run();
  }

  // Run the tests
  private void run() {
    test_initialise_board();
    test_drawboard_isvalid();

  }
  // Testing Intialisation the board to be blank 
  private void test_initialise_board ()
  {
    Board board1 = new Board ();
    for (int i = 0; i< 3 ; i++)
    {
      for (int j = 0 ; j<3 ;j++)
      {
        assert(board1.board[i][j]==Type.BLANK);
      }
    }
  }
  // Testing drawing board is valid or not
  private void test_drawboard_isvalid ()
  {
    assert(check_is_valid_draw(0,0)==true);
    draw_noughts_and_crosses(Type.O, 1, 1);
    assert(check_is_valid_draw(1,1)==false);
  } 

}
