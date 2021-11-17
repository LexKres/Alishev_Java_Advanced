package Adv_Volatile;

// volatile - летучий (изменчивый, переменный)
// необходимо, когда несколько потоков работают с одной и той же переменной
//

import java.util.Scanner;

public class Adv_Volatile {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
        System.out.println(" we are stopping");

    }
}

class MyThread extends Thread {
    //  чтобы иметь возможность из главного потока main выключить этот поток
    private volatile boolean running = true;   // эта не надо кэшировать переменную
                                                // volatile гарантирует, что эта переменная не будет кешируется
                                            // хотя без volatile в соверменных машинах чаще всего работает

    // без volatile код прекращения цикла может не сработать по причине плохой когерентности кэшей,
    // т.е. у потока с циклом может переменная running закешироваться в кэш своего ядра процессора, на котором
    // этот поток выполняется.  И этот поток будет продолжать читать эту переменную из своего кэша.
    // Т.е. когерентность - это когда кэши у разных ядер совпадают.



    public void run() {
        while (running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}