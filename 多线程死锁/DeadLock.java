/**
 * @author 多线程死锁
 * @version 2017/6/23.18:59
 */
public class DeadLock {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("Thread A");
                    }
                }
            }
        }).start();
        //******************************************
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("Thread B");
                    }
                }
            }
        }).start();
    }
}
