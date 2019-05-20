import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
class Integrate implements ActionListener, WindowListener {
   JFrame main;
   TopMenu file;
   JPanel mainpanel;
   JPanel gamepanel;
   int number = 0 ;
   SelectMenu smenu;
   QuestionCreate cmenu;
   GameStarts game;
   CardLayout layout;
   QuestionList questionlist= new QuestionList();
   Integrate (){
      prepareGUI();
      
   } 
 
   private void prepareGUI (){
      //  Main Frame
      main = new JFrame("Quiz");
      layout = new CardLayout();
      try {
         ImageIcon bg =  new ImageIcon (ImageIO.read(Integrate.class.getResource("/images/background.jpg")));
         main.setContentPane(new JLabel(bg));
      } catch (IOException e) {
         e.printStackTrace();
       }
      
      // Main Panel
      mainpanel = new JPanel();
      mainpanel.setBounds(50, 20, 500, 500);
      mainpanel.setLayout(layout);

      //  Top Menu 
      file = new TopMenu(main);
      file.close.addActionListener(this);

      main.add(mainpanel);
      main.setSize(600,600);
      main.setLayout(null);
      main.addWindowListener(this);

   }
   
   private void gameorder(){
      // Game Menu
      JPanel selector = new JPanel(new GridLayout(3,1));
      selector.setBackground(new Color(0,0,0,0));
      smenu = new SelectMenu(selector);
      smenu.createGame.addActionListener(this);
      smenu.startGame.addActionListener(this);
      smenu.resetGame.addActionListener(this);

      // Create Game 
      
      JPanel creator = new JPanel(new GridLayout(4,1));
      cmenu = new QuestionCreate(creator);
      cmenu.next.addActionListener(this);
      cmenu.submit.addActionListener(this);

      gamepanel = new JPanel(new GridLayout(4,1));
      game = new GameStarts(gamepanel, number, null, null, null, null, null, null);
      mainpanel.add("Selector",selector);
      mainpanel.add("CreateGame",creator);
      mainpanel.add("StartGame", gamepanel);
      main.setVisible(true);

   }
   


   public void actionPerformed(ActionEvent e){
      if(e.getSource()==file.close){
         System.exit(0);
      }
      if(e.getSource()==smenu.resetGame){
         if(questionlist.numberOfQuestion()!=0){
            questionlist.removeAllQuestion();
            JOptionPane.showMessageDialog(main,"Questions reset");
         }else{
            JOptionPane.showMessageDialog(main,"Question List is Empty","Alert",JOptionPane.WARNING_MESSAGE);
         }
      }
      // Create Game
      if(e.getSource()==smenu.createGame){
         CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
         cardLayout.show(mainpanel, "CreateGame");
      }
      //  Start Game
      if(e.getSource()==smenu.startGame && questionlist.numberOfQuestion()>0){
         Question firstquestion = questionlist.getQuestion(number);
         game.setNewQuestion(firstquestion.question, number+1,  firstquestion.getSelection(Answer.A)
         , firstquestion.getSelection(Answer.B), firstquestion.getSelection(Answer.C), 
         firstquestion.getSelection(Answer.D), firstquestion.answer);
         game.confirm.addActionListener(this);
         game.cancel.addActionListener(this);
         CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
         cardLayout.show(mainpanel, "StartGame");
      }else if (e.getSource()==smenu.startGame && questionlist.numberOfQuestion()==0){
         JOptionPane.showMessageDialog(main,"Question List is Empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
      //  Submit the Questions
      if(e.getSource()==cmenu.submit && !cmenu.forumIsEmpty()){
         Question q = new Question();
         q.setQuestion(cmenu.question.getText(), cmenu.selectionA.getText(),
         cmenu.selectionB.getText(),cmenu.selectionC.getText(),cmenu.selectionD.getText(),
         cmenu.checkSelectAnswer());
         questionlist.addQuestion(q);
         JOptionPane.showMessageDialog(main,"Create "+questionlist.numberOfQuestion()+" questions");
         cmenu.resetForum();
         CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
         cardLayout.show(mainpanel, "Selector");
      }else if (e.getSource()==cmenu.submit && cmenu.forumIsEmpty()){
         JOptionPane.showMessageDialog(main,"Forum is Empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
      //  Create Next Question
      if(e.getSource()==cmenu.next && !cmenu.forumIsEmpty()){
         Question q = new Question();
         q.setQuestion(cmenu.question.getText(), cmenu.selectionA.getText(),
         cmenu.selectionB.getText(),cmenu.selectionC.getText(),cmenu.selectionD.getText(),
         cmenu.checkSelectAnswer());
         questionlist.addQuestion(q);
         JOptionPane.showMessageDialog(main,"Next Question");
         cmenu.resetForum();
      }else if (e.getSource()==cmenu.next && cmenu.forumIsEmpty()){
         JOptionPane.showMessageDialog(main,"Forum is Empty","Alert",JOptionPane.WARNING_MESSAGE);
      }
      if (e.getSource()==game.confirm&&number+1==questionlist.numberOfQuestion()){
         if(game.checkCorrect()){
            game.correct();
         }
         JOptionPane.showMessageDialog(main,"There is no more question","Alert",JOptionPane.WARNING_MESSAGE);
         JOptionPane.showMessageDialog(main,"Total correct  "+game.numofcorrect+" questions");
         game.noQuestion();
         CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
         cardLayout.show(mainpanel, "Selector");
      }
      if (e.getSource()==game.confirm && game.checkCorrect()&& number+1<questionlist.numberOfQuestion()){
         number++;
         Question nextQuestion = questionlist.getQuestion(number);
         game.setNewQuestion(nextQuestion.question, number+1, nextQuestion.getSelection(Answer.A)
         , nextQuestion.getSelection(Answer.B), nextQuestion.getSelection(Answer.C), 
         nextQuestion.getSelection(Answer.D), nextQuestion.answer);
         
      }else if (e.getSource()==game.confirm && !game.checkCorrect()&& number+1<questionlist.numberOfQuestion()){
         number++;
         JOptionPane.showMessageDialog(main,"Wrong Answer");
         Question nextQuestion = questionlist.getQuestion(number);
         game.setNewQuestion(nextQuestion.question, number+1, nextQuestion.getSelection(Answer.A)
         , nextQuestion.getSelection(Answer.B), nextQuestion.getSelection(Answer.C), 
         nextQuestion.getSelection(Answer.D), nextQuestion.answer);
      }
      
      if(e.getSource()==game.cancel){
         CardLayout cardLayout = (CardLayout) mainpanel.getLayout();
         cardLayout.show(mainpanel, "Selector");
      }
   }
   public void windowDeactivated(WindowEvent e){
   }
   public void windowActivated(WindowEvent e){
   }
   public void windowDeiconified(WindowEvent e){
   }
   public void windowIconified(WindowEvent e){
   }
   public void windowClosed(WindowEvent e){
   }
   public void windowOpened(WindowEvent e){
   }
   public void windowClosing(WindowEvent e ){
      System.exit(0);
   }
   
   
   public static void main(String[] args) {
      Integrate test = new Integrate();
      test.gameorder();
   }


   
}