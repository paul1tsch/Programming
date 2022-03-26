package htbla.kaindorf.third_grade.pos.q2.Namelist;

public class NameThread implements Runnable {
    private StringBuilder stringBuilder = new StringBuilder(10_000_000);

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            synchronized (stringBuilder) {
                stringBuilder.append(Thread.currentThread().getName());
            }
        }
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public static void main(String[] args) {
        NameThread nameThread = new NameThread();

        Thread thread1 = new Thread(nameThread, "Schiffermueller");
        Thread thread2 = new Thread(nameThread, "Grinch");
        Thread thread3 = new Thread(nameThread, "Goofy");
        Thread thread4 = new Thread(nameThread, "Donald Duck");
        Thread thread5 = new Thread(nameThread, "Christopher Sailer");

        long start = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.printf("Elapsed Time: %2dms\n", (end-start));

        System.out.println(nameThread.getStringBuilder().length());
        System.out.println(nameThread.getStringBuilder().substring(0, 10_000));
    }
}
