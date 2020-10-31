package dataStorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class HashChain {

    private static final int TABLE_SIZE = 250;

    public MyNode[] hashContents = new MyNode[TABLE_SIZE];

    public int comp = 0;






    public int makeHashCode(String input) {
        input = input.toLowerCase();

        int len = input.length();
        int totalLetters = 0;

        for (int i = 0; i < len; i++) {

            char currLetter = input.charAt(i);
            int currValue = (int)currLetter;
            totalLetters = totalLetters + currValue;

            /*
            System.out.print(" [");
            System.out.print(thisLetter);
            System.out.print(thisValue);
            System.out.print("] ");
            // */

        }

        int hashCode = (totalLetters * 1) % TABLE_SIZE;

        return hashCode;

    }
    public void addItem(String item) {
        MyNode node = new MyNode(item);
        MyNode check = new MyNode();

        if (hashContents[makeHashCode(item)]==null){
            hashContents[makeHashCode(item)] = node;
        } else {
            check = hashContents[makeHashCode(item)];
            while (!(check.next==null)){
                check = check.next;

            }
            check.next = node;
        }


        //System.out.println(node.info);



        //need linked list
    }


    public String getItem(int index){
        comp = 0;
        if(hashContents[index]==null){
            return null;
        }
        comp++;
        MyNode check = new MyNode();
        check = hashContents[index];
        String out = "";
        if(!(check==null)){
            out += check.info+", ";
            comp++;
        }

        while (!(check.next==null)){


            check = check.next;
            comp++;
            out += check.info+", ";

            //if((check.next==null)){

                //comp++;
                //out += check.info;
            //}


        }
        return out;
    }

    public int getLength(){
        int len = 0;
        for (int i = 0; i < TABLE_SIZE; i++){
            MyNode check = new MyNode();
            check = hashContents[i];

            if (!(check==null)){
                len++;

                while (!(check.next==null)){

                    len++;
                    check = check.next;

                }
            }


        }
        return len;
    }







}
