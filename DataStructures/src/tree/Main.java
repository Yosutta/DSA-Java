package tree;

import java.util.Iterator;

public class Main {
    public static void main(String args[]){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(4);
        bst.add(7);
        bst.add(3);
        bst.add(5);
        bst.add(1);
        bst.add(2);
        bst.add(6);
        bst.add(8);

        Iterator traverse = bst.traverse(TreeTraverseType.LEVEL_ORDER);

        while(traverse.hasNext()){
            System.out.println(traverse.next());
        }
    }


}
