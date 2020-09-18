package dataStorage;

public class MyStack {

    MyNode top = new MyNode();

    public boolean isEmpty(){
        if(top.toString().equals("null")) {
            return true;
        }
        else {
            return false;
        }
    }
    public void push(String input){
        MyNode node = new MyNode(input);
        MyNode oldTop = top;
        node.next = oldTop;
        this.top = node;
    }

    public String pop(){
        String pop = "";
        if (this.isEmpty()){
            pop = "err empty";
        } else {
            pop = top.toString();
            top = top.next;
        }

        System.out.print(pop);
        return pop;
    }

}
