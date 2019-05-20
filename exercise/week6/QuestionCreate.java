import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
public class QuestionCreate{
   boolean nextScene = false;
   String qString, AString, BString, CString, DString;
   JLabel numberQuestion;
   JTextArea question;
   JTextArea selectionA, selectionB, selectionC, selectionD;
   JRadioButton labelA, labelB,labelC, labelD;
   JButton submit, next;
   int number = 1;
   QuestionCreate (JPanel panel){
      Font  labelFont = new Font(Font.DIALOG, Font.PLAIN, 22);
      Font  btnFont  = new Font(Font.SANS_SERIF,  Font.BOLD, 18);

      JPanel questionRow = new JPanel(new GridLayout(2,1));  
      question = new JTextArea("Please Enter the Question");
      numberQuestion = new JLabel("Q"+number);
      numberQuestion.setFont(labelFont);
      questionRow.add(numberQuestion);questionRow.add(question);
      // Selection A and B panel
      JPanel firstRow = new JPanel(new GridLayout(1,2));
      JPanel panelA = new JPanel();
      JPanel panelB = new JPanel();
      selectionA = new JTextArea(3,20);
      labelA = new JRadioButton("A");
      selectionB = new JTextArea(3,20);
      labelB = new JRadioButton("B");
      panelA.add(labelA);panelA.add(selectionA);
      panelB.add(labelB);panelB.add(selectionB);
      firstRow.add(panelA);firstRow.add(panelB);

      // Selection C and D panel
      JPanel secondRow = new JPanel(new GridLayout(1,2));
      JPanel panelC = new JPanel();
      JPanel panelD = new JPanel();
      selectionC = new JTextArea(3,20);
      labelC = new JRadioButton("C");
      selectionD = new JTextArea(3,20);
      labelD = new JRadioButton("D");
      panelC.add(labelC);panelC.add(selectionC);
      panelD.add(labelD);panelD.add(selectionD);
      secondRow.add(panelC);secondRow.add(panelD);
      // Button panel
      JPanel lastRow =  new JPanel(new GridLayout(1,2));
      ImageIcon nexticon = createImageIcone("/images/next.png", "Next");
      ImageIcon submiticon = createImageIcone("/images/submit.png", "Submit");
      next = new JButton("Next",nexticon);
      submit = new JButton("Submit",submiticon);

      next.setFont(btnFont);
      submit.setFont(btnFont);

      lastRow.add(next); lastRow.add(submit);
      //  Radio Button Group
      ButtonGroup labelgroup = new ButtonGroup();
      labelgroup.add(labelA);labelgroup.add(labelB);
      labelgroup.add(labelC);labelgroup.add(labelD);      
      panel.add(questionRow);
      panel.add(firstRow);
      panel.add(secondRow);
      panel.add(lastRow);
   }
   private static ImageIcon createImageIcone (String path, String description)
   {
      if(path != null)
      {
         return new ImageIcon(QuestionCreate.class.getResource(path) , description);
      }else{
         System.err.println("Could not find file: " + path);
         return null;
      }
   }
   // Select the Answer and return answer
   Answer checkSelectAnswer(){
      if(labelA.isSelected()){
         return Answer.A;
      }else if (labelB.isSelected()){
         return Answer.B;
      }else if (labelC.isSelected()){
         return Answer.C;
      }else if (labelD.isSelected()){
         return Answer.D;
      }
      return null;
   }

   boolean forumIsEmpty(){
      if(question.getText().equals("Please Enter the Question")||selectionA.getText().equals("")
      ||selectionB.getText().equals("")||selectionC.getText().equals("")
      ||selectionD.getText().equals("")|| checkSelectAnswer()==null){
         return true;
      }
      return false;
   }
   void resetForum(){
      number++;
      numberQuestion.setText("Q"+number);
      question.setText("Please Enter the Question");
      selectionA.setText("");
      selectionB.setText("");
      selectionC.setText("");
      selectionD.setText("");
   }
   public static void main (String[]args){
      JFrame f = new JFrame("Test");
      JPanel panel = new JPanel(new GridLayout(4,1));
      panel.setBounds(50, 50, 500, 400);
      new QuestionCreate(panel);
      f.add(panel);
      f.setSize(600, 600);
      f.setLayout(null);
      f.setVisible(true);
   }
}