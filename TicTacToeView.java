import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is a GUI interface for an in class
 * project for Debra Blackman.
 * 
 * @author Debra Blackman
 * 
 */
public class TicTacToeView 
{
    private static final String[]  place = {
            "UPPER LEFT",
            "UPPER CENTER",
            "UPPER RIGHT",
            "CENTER LEFT",
            "CENTER CENTER",
            "CENTER RIGHT",
            "LOWER LEFT",
            "LOWER CENTER",
            "LOWER RIGHT"};

    private TicTacToeGame game;
    private JFrame frame;
    private Container content;
    private JLabel result;
    private TTTButton[] cells;
    private JButton exitButton;
    private JButton initButton;
    private CellButtonHandler[] cellHandlers;
    private ExitButtonHandler exitHandler;
    private InitButtonHandler initHandler;

    private boolean ohs;
    private boolean gameOver;

    public TicTacToeView(TicTacToeGame thisGame)
    {
        game = thisGame;

        frame = new JFrame("Tic Tac Toe");
        frame.setSize(450, 600);

        //Get content pane
        content=frame.getContentPane();
        content.setBackground(Color.blue.darker());

        //Set layout
        content.setLayout(new GridLayout(4,3));

        //Create cells and handlers
        cells=new TTTButton[9];

        cellHandlers=new CellButtonHandler[9];
        for(int i=0; i<9; i++)
        {

            cells[i]=new TTTButton();
            cells[i].setFont(new Font("Arial",Font.PLAIN, 40));
            cells[i].setLocationText(place[i]);
            cellHandlers[i]=new CellButtonHandler();
            cells[i].addActionListener(cellHandlers[i]);
        }

        //Create init and exit buttons and handlers
        exitButton=new JButton("EXIT");
        exitHandler=new ExitButtonHandler();
        exitButton.addActionListener(exitHandler);
        initButton=new JButton("CLEAR");
        initHandler=new InitButtonHandler();
        initButton.addActionListener(initHandler);

        //Create result label
        result=new JLabel("O", SwingConstants.CENTER);
        result.setForeground(Color.white);

        //Add elements to the grid content pane
        for(int i=0; i<9; i++)
        {
            content.add(cells[i]);
        }
        content.add(initButton);
        content.add(result);
        content.add(exitButton);

        //Initialize
        init();
    }

    public void init()
    {
        ohs=true;               // O gets to start
        gameOver=false;         // game begins
        game.reset();           // ask game model to reset itself
        //Initialize text in buttons
        for(int i=0; i<9; i++)
        {cells[i].setText("");} //set text on cells to empty String
        result.setText("Os");   
        frame.setVisible(true);
    }

    private class CellButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(gameOver){return;}       //if game is over, ignore

            //Get button pressed
            TTTButton pressed=(TTTButton)(e.getSource());
            if (!pressed.getText().equals(""))  {return;}  //if cell occupied, ignore

            if(ohs)
            {pressed.setText("O");}
            else
            {pressed.setText("X");}

            game.markSquare(pressed.getLocationText(),pressed.getText());

            //Check for a winner
            if(game.checkWinner())
            {   
                gameOver=true;
                //Display winner message
                if(ohs)
                {result.setText("O wins!");}
                else
                {result.setText("X wins!");}
            }
            else
            {
                //Change player
                ohs=!ohs;
                //Display player message
                if(ohs)
                {result.setText("O");}
                else
                {result.setText("X");}
            }

        }
    }

    private class ExitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }

    private class InitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            init();
        }
    }

    /**
     * Special version of JButton that has additional field
     * for button location in English
     * 
     * @author Debra Blackman
     * @version 04/28/2015
     */
    public class TTTButton extends JButton
    {

        private String locationText;        //location of button in English

        /**
         * Constructor for objects of class TTTButton
         */
        public TTTButton()
        {
            locationText = "";
        }

        /**
         * get the location as English text
         *
         * @return     the location text in English
         */
        public String getLocationText()
        {
            return locationText;
        }

        public boolean setLocationText(String newLocationText)
        {
            locationText = newLocationText;
            return true;
        }
    }

}