import java.util.ArrayList;
import java.io.File;
class Database {
   private String dbName; 
   private ArrayList<Table> tbList = new ArrayList<Table>(); 
   Database(String name)
   {
      File file = new File(name);
      if(!file.exists()){
         file.mkdir();
         this.dbName = name;
      }
      else{System.out.println("Folder Exist");}
   }
   void CreateTable(String name, Record field)
   {
      Table table = new Table (name, field);
      tbList.add(table);
      File file = new File (this.dbName+'/'+table.Tbname);
      if(!file.exists()){
         file.mkdir();
      }else{System.out.println("Table Exist");}
   }   
   public static void main(String[] args) {
      Database program  = new Database("Uni");
      program.run();
   }
   void run (){
      CreateTableTest();
   }
   void CreateTableTest()
   {
      CreateTable("Student", new Record(new String[]{"id", "name","address"}));
      File file = new File ("Uni/Student"); 
      assert(file.exists()==true);
   }



}