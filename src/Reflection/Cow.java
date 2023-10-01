package Reflection;

public class Cow implements Herbivorous{
    @Override
    public void move() {
        System.out.println("Cows move on 4 legs");
    }

    public void Moo(){
        System.out.println("Cows Moo man ..just move on");
    }
}
