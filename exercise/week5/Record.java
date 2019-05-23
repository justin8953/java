import java.util.ArrayList;

// Create a record by defined type
class Record {
   
   private ArrayList<DataType> records = new ArrayList<DataType>() ;
 
   Record(DataType... data) {
      for (DataType e : data)records.add(e);
   }
   // add defined type data into records
   void setRecord(DataType data){
      this.records.add(data);
   }
   
   ArrayList<String> getRecords() {
      // save string data into array list and return it. 
      ArrayList<String> recordData = new ArrayList<String>();
      for(DataType record: this.records){recordData.add(record.getdata());}
      return recordData;
   }
   // save data type into array list and return it. 
   ArrayList<Type> getRecordsType() {
      ArrayList<Type> recordType = new ArrayList<Type>();
      for(DataType record: this.records){recordType.add(record.getType());}
      return recordType;
   }
   // get particular data in records 
   String getIndexofRecord(int i)
   {
      return records.get(i).getdata();
   }
   // get particular data type in records 
   Type getIndexofRecordType(int i)
   {
      return records.get(i).getType();
   }
   int Record_size()
   {
      return records.size();
   }
   
   public static void main(String[] args) {
      DataType data1 = new DataType("id", Type.INT);
      DataType data2 = new DataType("name", Type.STR);
      DataType data3 = new DataType("score", Type.FLOAT);
      Record program = new Record(new DataType[]{data1,data2,data3});
      program.run();
    }
    private void run (){
      testGetRecord();
      testGetRecordType();
    }
    private void testGetRecord()
    {
      getIndexofRecord(0).equals("id");
      getIndexofRecord(1).equals("name");
      getIndexofRecord(2).equals("score");
   }
   private void testGetRecordType()
    {
      getIndexofRecordType(0).equals(Type.INT);
      getIndexofRecordType(1).equals(Type.STR);
      getIndexofRecordType(2).equals(Type.FLOAT);
   }

    
} 