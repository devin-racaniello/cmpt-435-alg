package dataStorage;

public class LinearSearch {

    public static int linearSearch(String myArr[], int left, String x){
        for (int i = left; i < myArr.length; i++) {
            if (myArr[i].equals(x))
                return i;
        }
        return -1;

    }
}
