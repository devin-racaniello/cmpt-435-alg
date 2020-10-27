package dataStorage;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SortOut {
    public static void main(String[] args) {
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
        System.out.println(Arrays.toString(SelectionSort.sort(outArray)));
        System.out.println(Arrays.toString(InsertionSort.sort(outArray)));
        System.out.println(Arrays.toString(MergeSort.sort(outArray)));
        System.out.println(Arrays.toString(QuickSort.sort(outArray,0,outArray.length)));



    }
}
