import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorSeviceDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            executor.submit(new Task());
            System.out.println("shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(!executor.isTerminated()){
                System.err.println("cancle non-finished tasks");
            }
        }
    }
    static class Task implements Runnable{

        @Override
        public void run() {
            try{
                Long duration = (long)(Math.random() * 20);
                System.out.println("Running task");
                TimeUnit.SECONDS.sleep(duration);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
