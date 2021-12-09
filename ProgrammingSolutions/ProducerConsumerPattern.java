// Threading: Implement a simple example of the producer consumer pattern.
import java.util.LinkedList;

public class ProducerConsumerPattern {
    public static void main(String[] args)
            throws InterruptedException {
        // Initialize object of a class that has both produce()
        // and consume() methods
        final PC pc = new PC();

        // Start producer thread => t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start consumer thread => t2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }

    // This class has a list, producer (adds items to list and consumer (removes items).
    public static class PC {

        // Create a list shared by producer and consumer size of list is 2.
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;

        // Function called by producer thread
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    // Producer thread waits while list is full
                    while (list.size() == capacity)
                        wait();

                    System.out.println("Producer produced-"
                            + value);

                    // Insert the jobs in the list
                    list.add(value++);

                    // Notifies the consumer thread that now it can start consuming
                    notify();

                    // Makes the working of program easie to understand
                    Thread.sleep(1000);
                }
            }
        }

        // Function called by consumer thread
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    // consumer thread waits while list is empty
                    while (list.size() == 0)
                        wait();

                    // Retrieve the ifrst job in the list
                    int val = list.removeFirst();

                    System.out.println("Consumer consumed-"
                            + val);

                    // Wake up producer thread
                    notify();

                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
}

/*
 * Output:
 * 
 * Producer produced-0
 * Producer produced-1
 * Consumer consumed-0
 * Consumer consumed-1
 * Producer produced-2
 * Producer produced-3
 * Consumer consumed-2
 * Consumer consumed-3
 * Producer produced-4
 * Producer produced-5
 * Consumer consumed-4
 * Consumer consumed-5
 * Producer produced-6
 * Producer produced-7
 * ..................
 * ..................
 * ..................
 * ..................
 */