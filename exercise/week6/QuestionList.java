import java.util.ArrayList;

class QuestionList{
   ArrayList<Question> qList = new ArrayList<Question>();
   Question getQuestion (int num){
      return qList.get(num);
   }
   boolean addQuestion(Question newQ){
      if(newQ!=null){qList.add(newQ);return true;}
      return false;
   }
   boolean removeQuestion(int num){
      try{
         qList.remove(num);
         return true;
      }catch(Exception e){return false;}
   }
   void removeAllQuestion(){
      qList.removeAll(qList);
   }
   int numberOfQuestion(){
      return qList.size();
   }
   public static void main(String[] args) {
      QuestionList programm = new QuestionList();
      programm.run();
   }
   private void run(){
      addQestionTest();
      numberQuestionTest();
      removeTest();
   }
   private void addQestionTest(){
      Question q = new Question();
      q.question = "What is the Best Song";
      assert(addQuestion(q)==true);
      addQuestion(q);
   }
   private void numberQuestionTest()
   {
      assert(numberOfQuestion()==2);
   }
   private void removeTest(){
      assert(removeQuestion(0)==true);
      assert(numberOfQuestion()==1);
   }
}