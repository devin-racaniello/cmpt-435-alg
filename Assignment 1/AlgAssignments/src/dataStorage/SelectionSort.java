package dataStorage;

public class SelectionSort {
    void sort(String input[])
    {
        int l = input.length;

        // iterate the subarray
        for (int i = 0; i < l-1; i++)
        {


            int min = i;

            //find min in the array
            for (int j = i+1; j < l; j++){
                if (input[j].length() <  input[min].length())
                    min = j;
            }

            // swap positions of the min and the current spot

            String temp = input[min];

            input[min] = input[i];
            input[i] = temp;
        }

    }
}
