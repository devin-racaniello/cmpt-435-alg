package dataStorage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class HashChain {
    private static final int TABLE_SIZE = 250;

    public String[] hashContents = new String[TABLE_SIZE];




    private int makeHashCode(String input) {
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
    public void AddItem(String item) {
        hashContents[makeHashCode(item)] = item;

        //need linked list


    }





}
