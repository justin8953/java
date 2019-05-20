import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
public class SelectMenu{   
   JButton createGame, startGame,resetGame;

   SelectMenu (JPanel panel){
      Font  btnFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 16);
      ImageIcon startIcon = createImageIcone("/images/start.png", "Start Game");
      ImageIcon createIcon = createImageIcone("/images/createQ.png", "Create Game");
      ImageIcon resetIcon = createImageIcone("/images/reset.png", "Reset Game");

      createGame = new JButton("Create a new game", createIcon); 
      startGame = new JButton("Start the game ",startIcon );  
      resetGame = new JButton("Reset the game", resetIcon);
      createGame.setFont(btnFont);  
      startGame.setFont(btnFont);
      resetGame.setFont(btnFont);  
      panel.add(createGame);
      panel.add(startGame);
      panel.add(resetGame);

   }
   private static ImageIcon createImageIcone (String path, String description)
   {
      if(path != null)
      {
         return new ImageIcon(SelectMenu.class.getResource(path) , description);
      }else{
         System.err.println("Could not find file: " + path);
         return null;
      }
   }
   public static void main (String[]args){
      JFrame f = new JFrame("Test");
      JPanel panel = new JPanel(new GridLayout(3,1));
      panel.setBounds(50,40, 300, 300);
      panel.setBackground(Color.CYAN);
      new SelectMenu(panel);
      f.add(panel);
      f.setSize(500, 550);
      f.setLayout(null);
      f.setVisible(true);
   }
}