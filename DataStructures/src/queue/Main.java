package queue;

public class Main {
    public static void main (String args[]){
//        ArrayBasedQueue<String> queue = new ArrayBasedQueue<>(10);
//        System.out.println(queue.isEmpty());
//        queue.enQueue("A");
//        queue.enQueue("B");
//        queue.enQueue("C");
//        queue.enQueue("D");
//        queue.enQueue("E");
//        queue.enQueue("F");
//        queue.enQueue("G");
//        queue.deQueue();
//        queue.deQueue();
//        queue.deQueue();
//        queue.enQueue("H");
//        queue.enQueue("I");
//        queue.enQueue("J");
//        System.out.println(queue.size());
//        System.out.println(queue.toString());
//        queue.enQueue("K");
//        queue.deQueue();
//        queue.deQueue();
//        queue.deQueue();
//        System.out.println(queue.peek());
//        queue.deQueue();
//        queue.deQueue();
//        queue.deQueue();
//        System.out.println(queue.size());
//        System.out.println(queue.toString());
//        System.out.println(queue.isEmpty());
//        queue.deQueue();
//        queue.deQueue();
//        System.out.println(queue.isEmpty());

        TinDoublyLinkedListBasedQueue<String> queue = new TinDoublyLinkedListBasedQueue<>();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
//        queue.enQueue("D");
//        queue.enQueue("E");
//        queue.enQueue("F");
//        queue.enQueue("G");
//        queue.enQueue("H");
//        queue.enQueue("I");
//        queue.enQueue("J");
//        queue.enQueue("K");
//        queue.enQueue("L");
//        queue.enQueue("M");
//        queue.enQueue("N");
//        queue.enQueue("O");
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue.toString());
    }
}
