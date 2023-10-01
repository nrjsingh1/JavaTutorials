package MultiThreading;

public class ThreadDriver {
    public static void main(String[] args) throws InterruptedException {
       // for(int i =0;i<8;i++){
            ExampleThreadClass exampleThreadClass = new ExampleThreadClass();
            exampleThreadClass.start();
            exampleThreadClass.join();
            //ExampleRunnableImplementation exampleRunnableImplementation = new ExampleRunnableImplementation(); this will not work ,
            // you need a Thread class object to do start()
            ExampleRunnableImplementation exampleRunnableImplementation = new ExampleRunnableImplementation();
            Thread thread = new Thread(exampleRunnableImplementation);// passing the interface implementaion to thread
            thread.start();
            //thread.join();
      // }
    }
}
