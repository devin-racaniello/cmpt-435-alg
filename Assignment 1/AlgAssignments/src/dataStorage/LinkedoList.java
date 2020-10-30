package dataStorage;
import java.util.ArrayList;

public class LinkedoList {

    public static void main(String[] args) {
        //linked lists
        MyNode n1 = new MyNode("8");
        MyNode n2 = new MyNode("Joe");
        n1.next = n2;
        System.out.println(n1.next);

        MyStack s1 = new MyStack();
        s1.push("Lion");
        s1.push("Gator");
        System.out.println(s1.pop());

        MyQueue q1 = new MyQueue();
        q1.enqueue("Salad");
        q1.enqueue("Fingers");
        System.out.println(q1.deque());
        System.out.println(q1.deque());




    }



}
