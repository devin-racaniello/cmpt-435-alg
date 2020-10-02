
package dataStorage;
import java.util.Random;
import java.util.ArrayList;

public class QuickSort {
    public static String[] partition(String arr[], int low, int high){
        //get random between high and low
        //all nums less go one array all more go another
        //call function on both until too small
        //join back

        Random myRand = new Random();

        int partIndex = myRand.nextInt(high-low)+low;


        ArrayList<String> lowArr = new ArrayList<String>();
        ArrayList<String> highArr = new ArrayList<String>();





        for (int i = low; i < high; i++){
            if (arr[i].length()<arr[partIndex].length()){
                lowArr.add(arr[i]);
            } else if (arr[i].length()>arr[partIndex].length()){
                highArr.add(arr[i]);
            }

        }

        String lowA[] = new String[lowArr.size()];
        String highA[] = new String[highArr.size()];

        for (int o = 0; o < lowArr.size(); o++){
            lowA[o] = lowArr.get(o);
        }
        for (int j = 0; j < highArr.size(); j++){
            highA[j] = highArr.get(j);
        }


        if (lowArr.size()>2){
            lowA = partition(lowA,0,lowArr.size());
        }
        if (highArr.size()>2){
            highA = partition(highA,0,highArr.size());
        }

        String result[] = new String[arr.length];

        System.arraycopy(lowA, 0, result, 0, lowA.length);
        System.arraycopy(highA, 0, result, lowA.length, highA.length);

        return result;
    }
}
