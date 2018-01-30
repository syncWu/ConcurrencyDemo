public class ThreadDemo implements Runnable{

    int counter;

    ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    @Override
    public void run() {
        counter++;
        if(threadLocal.get() != null){
            threadLocal.set(threadLocal.get().intValue() + 1);
        }else{
            threadLocal.set(0);
        }
        System.out.println("Counter" + counter);
        System.out.println("threadLocal" + threadLocal.get());
    }
}
