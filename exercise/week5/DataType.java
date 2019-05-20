// Give data a type 
class DataType {
   private String data; 
   private Type dtype; 

   DataType (String name, Type type)
   {
      this.data = name;
      this.dtype = type;
   }
   String getdata()
   {
      return this.data;
   }
   Type getType() {
      return this.dtype;
   }

}