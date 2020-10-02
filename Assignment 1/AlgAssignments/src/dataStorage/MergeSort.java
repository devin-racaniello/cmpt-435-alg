package dataStorage;

import java.util.Arrays;

public class MergeSort {
    public static String[] sort(String input[]){
        int l = input.length;

        int m = (int) Math.ceil(l/2);


        String arr1[] = Arrays.copyOfRange(input, 0, m);
        String arr2[] = Arrays.copyOfRange(input, m+1, l);

        if (arr1.length > 1){
            sort(arr1);
        }
        if (arr2.length > 1){
            sort(arr2);
        }
        return(merge(arr1,arr2));









    }

    static String[] merge(String leftArr[], String rightArr[]){
        int l_iter = 0;
        int r_iter = 0;
        int comb_iter = 0;

        String combArr[] = new String[leftArr.length+rightArr.length];

        while (l_iter < leftArr.length||r_iter < rightArr.length){
            if (leftArr[l_iter].length() < rightArr[r_iter].length()) {
                combArr[comb_iter] = leftArr[l_iter];
                l_iter++;
            } else {
                combArr[comb_iter] = rightArr[r_iter];
                r_iter++;
            }
            comb_iter++;
        }
        return combArr;
    }
}
