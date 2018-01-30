public class RunnableDemo implements Runnable {

    public Thread t;
    private String threadName;
    boolean suspended = false;

    public RunnableDemo(String name){
        threadName = name;
        System.out.println("creating" + threadName);
    }

    @Override
    public void run() {
        System.out.println("running the" + threadName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Thread :" + threadName + "," + i);
                Thread.sleep(300);
                synchronized (this){
                    while(suspended){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread" + threadName + "interrupted.");
        }
        System.out.println("Thread" + threadName + "existing");
    }

    public void start(){
        System.out.println("Starting" + threadName);

        if (t == null) {
            t = new Thread(this,threadName);
            t.start();
        }
    }

    public void suspend(){
        suspended = true;
    }
    synchronized void resume(){
        suspended = false;
        notify();
    }

}
