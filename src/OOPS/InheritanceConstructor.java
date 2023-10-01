package OOPS;

public class InheritanceConstructor {
    public static void main(String[] args) {

        Animal a = new Animal();
        Animal ad = new Dog();
        Dog d = new Dog();
//      Dog da = new Animal(); Child object cannot have a parent class instance, Control goes at same level or above, not below.
        a.move();
        ad.move();//child method as instance is of child
        d.move();

//        Animal.eat();
//        Dog.eat(); way of accessing static methods not via objects -> METHOD HIDING

        a.birth();
        ad.birth();
        d.birth();// when final  parent or child objects will use the same parent's class method

//        a.sex(); private methods cant be accessed thats trivia.
    }
}
class Animal{

    Animal(){
        System.out.println("This is the Animal");
    }

    public  void move(){
        System.out.println("We animals can move");
    }

    public static void eat(){System.out.println("Animals do eat");}

    public final void birth(){System.out.println("Animals born once in life");}

    private void sex(){System.out.println("Animal Sex in Private");}
}
class Dog extends Animal{
    Dog(){
        System.out.println("This is a Dog");
    }

    public void move(){
        System.out.println("We Dogs move on four legs");
    }

    public static void eat(){System.out.println("Dogs eat yum yum");}

//    public final void birth(){System.out.println("Dogs also born once ..:) ");} error - Final method Parent cant be overridden
}
