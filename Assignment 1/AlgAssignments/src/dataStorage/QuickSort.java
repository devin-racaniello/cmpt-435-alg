
package dataStorage;
import java.util.Random;
import java.util.ArrayList;

public class QuickSort {
    public static int partition(String arr[], int low, int high){
        //get random between high and low
        //all nums less go one array all more go another
        //call function on both until too small
        //join back

        Random myRand = new Random();

        int partIndex = myRand.nextInt(high-low)+low;
        int index = low-1;







        for (int i = low; i < high; i++){
            if (arr[i].length()<arr[partIndex].length()){
                index++;

                String temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

            }

        }

        String temp = arr[index+1];
        arr[index+1] = arr[partIndex];
        arr[partIndex] = temp;

        return index+1;

    }

    public static String[] sort(String arr[], int low, int high){

        if(low < high) {
            int index = partition(arr, low, high);

            sort(arr, low, index-1);
            sort(arr, index+1, high);
        }
        return arr;
    }
}
