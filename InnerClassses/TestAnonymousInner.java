abstract class Person {
  abstract void eat();

  abstract void drink();
}

/**
 * InnerTestAnonymousInner
 */
interface Inner {

  void display();

}

class TestAnonymousInner {
  public static void main(String args[]) {
    Person p = new Person() {
      void eat() {
        System.out.println("nice fruits");
      }

      void drink() {
      };
    };
    Inner i = new Inner() {
      public void display() {
        System.out.println("Hello there");
      }
    };
    i.display();
    p.eat();
  }
}