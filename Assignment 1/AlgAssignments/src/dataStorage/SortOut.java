package dataStorage;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SortOut {
    public static void main(String[] args) {
        Random myRand = new Random();
        boolean isPalandrome = true;
        ArrayList<String> outList = new ArrayList<String>();
        try {
            File myObj = new File("C:\\Users\\djrac\\Documents\\GitHub\\cmpt-435-alg\\Assignment 1\\AlgAssignments\\src\\dataStorage\\magicitems.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                outList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String outArray[] = new String[outList.size()];

        for (int i = 0; i < outList.size(); i++){
            outArray[i] = outList.get(i);
        }
        System.out.println(Arrays.toString(outArray));

        String mergeSortedArray[] = MergeSort.sort(outArray);
        String randomItems[] = new String[42];

        System.out.println(Arrays.toString(mergeSortedArray));


        for(int i = 0; i <= 41; i++){
            randomItems[i] = mergeSortedArray[myRand.nextInt(mergeSortedArray.length)];
        }

        System.out.println("Random Items: "+Arrays.toString(randomItems));

        System.out.println(LinearSearch.linearSearch(mergeSortedArray,0,randomItems[0])+" out of "+mergeSortedArray.length);
        BinarySearch bc = new BinarySearch();
        System.out.println(bc.binarySearch(mergeSortedArray,0,mergeSortedArray.length,randomItems[0])+" out of "+mergeSortedArray.length);
        System.out.println(bc.comp);
        int[] linComp = new int[42];
        int[] binComp = new int [42];

        for(int j = 0; j <= 41; j++){
            if (mergeSortedArray[LinearSearch.linearSearch(mergeSortedArray,0,randomItems[j])].equals(randomItems[j])){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }


    }
}
