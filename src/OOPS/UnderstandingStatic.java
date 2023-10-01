package OOPS;

public class UnderstandingStatic {

    static int a;
    static {
        a = 10;

        System.out.println("a in static block = "+a);

    }


    void callMeYo(){
        System.out.println("In Call Me Yo Method");
        System.out.println("a = "+a);

    }

    public static void main(String[] args) {

        test t = new test();
        t.callMe();

    }
    static class test {
        void callMe() {
            System.out.println("In Call Me  Inner Method " + a);
            //callMeYo();
        }
    }

}



