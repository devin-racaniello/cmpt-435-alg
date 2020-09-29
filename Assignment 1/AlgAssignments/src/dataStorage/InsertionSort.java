package dataStorage;

public class InsertionSort {
    void sort(String input[])
    {
        int l = input.length;

        //iterate the array starting from left
        for (int i = 1; i < l; ++i) {

            String val = input[i];
            int j = i - 1;

            //Work backwards until the val fits in the correct order
            while (input[j].length() > val.length() && j >= 0) {

                input[j + 1] = input[j];
                j = j - 1;
            }


            input[j + 1] = val;
        }

    }
}
