import java.util.ArrayList;

class Table{
   String Tbname;
   final ArrayList<Record> fields = new ArrayList<Record>();
   final ArrayList<Record> attrs = new ArrayList<Record>();
   int Keys = 0; 
   Table(String name,Record field){
      this.Tbname = name;
      fields.add(field);
   }
   /**
    * @return the fields
    */
   /**
    * @return the fields
    */
   public ArrayList<String> getFields() {
      return this.fields.get(0).getRecords();
   }
   /**
    * @return the attrs
    */
   public ArrayList<String> getAttrs(int num) {
      if (this.attrs.get(num)==null)
      {
         return null;
      }
      return this.attrs.get(num).getRecords();
   }
   int getAttrsSize()
   {
      return attrs.size();
   }
   void addRecord(String... values){
      if(values.length!=fields.get(0).Record_size())
      {
         throw new ArithmeticException("Not Equal Field's size");
      }
      Record attr = new Record(values);
      attrs.add(Keys,attr);
      Keys ++ ;
   }
   void removeRecord(int num){
      if(num>attrs.size()){
         throw new StringIndexOutOfBoundsException("Not Exist This Line");
      }
      attrs.set(num,null);
   }
   void updateRecord( int num, String... values )
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
   void loaddata(String filename){
      ImportData data = new ImportData (filename);
      ArrayList<Record> tmp = data.getData();
      int size = tmp.size();
      for (int i = 0 ; i <size ; i++)
      {
         attrs.add(Keys,tmp.get(i));
         Keys ++ ;
      }
   }

   public static void main(String[] args) {
      Record field = new Record(new String[] {"id","name","address"});
      Table program = new Table("Student",field);
      program.run();
      program.printTable();
      Record field2 = new Record(new String[] {"id","name","address"});
      Table program2 = new Table("Student",field2);
      program2.loaddata("data.txt");
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
      addRecord(new String[] {"1","justin","london"});
      addRecord(new String[] {"2","ben","london"});
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
      addRecord(new String[] {"2","ben","london"});
      addRecord(new String[] {"3","Den","london"});
      addRecord(new String[] {"4","jen","london"});
      updateRecord(3, new String[] {"2","lin","london"});

   }
    
   
}