import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> result10 = executor.submit(new FactorialService(10));
        System.out.println("10!  =" + result10.get());
    }

    static class FactorialService implements Callable<Long>{
        private int number;

        public FactorialService(int number) {
            this.number = number;
        }

        @Override
        public Long call() throws Exception {
            return factorial();
        }

        private Long factorial() throws InterruptedException{
            long result = 1;
            while(number != 0){
                result = number*result;
                number--;
                Thread.sleep(3);
            }
            return result;
        }
    }
}
