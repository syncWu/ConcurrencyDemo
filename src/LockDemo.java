import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintDemo{
    private final Lock queueLock = new ReentrantLock();

    public void print(){
        queueLock.lock();
        try {
            Long duration = (long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName() + "taken" + duration/10 + "seconds");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s print the document successfully",Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}

class ThreadDemo1 extends Thread{
    PrintDemo printDemo;
    ThreadDemo1(String name,PrintDemo printDemo){
        super(name);
        this.printDemo = printDemo;
    }
    @Override
    public void run(){
        System.out.printf("%s start printing document",Thread.currentThread().getName());
        printDemo.print();
    }
}
public class LockDemo {
    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo1 t1 = new ThreadDemo1("Thread - 1 ", printDemo);
        ThreadDemo1 t2 = new ThreadDemo1("Thread - 2 ", printDemo);
        ThreadDemo1 t3 = new ThreadDemo1("Thread - 3 ", printDemo);
        ThreadDemo1 t4 = new ThreadDemo1("Thread - 4 ", printDemo);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
