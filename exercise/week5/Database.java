import java.io.File;
//  create a database folder and export the table after closing the database
class Database {
   private String dbName; 
   Database(String name)
   {
      File file = new File(name);
      if(!file.exists()){
         System.out.println("Database Open .....");
         file.mkdir();
         this.dbName = name;
      }
      else{System.out.println("Folder Exist");}
   }
   void closeDatabase(Table... tb)
   {
      for(Table e: tb)
      {
         Writedata writer = new Writedata();
         writer.writeTable(this.dbName+"/"+e.Tbname+".txt", e.fields, e.attrs);
      }
      System.out.println("Database Closed .....");
   }   
   public static void main(String[] args) {
      Database program  = new Database("Uni");
      program.run();
   }
   void run (){
      closeDatabaseTest();
   }
   private void closeDatabaseTest()
   {
      closeDatabase(create_Table1(),create_Table2());
   }
   private Table create_Table1 (){
      DataType data1 = new DataType("id", Type.INT);
      DataType data2 = new DataType("name", Type.STR);
      DataType data3 = new DataType("address", Type.FLOAT);
      DataType datand1 = new DataType("1", Type.INT);
      DataType datand2 = new DataType("justin", Type.STR);
      DataType datand3 = new DataType("1.0", Type.FLOAT);
      Table tb1 = new Table("Student", new Record(new DataType[]{data1,data2,data3}));
      tb1.insertRecord(new DataType[]{datand1,datand2,datand3});
      return tb1;
   }
   private Table create_Table2 (){
      DataType data1 = new DataType("id", Type.INT);
      DataType data2 = new DataType("product", Type.STR);
      DataType data3 = new DataType("price", Type.FLOAT);
      DataType datand1 = new DataType("1", Type.INT);
      DataType datand2 = new DataType("pen", Type.STR);
      DataType datand3 = new DataType("1.0", Type.FLOAT);
      Table tb = new Table("product", new Record(new DataType[]{data1,data2,data3}));
      tb.insertRecord(new DataType[]{datand1,datand2,datand3});
      return tb;
   }




}