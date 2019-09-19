package github.com.wdzdeng.algorithm.test;

public class StringTest {
   public static void main(String[] args) {
      System.out.println(Math.floor(-1.6));
      System.out.println(Math.ceil(-1.6));

   }
}
class  Animal{
   public void move(){
      System.out.println("animal");
   }
}
class Dog extends Animal{
   @Override
   public void move() {
      System.out.println("dao");
   }
   public void a(){
      System.out.println("a");
   }
}
