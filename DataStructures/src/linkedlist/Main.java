package linkedlist;

public class Main {
    public static void main(String[] args){
        TinDoublyLinkedList list = new TinDoublyLinkedList();
        list.add("Ahihi");
        list.addFirst("LMAO");
        list.addLast("This is a robbery");
        list.addFirst("head");
        list.addLast("tail");
        list.remove("LMAO");
        System.out.println(list.toString());
    }
}
