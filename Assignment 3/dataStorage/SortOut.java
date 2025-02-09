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
        HashChain MagicItemHash = new HashChain();
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
            MagicItemHash.addItem(outArray[i]);
        }
        System.out.println("Array: "+Arrays.toString(outArray));

        String mergeSortedArray[] = MergeSort.sort(outArray);
        String randomItems[] = new String[42];

        System.out.println("MergeSorted Array: "+Arrays.toString(mergeSortedArray));


        for(int i = 0; i <= 41; i++){
            randomItems[i] = mergeSortedArray[myRand.nextInt(mergeSortedArray.length)];
        }

        System.out.println("Random Items: "+Arrays.toString(randomItems));

        BinarySearch bc = new BinarySearch();

        int[] linComp = new int[42];
        int[] binComp = new int [42];
        int[] hashComp = new int[42];
        int linTot = 0;
        int binTot = 0;
        int hashTot =0;

        for(int j = 0; j <= 41; j++){
            linComp[j] = LinearSearch.linearSearch(mergeSortedArray,0, randomItems[j]);
            bc.binarySearch(mergeSortedArray,0,mergeSortedArray.length,randomItems[j]);
            binComp[j] = bc.popComp();
            linTot += linComp[j];
            binTot += binComp[j];
        }

        double linAverage = linTot/42.0;
        double binAverage = binTot/42.0;

        System.out.println("Linear comparisons: " +Arrays.toString(linComp));
        System.out.println("Binary comparisons: " +Arrays.toString(binComp));

        System.out.println("Linear Average: " +linAverage);
        System.out.println("Binary Average: " +binAverage);

        System.out.println(MagicItemHash.getLength());

        System.out.println(mergeSortedArray.length);

        for(int h = 0; h <= 41; h++){

            MagicItemHash.getItem(MagicItemHash.makeHashCode(randomItems[h]));
            hashComp[h] = MagicItemHash.comp;
            hashTot += MagicItemHash.comp;

        }
        double hashAverage = hashTot/42.0;

        System.out.println("Hash comparisons: " +Arrays.toString(hashComp));
        System.out.println("Hash Average: " +hashAverage);


    }
}
