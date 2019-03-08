import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Writedata{
   void write(String str, String filename){
      try {
         
         BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
         writer.write(str);
         writer.close();
      }catch(IOException e)
      {
         System.out.println("Cant not create file");
      }
   }
   void writeTable(String filename,ArrayList<Record> field ,ArrayList<Record> attrs){
      try {
         BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
         for (Record line: field){
            for (int i=0; i<line.Record_size(); i++)
            {
               String str = line.getRecords().get(i);
               if (i==line.Record_size()-1){writer.write(str);}
               else{writer.write(str+", ");}
            }
            writer.write("\n");
         }
         for (Record line: attrs){
            for (int i=0; i<line.Record_size(); i++)
            {
               String str = line.getRecords().get(i);
               if (i==line.Record_size()-1){writer.write(str);}
               else{writer.write(str+", ");}
            }
            writer.write("\n");
         }
         writer.close();
      }catch(IOException e)
      {
         System.out.println("Cant not create file");
      }
   }
   public static void main(String[] args) {
      Writedata program  = new Writedata();
      program.run();
   }
   void run (){
      WritingTest();
      arrayWritingTest();
   }
   private void WritingTest(){
      write("Justin", "TestFile.txt");
   }
   private void arrayWritingTest(){
      ArrayList<Record> attrs = new ArrayList<Record>();
      ArrayList<Record> field = new ArrayList<Record>();
      Record datast = new Record(new String[]{"id","name","address"});
      Record datand = new Record(new String[]{"1","justin","taipei"});
      field.add(datast);
      attrs.add(datand);
      writeTable("Table.txt",field,attrs);
   }


}