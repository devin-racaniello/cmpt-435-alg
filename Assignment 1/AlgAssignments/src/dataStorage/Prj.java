package dataStorage;
import java.util.Random;


public class Prj {
    private static Person[] testGroup = new Person[1000];
    private static Random rand = new Random();
    public static String outy = "";
    public static int posit = 0;
    public static int tests = 0;
    public static int case1 = 0;
    public static int case2 = 0;
    public static int case3 = 0;

    public static void main(String[] args) {

        sim(1000);
        split();
        System.out.println();
        System.out.println("The infected patients are "+ outy);
        System.out.println(tests +" number of tests were used");

        System.out.println("case 1:"+case1);
        System.out.println("case 2:"+case2);
        System.out.println("case 3:"+case3);

    }

    public static void sim(int size){
        make(size);
        int rate = 0;
        int pos = 0;
        int neg = 0;


        for (int i = 0; i < size; i++){
            rate = rand.nextInt(50);
            if (rate == 0){
                testGroup[i].hasCovid = true;
                System.out.print(i+" ");
                pos++;
            } else {
                testGroup[i].hasCovid = false;
                neg++;
            }

        }
        System.out.println("Infection rate is " +(1-(double)neg/size));


    }

    private static void make(int size){
        for (int i = 0; i < size; i++){
            testGroup[i] = new Person();
        }
    }

    private static void split(){
        Person[] temp = new Person[8];

        for (int i = 0; i < testGroup.length; i++){
            //System.out.print(i%8);
            temp[(i%8)] = testGroup[i];
            if (i%8 == 7){
                System.out.print(" ");
                test(temp);
            }
        }


        //size % 8
    }

    private static void test(Person[] group){
        Person[] lTemp = new Person[group.length/2];
        Person[] rTemp = new Person[group.length/2];



        if (testGroup(group)){
            if (group.length == 8){

                System.out.print("[");
                for (int i = 0; i < group.length; i++){



                    /**
                     if (group[i].hasCovid == true){
                     System.out.print("*");
                     infected = true;
                     }

                     System.out.print(group[i].id+" ");


                     **/
                    if (i < group.length/2){
                        lTemp[i] = group[i];
                        //System.out.println("l "+ lTemp[i]);
                    }
                    if (i >= group.length/2) {
                        rTemp[i%(group.length/2)] = group[i];
                        //System.out.print(" "+i%(group.length/2)+" ");
                        //System.out.println("r "+ group[i]);
                    }


                }
                System.out.print("]");
            }


            int grpCount = 0;
            if (testGroup(lTemp)){
                System.out.print("[");
                for (int i = 0; i < lTemp.length; i++){
                    tests++;


                    if (lTemp[i].hasCovid == true){
                        grpCount++;
                        outy += lTemp[i].id+", ";
                        System.out.print("*");
                        //System.out.print(lTemp[i].id+", ");
                    }
                    System.out.print(lTemp[i].id+" ");
                }
                System.out.print("]");

                if (grpCount == 1){
                    case2++;
                } else if (grpCount > 1){
                    case3++;
                }
            }


            grpCount = 0;
            if (testGroup(rTemp)){
                System.out.print("[");
                for (int j = 0; j < rTemp.length; j++){
                    tests++;
                    if (rTemp[j].hasCovid == true){
                        grpCount++;
                        outy += rTemp[j].id+", ";
                        System.out.print("*");
                        //System.out.print(rTemp[j].id+", ");
                    }
                    System.out.print(rTemp[j].id+" ");
                }
                System.out.print("]");

                if (grpCount == 1){
                    case2++;
                } else if (grpCount > 1){
                    case3++;
                }
            }
        } else {
            case1++;
        }







    }

    private static boolean testGroup(Person[] group){
        boolean infected = false;

        tests++;

        for (int i = 0; i < group.length; i++){


            if (group[i].hasCovid == true){
                System.out.print("*");
                infected = true;
            }
        }
        return infected;
    }




}
