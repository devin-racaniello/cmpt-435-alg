

package dataStorage;


public class MyNode {
    public String info;
    public MyNode next;

    MyNode(String dta) {
        this.info = dta;
        this.next = null;
    }
    MyNode() {
        this.info = null;
        this.next = null;
    }

    public String toString() {
        return info + "";
    }


}
