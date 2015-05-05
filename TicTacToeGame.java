
/**
 * This class makes the TicTacToe game itself
 * function. It takes in data from the TicTacToeView
 * class and places that data in an array simulation
 * of the gameboard.
 * 
 * @author Samuel Lowry 
 * @version 2015.05.05
 */
public class TicTacToeGame
{
    //field for the GUI class
    private TicTacToeView view;
    //inits the board array simulation
    private String[][] board;
    /*
     *inits an array equivalent to the array for
     *the board to store which locations have been
     *selected.
     */
    private boolean[][] marked;
    
    
    /**
     * Constructor for the TicTacToeGame. 
     * Inits the board array as a 3x3 array
     * and marked array as a 3x3 array.
     * Inits the GUI for the game as well.
     * 
     */
    public TicTacToeGame()
    {
        board = new String[3][3];
        marked = new boolean[3][3]; 
        view = new TicTacToeView(this);
        
        
    }
    
    /**
     *  Method that combines the three other check methods to check
     *  for a winner with a boolean value.
     *  
     *  @return boolean
     * 
     */
    public boolean checkWinner()
    {
        return (checkRow() || checkCol() || checkDiag());

    }
    
    /**
     * Method checking the rows for a winner.
     * 
     * @return boolean
     * 
     */
    public boolean checkRow()
    {
        for(int row = 0; row  < 3; row++)
        {
            if(checker(board[0][row], board[1][row], board[2][row]))
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Method to check the columns for a winner.
     * 
     * @return boolean
     * 
     */
    public boolean checkCol()
    {
        for(int col = 0; col  < 3; col++)
        {
            if(checker(board[col][0], board[col][1], board[col][2]))
            {
                return true;
            }
        }
        
        return false;

    }
    
    /**
     * Method to check the diagonals for a winner.
     * 
     * @return boolean
     * 
     */
    public boolean checkDiag()
    {
        for(int row = 0; row  < 3; row++)
        {
            if(checker(board[0][0], board[1][1], board[2][2]) || checker(board[0][2], board[1][1], board[2][0]))
            {
                return true;
            }
        }
        
        return false;

    }
    
    /**
     * Method used by the check methods to cycle through the
     * array and check for any 3 in a row of 'x's or 'o's.
     * 
     * @return boolean
     * 
     */
    public boolean checker(String m1, String m2, String m3)
    {
        return ((m1 != null) && (m1.equals(m2)) && (m2.equals(m3)));
        
        
    }
    
    /**
     * Method containing a collection of if statements to be given
     * a location in english. It matches the given statements to a set
     * position in the array. It is also passed a value of 'x' or 'o'
     * for which player is currently playing. It also contains a check
     * for whether or not the square seleted is already marked or not.
     * If not, returns false.
     * 
     * @return boolean
     * @param
     * 
     */
    public boolean markSquare(String location, String xo )
    {
        
           if(location.equals("UPPER LEFT"))
           {    
               
               if(!marked[0][0] == true)
               {
                   board[0][0] = xo;
                   return true;
               }
               marked[0][0] = true;

           }
           if(location.equals("UPPER CENTER"))
           {    
               
               if(!marked[1][0] == true)
               {
                   board[1][0] = xo;
                   return true;
               }
               marked[1][0] = true;
           }
           if(location.equals("UPPER RIGHT"))
           {    
               
               if(!marked[2][0] == true)
               {
                   board[2][0] = xo;
                   return true;
               }
               marked[2][0] = true;
           }
           if(location.equals("CENTER LEFT"))
           {
               
               if(!marked[0][1] == true)
               {
                   board[0][1] = xo;
                   return true;
               }
               marked[0][1] = true;
           }
           if(location.equals("CENTER CENTER"))
           {
               
               if(!marked[1][1] == true)
               {
                   board[1][1] = xo;
                   return true;
               }
               marked[1][1] = true;
           }
           if(location.equals("CENTER RIGHT"))
           {
               
               if(!marked[2][1] == true)
               {
                   board[2][1] = xo;
                   return true;
               }
               marked[2][1] = true;
           }
           if(location.equals("LOWER LEFT"))
           {
               
               if(!marked[0][0] == true)
               {
                   board[0][2] = xo;
                   return true;
               }
               marked[0][2] = true;
           }
           if(location.equals("LOWER CENTER"))
           {
               
               if(!marked[0][0] == true)
               {
                   board[1][2] = xo;
                   return true;
               }
               marked[1][2] = true;
           }
           if(location.equals("LOWER RIGHT"))
           {
               
               if(!marked[0][0] == true)
               {
                   board[2][2] = xo;
                   return true;
               }
               marked[2][2] = true;
           }
           return false;
           
        
    }
    
    /**
     * Method to reset and clear the board and marked arrays.
     * 
     */
    public void reset()
    {
        //sets the board array to null
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                board[col][row] = null;
            }
        }
        //sets the marked array to null
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 3; col++)
            {
                marked[col][row] = false;
            }
        }
    }

}
