class DataType {
   private String data; 
   private ArrayList<Type> type; 

   DataType (String name, Type... types)
   {
      this.data = name;
      for(Type e: types){type.add(e);}
   }
   
   String getdata()
   {
      return this.data;
   }
   /**
    * @return the type
    */
   public ArrayList<Type> getType() {
      return this.type;
   }



   
}