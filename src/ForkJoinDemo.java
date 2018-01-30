public class ForkJoinDemo {
    public static void main(String[] args) {
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(nThreads);
    }
}
