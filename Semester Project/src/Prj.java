import java.util.Random;
import java.lang.Math;
import java.util.Scanner;


public class Prj {
    public static int amount = 1000;
    private static Person[] testGroup = new Person[amount];
    private static Random rand = new Random();
    public static String outy = "";
    public static int pos = 0;
    public static int tests = 0;
    public static int case1 = 0;
    public static int case2 = 0;
    public static int case3 = 0;
    public static int groups = 0;

    public static void main(String[] args) {

        Scanner comms = new Scanner(System.in);
        String content = "";
        double rate  = 2.0;

        System.out.println("Welcome to the AMERICA, I mean my program SuperSpreader.\nPress d, enter to perform a default simulation.\nPress e, enter to edit the settings");

        content = comms.next();

        if(content.equalsIgnoreCase("e")){
            System.out.println("What population size: ");
            amount = comms.nextInt();
            System.out.println("What infection rate (ex 2%=2): ");
            rate = comms.nextDouble();
        }

        testGroup = new Person[amount];

        sim(amount,rate);
        //change name
        splitTest();



        //System.out.println();
        //System.out.println("The infected patients are "+ outy);

        int trueTests = case1+(case2*7)+(case3*11);




        double scale = Math.pow(10, 4);
        double case1Percent = Math.round(case1/((double)case2+case3+case1)*scale)/scale,case2Percent = Math.round(case2/((double)case2+case3+case1)*scale)/scale, case3Percent = Math.round(case3/((double)case2+case3+case1)*scale)/scale;

        System.out.println("-------------------------------------------------" );

        System.out.println("case 1: "+groups+" x "+case1Percent+" = "+case1+" requiring "+case1+ " tests");
        System.out.println("case 2: "+groups+" x "+case2Percent+" = "+case2+" requiring "+case2*7+ " tests");
        System.out.println("case 3: "+groups+" x "+case3Percent+" = "+case3+" requiring "+case3*11+ " tests" );

        System.out.println("-------------------------------------------------" );


        System.out.println(trueTests+" tests used and "+pos+ " infections in a population of "+amount+" people with an infection rate of "+((double)pos/amount)*100+"%.");
    }

    public static void sim(int size,double rate){
        make(size);
        int hasRatio = 0;
        int neg = 0;


        double bound = (100/rate);
        //System.out.println(bound);

        for (int i = 0; i < size; i++){
            hasRatio = rand.nextInt((int)bound);
            if (hasRatio == 0){
                testGroup[i].hasCovid = true;
                //System.out.print(i+" ");
                pos++;
            } else {
                testGroup[i].hasCovid = false;
                neg++;
            }

        }
        //System.out.println("Infection rate is " +(1-(double)neg/size));


    }

    private static void make(int size){
        for (int i = 0; i < size; i++){
            testGroup[i] = new Person();
        }
    }

    private static void splitTest(){
        Person[] temp = new Person[8];


        for (int i = 0; i < testGroup.length; i++){
            //System.out.print(i%8);
            temp[(i%8)] = testGroup[i];
            if (i%8 == 7){
                //System.out.print(" ");
                test(temp);
                groups+=1;
            }
        }


        //size % 8
    }

    private static void test(Person[] group){
        Person[] lTemp = new Person[group.length/2];
        Person[] rTemp = new Person[group.length/2];



        if (testGroup(group)){
            if (group.length == 8){

                //System.out.print("[");
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
                //System.out.print("]");
            }


            int grpCount = 0;
            if (testGroup(lTemp)){
                //System.out.print("[");
                for (int i = 0; i < lTemp.length; i++){
                    tests++;


                    if (lTemp[i].hasCovid == true){
                        grpCount++;
                        outy += lTemp[i].id+", ";
                        //System.out.print("*");
                        //System.out.print(lTemp[i].id+", ");
                    }
                    //System.out.print(lTemp[i].id+" ");
                }
                //System.out.print("]");

                if (grpCount == 1){
                    case2++;
                } else if (grpCount > 1){
                    case3++;
                }
            }


            grpCount = 0;
            if (testGroup(rTemp)){
                //System.out.print("[");
                for (int j = 0; j < rTemp.length; j++){
                    tests++;
                    if (rTemp[j].hasCovid == true){
                        grpCount++;
                        outy += rTemp[j].id+", ";
                        //System.out.print("*");
                        //System.out.print(rTemp[j].id+", ");
                    }
                    //System.out.print(rTemp[j].id+" ");
                }
                //System.out.print("]");

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
                //System.out.print("*");
                infected = true;
            }
        }
        return infected;
    }




}
