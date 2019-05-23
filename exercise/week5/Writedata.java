import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Write into File
class Writedata{
   
   //  Write single string
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
   /* 
   Write table with field and attrs by the format of name(type),name(type),name(type)
   and data, data, data
   */
   void writeTable(String filename,ArrayList<Record> field ,ArrayList<Record> attrs){
      try {
         BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
         for (Record line: field){
            for (int i=0; i<line.Record_size(); i++)
            {
               String str = line.getIndexofRecord(i);
               Type type = line.getIndexofRecordType(i);
               if (i==line.Record_size()-1){writer.write(str+"("+type.toString()+")");}
               else{writer.write(str+"("+type.toString()+")"+", ");}
            }
            writer.write("\n");
         }
         for (Record line: attrs){
            for (int i=0; i<line.Record_size(); i++)
            {
               String str = line.getIndexofRecord(i);
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
      DataType data1 = new DataType("id", Type.INT);
      DataType data2 = new DataType("name", Type.STR);
      DataType data3 = new DataType("score", Type.FLOAT);
      DataType datand1 = new DataType("1", Type.INT);
      DataType datand2 = new DataType("justin", Type.STR);
      DataType datand3 = new DataType("1.0", Type.FLOAT);
      field.add(new Record(new DataType[] {data1,data2,data3}));
      attrs.add(new Record(new DataType[] {datand1,datand2,datand3}));
      writeTable("Table.txt",field,attrs);
   }


}