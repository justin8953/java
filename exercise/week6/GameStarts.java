import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GameStarts implements ActionListener {
   int numofcorrect = 0;
   boolean hasQuestion = true;
   JLabel question, number, score;
   JRadioButton selectA, selectB, selectC,selectD;
   JButton confirm, cancel;
   ButtonGroup bg; 
   Answer ans;
   GameStarts(JPanel panel,int num ,String q, String A, String B, String C, String D, Answer ans){
      Font  btnFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 22);
      Font  labelFont = new Font(Font.DIALOG, Font.PLAIN, 22);
      this.ans = ans;
      // Score Board
      JPanel top = new JPanel(new GridLayout(1,2));
      JLabel scorelabel = new JLabel("Score");
      score = new JLabel(Integer.toString(numofcorrect) );
      scorelabel.setFont(labelFont);
      score.setFont(labelFont);
      top.add(scorelabel);top.add(score);
      // Question 
      JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
      number = new JLabel("Q"+num);
      question = new JLabel(q);
      number.setFont(labelFont);
      question.setFont(labelFont);
      // Answer Row 
      firstRow.add(number); firstRow.add(question);
      JPanel secondRow = new JPanel(new GridLayout(2,2));
      selectA = new JRadioButton("A) " + A);
      selectB = new JRadioButton("B) " + B);
      selectC = new JRadioButton("C) " + C);
      selectD = new JRadioButton("D) " + D);
      secondRow.add(selectA);secondRow.add(selectB);
      secondRow.add(selectC);secondRow.add(selectD);
      JPanel lastRow = new JPanel(new GridLayout(1,2));
      ImageIcon confirmIcon = createImageIcone("/images/confirm.png", "Confirm");
      ImageIcon cancelIcon = createImageIcone("/images/leave.png", "Cancel");
      confirm = new JButton("Confirm",confirmIcon);
      confirm.addActionListener(this);
      confirm.setFont(btnFont);
      cancel = new JButton("Leave", cancelIcon);
      cancel.setFont(btnFont);
      lastRow.add(cancel);lastRow.add(confirm);
      bg = new ButtonGroup();
      bg.add(selectA);bg.add(selectB);bg.add(selectC);bg.add(selectD);
      panel.add(top);panel.add(firstRow);panel.add(secondRow);panel.add(lastRow);
   }
   private static ImageIcon createImageIcone (String path, String description)
   {
      if(path != null)
      {
         return new ImageIcon(GameStarts.class.getResource(path) , description);
      }else{
         System.err.println("Could not find file: " + path);
         return null;
      }
   }
   // Reset
   void noQuestion(){
      this.hasQuestion= false;
      this.numofcorrect=0;
      score.setText(Integer.toString(numofcorrect));
   }
   void correct(){
      numofcorrect++;
      score.setText(Integer.toString(numofcorrect));
   }
   void setNewQuestion(String q,int num, String A, String B, String C, String D, Answer ans){
      number.setText("Q"+num);
      question.setText(q);
      selectA.setText("A)" + A);
      selectB.setText("B)" + B);
      selectC.setText("C)" + C);
      selectD.setText("D)" + D);
      this.ans = ans;
   }
   boolean checkCorrect(){
      if(selectA.isSelected() && ans == Answer.A){
         return true;
      }
      else if(selectB.isSelected() && ans == Answer.B){
         return true;
      }
      else if(selectC.isSelected() && ans == Answer.C){
         return true;
      }
      else if(selectD.isSelected() && ans == Answer.D){
         return true;
      }
      return false; 
   }
   public void actionPerformed(ActionEvent e){
      if (e.getSource()==confirm && checkCorrect() && hasQuestion){
         correct();
      }      

   }
   public static void main(String args[]) {
      JFrame f = new JFrame("Test");
      JPanel p = new JPanel(new GridLayout(4,1));
      p.setBounds(50, 50, 500, 400);
      new GameStarts(p,1,"1+1=?","1","2","3","4", Answer.A);
      f.add(p);
      f.setSize(600, 600);
      f.setLayout(null);
      f.setVisible(true);
   }




}