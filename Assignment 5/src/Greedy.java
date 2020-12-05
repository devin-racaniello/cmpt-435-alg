import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Greedy {
    public static void main(String[] args) {
        int i = -1;
        int curVer = 0;

        ArrayList<Spice> spicyBois = new ArrayList<Spice>();
        ArrayList<Integer> knapsacks = new ArrayList<Integer>();
        //read the file\

        String[] spiceReader = new String[3];

        /**

         -- Available spice to take
         spice name = red;    total_price =  4.0;  qty = 4;
         spice name = green;  total_price = 12.0;  qty = 6;
         spice name = blue;   total_price = 40.0;  qty = 8;
         spice name = orange; total_price = 18.0;  qty = 2;

         -- Available knapsacks in which to keep spice
         knapsack capacity =  1;
         knapsack capacity =  6;
         knapsack capacity = 10;
         knapsack capacity = 20;
         knapsack capacity = 21;
         **/

        try {
            File myObj = new File("spice.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                System.out.println("Line:" + data);
                System.out.println("i:" + i);
                System.out.println("curVer:" + curVer);

                if (data.contains("spice name")){
                    i++;
                    spiceReader = data.split(";");

                    for (int o = 0; o<spiceReader.length; o++){
                        spiceReader[o]=spiceReader[o].substring((spiceReader[o].indexOf("=")+2));
                    }

                    Spice temp = new Spice(spiceReader[0],Double.valueOf(spiceReader[1].trim()),Double.valueOf(spiceReader[2].trim()));

                    spicyBois.add(temp);


                }

                if (data.contains("knapsack capacity")){
                    System.out.println(data);
                    for (int t = data.length()-1; t>0; t--){
                        if (data.charAt(t)==' '){

                            knapsacks.add(Integer.valueOf(data.substring(t+1,data.length()-1)));
                            break;
                        }
                    }
                }


            }
            myReader.close();

            System.out.println("Spice bag 0");
            greedySpice(spicyBois,knapsacks.get(0));
            System.out.println("Spice bag 1");
            greedySpice(spicyBois,knapsacks.get(1));
            System.out.println("Spice bag 2");
            greedySpice(spicyBois,knapsacks.get(2));


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void greedySpice(ArrayList<Spice> spicyBois,int knapsack){

        double bestValue = 0.0;
        int bestIndex=0;
        ArrayList<String> bag = new ArrayList<String>();

        ArrayList<Double> tempValues = new ArrayList<Double>();
        for (int i = 0; i < spicyBois.size();i++ ){
            tempValues.add(spicyBois.get(i).value);
        }






        while(bag.size()<knapsack){
            //find best value
            //add to bag
            //remove amount

            for (int i = 0; i < tempValues.size();i++ ){
                if (tempValues.get(i)>bestValue){
                    bestValue = tempValues.get(i);
                    bestIndex = i;
                }

            }

            int putAmount = 0;

            if (knapsack<= bag.size()){
                putAmount = knapsack;
            } else {
                putAmount = bag.size()+1;
            }

            for (int g = 0;g < putAmount; g++){
                bag.add(spicyBois.get(bestIndex).name);
            }

            tempValues.set(bestIndex, 0.0);
            bestValue = 0.0;
            bestIndex= 0;

        }

        for (int h = 0;h < bag.size(); h++){
            System.out.print(bag.get(h)+" ");
        }
        System.out.println();







    }

}
