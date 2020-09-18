package dataStorage;

public class MyQueue {

    MyNode top = new MyNode();
    MyNode lastNode = top;

    public boolean isEmpty(){
        if(top == null || top.toString().equals("null")) {
            return true;
        }
        else {
            return false;
        }
    }
    public void enqueue(String input){
        MyNode node = new MyNode(input);
        if (this.isEmpty()){
            top = node;
            lastNode = node;
            lastNode.next = null;
        } else {
            lastNode.next = node;
            lastNode = node;
        }

    }

    public String deque(){
        String pop = "";
        if (this.isEmpty()){
            pop = "err empty";
        } else {
            pop = top.toString();
            top = top.next;
        }

        //System.out.print(pop);
        return pop;
    }
}
