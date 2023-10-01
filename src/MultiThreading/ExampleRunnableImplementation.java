package MultiThreading;

public class ExampleRunnableImplementation implements Runnable{
    public void run(){
        try{
            System.out.println("ExampleRunnableImplementation running - "+ Thread.currentThread().getId());
        }catch (Exception e){
            System.out.println("Exception - "+e);
        }
    }
}
