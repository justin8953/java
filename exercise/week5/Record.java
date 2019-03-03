import java.util.ArrayList;

class Record {
   final ArrayList<String> records = new ArrayList<String>() ;
   Record(String... names) {
      for (String e : names) records.add(e);
   }
   /**
    * @return the records
    */
   public ArrayList<String> getRecords() {
      return records;
   }
   int Record_size()
   {
      return records.size();
   }
   
   public static void main(String[] args) {
      Record program = new Record("");
      program.run();
    }
    private void run (){
      Record program = new Record(new String[]{"id","name","email"});
      assert(program.records.get(0).equals("id"));
      assert(program.Record_size()==3);
    }

    
} 