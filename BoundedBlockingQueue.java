// 11. Bounded Blocking Queue
import java.util.LinkedList;
import java.util.Queue;

class BoundedBlockingQueue<T> {
    private final int capacity;
    private final Queue<T> queue = new LinkedList<>();

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.offer(item);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T item = queue.poll();
        notifyAll();
        return item;
    }

    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        BoundedBlockingQueue<Integer> bbq = new BoundedBlockingQueue<>(3);

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    bbq.enqueue(i);
                    System.out.println("Produced: " + i);
                } catch (InterruptedException e) {
                    System.out.println("Producer interrupted");
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    int val = bbq.dequeue();
                    System.out.println("Consumed: " + val);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted");
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
