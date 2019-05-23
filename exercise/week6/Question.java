import java.util.ArrayList;
import java.util.HashMap;

class Question{
   String question;
   HashMap<Answer,String> selections = new HashMap<Answer,String>();
   Answer answer;
   
   void setSelection(Answer ans, String selection){
      selections.put(ans,selection);
   }
   void setQuestion(String q, String A, String B, String C, String D, Answer ans)
   {
      this.question = q;
      this.answer = ans;
      setSelection(Answer.A, A);
      setSelection(Answer.B, B);
      setSelection(Answer.C, C);
      setSelection(Answer.D, D);
   }
   void updateQuestion(String q){
      this.question = q;
   }
   int getSelectionSize(){
      return selections.size();
   }
   String getSelection(Answer ans){
      return selections.get(ans);
   }
   Answer result(Answer choice){
      if (choice==answer){return answer;}
      return null;
   }
   public static void main(String[] args) {
      Question programm = new Question();
      programm.run();
   }
   private void run() {
      setSelectionTest();
      updateQuestionTest();
      getSelectionSizeTest();
   }
   private void setSelectionTest(){
      setSelection(Answer.A, "Swimming");
      assert(selections.containsKey(Answer.A)==true);
      assert(selections.containsKey(Answer.B)==false);
      setSelection(Answer.B, "Hiking");
      assert(selections.containsKey(Answer.B)==true);
      setSelection(Answer.C, "Dancing");
      assert(selections.containsKey(Answer.C)==true);
      setSelection(Answer.D, "Drinking");
      assert(selections.containsKey(Answer.D)==true);
   }
   private void updateQuestionTest(){
      updateQuestion("What activity does David hate ?");
      assert(question.equals("What activity does David hate ?"));
   }
   private void getSelectionSizeTest(){
      assert(getSelectionSize()==4);
   }
}