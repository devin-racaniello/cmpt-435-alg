package dataStorage;

public class BinarySearch {
    public int comp = 0;

    public int binarySearch(String myArr[], int left, int right, String x){

        if (right >= left) {


            //((right - left) / 2) + left;
            int m = left + (right-left) / 2;

            this.comp++;
            if (myArr[m].equals(x)){
                return m;
            }

            //System.out.println(m);
            //Since the algorithm cant differentiate order of same length strings I am running linear seach with my left bound added to cut search time

            if (myArr[m].length() == x.length()){
                return LinearSearch.linearSearch(myArr, left, x);
            }

            if (myArr[m].length() > x.length()){
                return binarySearch(myArr, left, m - 1, x);
            }
            return binarySearch(myArr, m, right, x);




        }
        return -1;
    }
    public int popComp(){
        int out = this.comp;
        this.comp = 0;
        return out;
    }

}
