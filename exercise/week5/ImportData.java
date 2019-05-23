import java.io.File;
import java.util.Scanner; 
import java.util.ArrayList;
// Import Data from a file
class ImportData {
   Scanner input;
   final ArrayList<Record> field = new ArrayList<Record>();
   final ArrayList<Record> data = new ArrayList<Record>();
   ImportData(String name){
      try{
         File file = new File(name);
         int i = 0;
         input = new Scanner(file);
         while(input.hasNextLine())
         {
            String line = input.nextLine();
            String [] list = line.split(",");
            if (i == 0)
            {
               Record fieldTmp = new Record();
               for(String e: list){
                  String [] fieldlist = e.trim().replace('(', ' ').replace(')', ' ').split(" ");
                  fieldTmp.setRecord(new DataType(fieldlist[0],checkType(fieldlist[1])));
               }
               field.add(fieldTmp);
            }else{
               Record dataTmp = new Record();
               int j =0;
               for(String e: list){
                  dataTmp.setRecord(new DataType(e, field.get(0).getIndexofRecordType(j)));
                  j++;
               }
               data.add(dataTmp);
            }
            i++;
            // Record list = new Record(line.split(","));
            // data.add(list);
         }
         input.close();
      }catch(Exception e){
         e.printStackTrace();
      }
   }
   Type checkType (String type)
   {
      if(type=="INT"){return Type.INT;}
      else if (type=="STR"){return Type.STR;}
      else if (type=="FLOAT"){return Type.FLOAT;}
      return null;
   }
   /**
    * @return the data
    */
   public ArrayList<Record> getData() {
      return data;
   }
   /**
    * @return the field
    */
   public ArrayList<Record> getFileField() {
      return field;
   }
   public static void main(String[] args) {
      ImportData program = new ImportData("data.txt");
      program.run();
   }
   private void run (){
      // ReadFile("data.txt");
   }
}