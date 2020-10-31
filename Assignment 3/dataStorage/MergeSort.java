package dataStorage;

import java.util.Arrays;

public class MergeSort {
    public static String[] sort(String input[]){

        int l = input.length;

        if(l <= 1) {

            return input;

        }

        int m = (int) Math.ceil(l/2);


        String arr1[] = Arrays.copyOfRange(input, 0, m);
        String arr2[] = Arrays.copyOfRange(input, m, l);
        //System.out.println(arr1.length+arr2.length + " " + l);
        String result[] = new String[input.length];

        arr1 = sort(arr1);
        arr2 = sort(arr2);

        result = merge(arr1,arr2);
        return(result);









    }

    static String[] merge(String leftArr[], String rightArr[]){
        int l_iter = 0;
        int r_iter = 0;
        int comb_iter = 0;

        String combArr[] = new String[leftArr.length+rightArr.length];

        //System.out.println(Arrays.toString(leftArr)+Arrays.toString(rightArr));


        /*

        while(leftPointer < left.length || rightPointer < right.length) {

            if(leftPointer < left.length && rightPointer < right.length) {

                if(left[leftPointer] < right[rightPointer]) {

                    result[resultPointer++] = left[leftPointer++];
                }   else {

                    result[resultPointer++] = right[rightPointer++];
                }

            }

            else if(leftPointer < left.length) {

                result[resultPointer++] = left[leftPointer++];

            }

            else if(rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer];
            }

        }
         */
        while (l_iter < leftArr.length||r_iter < rightArr.length){
            if (l_iter < leftArr.length && r_iter < rightArr.length){
                if (leftArr[l_iter].length() < rightArr[r_iter].length()){
                    combArr[comb_iter] = leftArr[l_iter];
                    l_iter++;
                    comb_iter++;
                } else {
                    combArr[comb_iter] = rightArr[r_iter];
                    r_iter++;
                    comb_iter++;
                }

            } else if (l_iter < leftArr.length){
                combArr[comb_iter] = leftArr[l_iter];
                l_iter++;
                comb_iter++;
            } else if (r_iter < rightArr.length){
                combArr[comb_iter] = rightArr[r_iter];
                r_iter++;
                comb_iter++;
            }

        }
        return combArr;
    }
}
