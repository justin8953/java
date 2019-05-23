import java.awt.TextArea;

import javax.swing.*;

public class TopMenu{
   JMenuBar mb;
   JMenu file;
   JMenuItem close;
   TopMenu(JFrame f){
      // main Windows
      mb = new JMenuBar();
      //  file menu
      file = new JMenu("File");
      close = new JMenuItem("exit");
      file.add(close);
      mb.add(file);
      f.add(mb);
      f.setJMenuBar(mb);
   }
   public static void main(String args[]) {
      JFrame f =new JFrame("Test");
      new TopMenu(f);
      f.setSize(400,400);
      f.setLayout(null);
      f.setVisible(true);
   }


}