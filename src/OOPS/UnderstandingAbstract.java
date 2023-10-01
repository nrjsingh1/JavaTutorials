package OOPS;

public class UnderstandingAbstract {
    public static void main(String[] args) {
        // Vehicle v = new Vehicle(); Abstract class cannot be instantiated
        Vehicle vC = new Cars();
        vC.move();// access static method of base class
        // Vehicle.move();// access static method of base class
        Cars c = new Cars();
        c.move();

        // Cars cV = new Vehicle(); can instantiate abstract classes
    }
}

abstract class Vehicle{

    Vehicle(){
        System.out.println("This is a Vehicle");
    }
    void move()// if you have the body or not , doesnt matter, bcz only child class can be instantiated,
    {
        System.out.println("Vehicles move ");
    }
}

class Cars extends Vehicle{

    Cars(){
        System.out.println("This is a Car");
        move();
    }

    void  move(){
        System.out.println("Cars move on 4 wheels");
    }
}

