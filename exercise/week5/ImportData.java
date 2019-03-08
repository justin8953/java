import java.io.File;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
class ImportData {
   Scanner input;
   final ArrayList<Record> data = new ArrayList<Record>();
   ImportData(String name){
      try{
         File file = new File(name);
         input = new Scanner(file);
         while(input.hasNextLine())
         {
            String line = input.nextLine();
            Record list = new Record(line.split(","));
            data.add(list);
         }
         input.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   /**
    * @return the data
    */
   public ArrayList<Record> getData() {
      return data;
   }
   
   public static void main(String[] args) {
      // ImportData program = new ImportData();
      // program.run();
   }
   private void run (){
      // ReadFile("data.txt");
   }



}