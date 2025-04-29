package C03;

class SharedBuffer {
    private int item;
    private boolean isProduced = false;

    // Producer method to produce an item
    public synchronized void produce(int item) throws InterruptedException {
        while (isProduced) {
            wait(); // Wait if the item is already produced
        }
        this.item = item; // Produce item
        System.out.println("Produced: " + item);
        isProduced = true; // Mark the item as produced
        notify(); // Notify consumer that the item is produced
    }

    // Consumer method to consume an item
    public synchronized void consume() throws InterruptedException {
        while (!isProduced) {
            wait(); // Wait if no item is produced
        }
        System.out.println("Consumed: " + item);
        isProduced = false; // Mark the item as consumed
        notify(); // Notify producer that the item has been consumed
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int item = 1;
        while (true) {
            try {
                buffer.produce(item++);
                Thread.sleep(1000); // Simulate time to produce an item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.consume();
                Thread.sleep(1500); // Simulate time to consume an item
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerITC {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
