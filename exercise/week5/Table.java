import java.util.ArrayList;

class Table{
   final ArrayList<Record> fields = new ArrayList<Record>();
   final ArrayList<Record> attrs = new ArrayList<Record>();
   Table(Record field){
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
      attrs.add(attr);
   }
   void removeRecord(int num){
      if(num>attrs.size()){
         throw new StringIndexOutOfBoundsException("Not Exist This Line");
      }
      attrs.remove(num);
   }
   void updateRecord( int num, String... values )
   {
      if(num>attrs.size()){
         throw new StringIndexOutOfBoundsException("Not Exist This Line");
      }
      Record attr = new Record(values);
      attrs.set(num, attr);

   }

   public static void main(String[] args) {
      Record field = new Record(new String[] {"id","name","address"});
      Table program = new Table(field);
      System.out.println(program.getFields());
      program.addRecord(new String[] {"1","justin","london"});
      System.out.println(program.getAttrs(0));
      program.addRecord(new String[] {"2","ben","london"});
      assert(program.getAttrsSize()==2);
      program.attrs.remove(1);
      assert(program.getAttrsSize()==1);
      program.addRecord(new String[] {"2","ben","london"});
      program.addRecord(new String[] {"3","Den","london"});
      program.addRecord(new String[] {"4","jen","london"});
      program.updateRecord(2, new String[] {"2","lin","london"});
      System.out.println(program.getAttrs(2));
    }
    
   
}