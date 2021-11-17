package Adv_MultiThread;

public class Adv_Multithread {
    public static void main(String[] args) throws InterruptedException {    //main - это основной поток
        // 1й способ
        MyThread myThread = new MyThread();

        // метод run() не нужно запускать, он для внутреннего использования
        // чтобы запустить овый пототк вызываем метод start()
        myThread.start();

        // Потоки в Java не синхронизированы и могут выполняться в любом порядке

        MyThread myThread2 = new MyThread();
        myThread2.start();

        System.out.println("main going to sleep");
        try {
            Thread.sleep(3000);    // 3 секунды поток main будет спать  // статический метод, который можно исользовать в любых потоках
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main has been awaked");

        Thread thread3 = new Thread(new Runner());    // 2й способ
        thread3.run();
    }
}


// 1й способ создания потоков
class MyThread extends Thread {   // наследуем этому классу
    public void run() {     // переопределяем метод run()
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread" + i);
        }
    }
}

// 2й способ
// В своем классе мы реализуем интерфейс Runnable
// ,в методе run() реализуем логику, которую хотим выполнять в отдельном потоке
// и передаем объект этого класса в качестве аргумента в конструктор при создании нового потока
class Runner implements Runnable {

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from second " + i);
        }

    }
}

