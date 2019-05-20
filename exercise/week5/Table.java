import java.util.ArrayList;
import java.lang.Exception;
// A collection of records and some operations
class Table{
   String Tbname;
   ArrayList<Record> fields = new ArrayList<Record>();
   ArrayList<Record> attrs = new ArrayList<Record>();
   
   // Auto Increment the key 
   int Keys = 0; 

   Table(String name,Record field){
      this.Tbname = name;
      fields.add(field);
   }

   void setField(Record field){
      if(this.fields.size()==1){
         System.out.println("Header has set");
      }else{this.fields.add(field);}
   }
   
   ArrayList<String> getFields() {
      if(this.fields.size()>0)
      {
         throw new IndexOutOfBoundsException("Cannot Set Two Rows Fields \n");
      }
      return this.fields.get(0).getRecords();
   }
   ArrayList<String> getAttrs(int num) {
      if (this.attrs.get(num)==null){return null;}
      return this.attrs.get(num).getRecords();
   }
   int getAttrsSize()
   {
      return attrs.size();
   }
   // Insert new Record and Check Type is correct 
   void insertRecord(DataType... values){
      if(values.length!=fields.get(0).Record_size()){
         throw new IndexOutOfBoundsException();
      }
      for(DataType e: values){
         if(e.getType()==Type.INT && !isInt(e.getdata())){
            throw new NumberFormatException("Not Integer");
         }
         if(e.getType()==Type.FLOAT && !isFloat(e.getdata())){
            throw new NumberFormatException("Not Float");
         }
      }
      Record attr = new Record(values);
      attrs.add(Keys,attr);
      Keys ++ ;
   }
   // check data is Int type
   private boolean isInt(String data){
      try{
         Integer.parseInt(data);
         return true;
      }catch(Exception e){return false;}
   }
   // check float is Int type
   private boolean isFloat(String data){
      try{
         Float.parseFloat(data);
         return true;
      }catch(Exception e){return false;}
   }
   void removeRecord(int num){
      if(num>attrs.size()){
         throw new StringIndexOutOfBoundsException("Not Exist This Line");
      }
      attrs.set(num,null);
   }
   void updateRecord( int num, DataType... values )
   {
      if(num>attrs.size()){
         throw new StringIndexOutOfBoundsException("Not Exist This Line");
      }
      Record attr = new Record(values);
      attrs.set(num, attr);
   }

   void printTable(){
      System.out.println(fields.get(0).getRecords());
      int size = attrs.size();
      for (int i = 0 ; i< size; i++)
      {
         if (attrs.get(i)==null){i++;}
         System.out.println(attrs.get(i).getRecords());
      }
   }
   // load data from file
   void loadData(String filename){
      ImportData data = new ImportData (filename);
      ArrayList<Record> fieldTmp = data.getFileField();
      ArrayList<Record> dataTmp = data.getData();
      int size = dataTmp.size();
      fields.add(fieldTmp.get(0));
      for (int i = 0 ; i <size ; i++)
      {
         attrs.add(Keys,dataTmp.get(i));
         Keys ++ ;
      }
   }

   public static void main(String[] args) {
      DataType data1 = new DataType("id", Type.INT);
      DataType data2 = new DataType("name", Type.STR);
      DataType data3 = new DataType("score", Type.FLOAT);
      Record field = new Record(new DataType[]{data1,data2,data3});
      Table program = new Table("Student",field);
      program.run();
      program.printTable();
      Record field2 = new Record(new DataType[]{data1,data2,data3});
      Table program2 = new Table("Student",field2);
      program2.loadData("data.txt");
      program2.printTable();
   }
   private void run()
   {
      addAttrsTest();
      removeAttrsTest();
      updateAttrsTest();
   }
   private void addAttrsTest()
   {
      DataType data1 = new DataType("1", Type.INT);
      DataType data2 = new DataType("justin", Type.STR);
      DataType data3 = new DataType("0.1", Type.FLOAT);
      DataType datand1 = new DataType("2", Type.INT);
      DataType datand2 = new DataType("ben", Type.STR);
      DataType datand3 = new DataType("0.2", Type.FLOAT);
      insertRecord(new DataType[]{data1,data2,data3});
      insertRecord(new DataType[]{datand1,datand2,datand3});
      assert(getAttrsSize()==2);
   }
   private void removeAttrsTest()
   {
      removeRecord(1);
      assert(getAttrsSize()==2);
      assert(getAttrs(1)==null);
   }
   private void updateAttrsTest()
   {
      DataType data1 = new DataType("2", Type.INT);
      DataType data2 = new DataType("ben", Type.STR);
      DataType data3 = new DataType("1.2", Type.FLOAT);
      DataType datand1 = new DataType("3", Type.INT);
      DataType datand2 = new DataType("Den", Type.STR);
      DataType datand3 = new DataType("1.2", Type.FLOAT);
      DataType datard1 = new DataType("4", Type.INT);
      DataType datard2 = new DataType("Jen", Type.STR);
      DataType datard3 = new DataType("1.2", Type.FLOAT);
      DataType datachange1 = new DataType("4", Type.INT);
      DataType datachange2 = new DataType("Jen", Type.STR);
      DataType datachange3 = new DataType("1.2", Type.FLOAT);
      insertRecord(new DataType[]{data1,data2,data3});
      insertRecord(new DataType[]{datand1,datand2,datand3});
      insertRecord(new DataType[]{datard1,datard2,datard3});
      updateRecord(3, new DataType[]{datachange1,datachange2,datachange3});

   }
    
   
}