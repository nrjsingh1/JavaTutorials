package MultiThreading;

public class ExampleThreadClass extends Thread{
    public void  run(){
        try{
            for(int i =0;i<5;i++) {
                Thread.sleep(1000);
                System.out.println("ExampleThreadClass running - "+i+" - "+ Thread.currentThread().getId());
            }
        }catch (Exception e){
            System.out.print("Exception cause "+e);
        }
    }
}

class ExampleThreadClass2 extends Thread{
    public void run(){
        try{
            for(int i =0;i<5;i++) {
                Thread.sleep(500);
                System.out.println("ExampleThreadClass2 running - "+i+" - "+ Thread.currentThread().getId());
            }
        }catch (Exception e){
            System.out.print("Exception cause "+e);
        }
    }
}
