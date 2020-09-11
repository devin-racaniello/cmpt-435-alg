package dataStorage;

public class LinkedoList {
    //MyNode n1 = new MyNode("8");
    //MyNode n2 = new MyNode("Joe");

    public static void main(String[] args) {
        MyNode n1 = new MyNode("8");
        MyNode n2 = new MyNode("Joe");
        n1.next = n2;
        System.out.println(n1.next);
    }



}
