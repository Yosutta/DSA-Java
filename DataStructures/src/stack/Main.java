package stack;

public class Main {
    public static void main(String[] args) {
//        ArrayBasedStack<String> stack = new ArrayBasedStack<>();
//        stack.push("LMAO");
//        stack.push("This is a robbery");
//        System.out.println(stack.pop());
//        stack.push("Can you believe this?");
//        stack.push("A");
//        stack.push("B");
//        stack.push("C");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.toString());

        LinkedListBasedStack<String> list = new LinkedListBasedStack<>();
        System.out.println(list.isEmpty());
        list.push("Phuc");
        list.push("Loc");
        System.out.println(list.isEmpty());
        list.push("Tho");
        list.push("Cung");
        list.push("Hi");
        list.push("Phat");
        list.push("Tai");
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
    }
}