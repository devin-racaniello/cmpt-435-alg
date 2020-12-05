
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WeightedGraph {



    static void makeEdge(ArrayList<ArrayList<Integer>> adjList, int d0, int d1) {
        System.out.println("ME:"+adjList);

        adjList.get(d0).add(d1);
        adjList.get(d1).add(d0);
    }


    static ArrayList<WeightedGraphNode> printDFS(ArrayList<WeightedGraphNode> gn) {
        return gn;
    }

    //do i make void?
    static ArrayList<WeightedGraphNode> printBFS(ArrayList<WeightedGraphNode> gn) {

        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<WeightedGraphNode> output = new ArrayList<WeightedGraphNode>();

        System.out.print(gn.get(0)+" ");
        for (int t = 0; t < gn.size(); t++){

            queue.add(gn.get(t).vertex);

            for (int h = 0; h < gn.get(t).link.size(); h++){
                if (!queue.contains(gn.get(t).link.get(h).vertex)){
                    output.add(gn.get(t).link.get(h));
                    queue.add(gn.get(t).link.get(h).vertex);
                    System.out.print(gn.get(t).link.get(h)+" ");

                }

            }


        }

        System.out.println();
        return output;

    }

    public static void bellmanShortest(ArrayList<WeightedGraphNode> gn){
        ArrayList<Integer> currentWeights = new ArrayList<Integer>();

        //set intitial values
        currentWeights.add(0);
        for (int i = 1; i < gn.size(); i++){
            currentWeights.add(9999);
        }


        for (int o = 1; o < gn.size(); o++){

            for (int t = 0; t < gn.get(o).link.size(); t++){

                if (currentWeights.get(gn.indexOf(gn.get(o).link))>gn.get(o).linkMap.get(gn.get(o).link.get(t))){
                    currentWeights.set(gn.indexOf(gn.get(o).link),gn.get(o).linkMap.get(gn.get(o).link.get(t)));
                }

            }

        }






    }


    // Driver Code
    public static void main(String[] args) {

        ArrayList<ArrayList<ArrayList<Integer> > > adj = new ArrayList<ArrayList<ArrayList<Integer> > >();
        ArrayList<ArrayList<WeightedGraphNode> > graphObjects= new ArrayList<ArrayList<WeightedGraphNode>>();
        ArrayList<WeightedGraphNode> queue = new ArrayList<WeightedGraphNode>();
        int i = -1;
        int curVer = 0;
        String edge1 = "";
        String edge2 = "";
        int weight = 0;
        int edgeNum1 = 0;
        int edgeNum2 = 0;
        int offset = 1;
        int counter = 0;

        try {
            File myObj = new File("graphs2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                System.out.println("Line:"+data);
                System.out.println("i:"+i);
                System.out.println("curVer:"+curVer);

                System.out.println(graphObjects);

                System.out.println(adj);

                if (data.contains("new graph")){
                    i++;
                    offset = 1;
                    continue;
                }
                if (data.contains("add vertex 0")){
                    offset = 0;
                }
                if (data.contains("add vertex")){
                    adj.add(new ArrayList<ArrayList<Integer>>());
                    adj.get(i).add(new ArrayList<Integer>());

                    if (data.length()==12){
                        graphObjects.add(new ArrayList<WeightedGraphNode>());
                        graphObjects.get(i).add(new WeightedGraphNode(Integer.parseInt(data.substring(11,12))));
                    }
                    else {
                        graphObjects.add(new ArrayList<WeightedGraphNode>());
                        graphObjects.get(i).add(new WeightedGraphNode(Integer.parseInt(data.substring(11,13))));
                    }

                }
                if (data.contains("add edge")){

                    counter = 8;
                    while (counter<data.length()){
                        if (data.charAt(counter)==' '||data.charAt(counter)=='-'){

                        }else {

                            if (edge1.length()==0){
                                edge1 += data.charAt(counter);
                                if (data.charAt(counter+2)==' '&&data.charAt(counter+1)!=' '){
                                    counter++;
                                    edge1 += data.charAt(counter);
                                }
                            } else if (edge2.length()==0){
                                edge2 += data.charAt(counter);
                                if (data.charAt(counter+2)==' '&&data.charAt(counter+1)!=' '){
                                    counter++;
                                    edge2 += data.charAt(counter);
                                }

                            } else {

                                weight = Integer.parseInt(data.substring(counter));
                                break;


                            }

                        }

                        counter++;
                    }



                    /**
                    if(data.charAt(10)==' '){

                        edge1 = data.substring(9,10);
                        if(data.length()==14){
                            edge2 = data.substring(13,14);
                        } else {
                            edge2 = data.substring(13,15);
                        }
                    } else {

                        edge1 = data.substring(9,11);

                        if(data.length()==15){
                            edge2 = data.substring(14,15);
                        } else {
                            edge2 = data.substring(14,16);
                        }
                    }**/



                    edgeNum1 = Integer.parseInt(edge1)-offset;
                    edgeNum2 = Integer.parseInt(edge2)-offset;
                    WeightedGraphNode edgeNum2Node = new WeightedGraphNode(edgeNum2+offset);
                    System.out.println("edges:"+edge1+" "+edge2);
                    makeEdge(adj.get(i), edgeNum1, edgeNum2);




                    for (int h = 0; h < graphObjects.get(i).size(); h++) {
                        if (graphObjects.get(i).get(h).vertex == edgeNum1+offset){
                            graphObjects.get(i).get(h).addLink(edgeNum2Node,weight);
                        }
                    }

                    edge1 = "";
                    edge2 = "";






                }



            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ArrayList<WeightedGraphNode> output = new ArrayList<WeightedGraphNode>();

        //printAdjacencyList(adj.get(0));
        //printAdjacencyList(adj.get(1));
        //printAdjacencyList(adj.get(2));
        //printAdjacencyList(adj.get(3));
        //printAdjacencyList(adj.get(4));
        output = (printBFS(graphObjects.get(0)));
        output = (printBFS(graphObjects.get(1)));
        output = (printBFS(graphObjects.get(2)));
        output = (printBFS(graphObjects.get(3)));




        /**
         //num of verticies
         int v0 = 7,  v1 = 8, v2 = 63, v3 = 64, v4 = 20;
         ArrayList<ArrayList<Integer> > adj0 = new ArrayList<ArrayList<Integer> >(v0);
         ArrayList<ArrayList<Integer> > adj1 = new ArrayList<ArrayList<Integer> >(v1);
         ArrayList<ArrayList<Integer> > adj2 = new ArrayList<ArrayList<Integer> >(v2);
         ArrayList<ArrayList<Integer> > adj3 = new ArrayList<ArrayList<Integer> >(v3);
         ArrayList<ArrayList<Integer> > adj4 = new ArrayList<ArrayList<Integer> >(v4);



         //0
         //adding verticies
         for (int i = 0; i < (v0+1); i++)
         adj0.add(new ArrayList<Integer>());
         Graph g0 = new Graph();

         // Adding edges one by one
         g0.makeEdge(adj0, 1, 2);
         g0.makeEdge(adj0, 1, 5);
         g0.makeEdge(adj0, 1, 6);
         g0.makeEdge(adj0, 2, 3);
         g0.makeEdge(adj0, 4, 5);
         g0.makeEdge(adj0, 5, 6);
         g0.makeEdge(adj0, 5, 7);
         g0.makeEdge(adj0, 6, 7);

         //1
         //adding verticies
         for (int i = 0; i < (v1+1); i++)
         adj1.add(new ArrayList<Integer>());
         Graph g1 = new Graph();

         // Adding edges one by one
         g1.makeEdge(adj1, 2, 1);
         g1.makeEdge(adj1, 3, 1);
         g1.makeEdge(adj1, 4, 1);
         g1.makeEdge(adj1, 5, 1);
         g1.makeEdge(adj1, 6, 1);
         g1.makeEdge(adj1, 7, 1);
         g1.makeEdge(adj1, 8, 1);
         g1.makeEdge(adj1, 3, 2);
         g1.makeEdge(adj1, 4, 2);
         g1.makeEdge(adj1, 5, 2);
         g1.makeEdge(adj1, 6, 2);
         g1.makeEdge(adj1, 7, 2);
         g1.makeEdge(adj1, 8, 2);
         g1.makeEdge(adj1, 4, 3);
         g1.makeEdge(adj1, 5, 3);
         g1.makeEdge(adj1, 6, 3);
         g1.makeEdge(adj1, 7, 3);
         g1.makeEdge(adj1, 8, 3);
         g1.makeEdge(adj1, 5, 4);
         g1.makeEdge(adj1, 6, 4);
         g1.makeEdge(adj1, 7, 4);
         g1.makeEdge(adj1, 8, 4);
         g1.makeEdge(adj1, 6, 5);
         g1.makeEdge(adj1, 7, 5);
         g1.makeEdge(adj1, 8, 5);
         g1.makeEdge(adj1, 7, 6);
         g1.makeEdge(adj1, 8, 6);
         g1.makeEdge(adj1, 8, 7);

         //2
         //adding verticies
         for (int i = 0; i < (v2+1); i++)
         adj2.add(new ArrayList<Integer>());
         Graph g2 = new Graph();

         // Adding edges one by one
         g2.makeEdge(adj2, 2, 1);
         g2.makeEdge(adj2, 3, 1);
         g2.makeEdge(adj2, 4, 2);
         g2.makeEdge(adj2, 5, 2);
         g2.makeEdge(adj2, 6, 3);
         g2.makeEdge(adj2, 7, 3);
         g2.makeEdge(adj2, 8, 4);
         g2.makeEdge(adj2, 9, 4);
         g2.makeEdge(adj2, 10, 5);
         g2.makeEdge(adj2, 11, 5);
         g2.makeEdge(adj2, 12, 6);
         g2.makeEdge(adj2, 13, 6);
         g2.makeEdge(adj2, 14, 7);
         g2.makeEdge(adj2, 15, 7);
         g2.makeEdge(adj2, 16, 8);
         g2.makeEdge(adj2, 17, 8);
         g2.makeEdge(adj2, 18, 9);
         g2.makeEdge(adj2, 19, 9);
         g2.makeEdge(adj2, 20, 10);
         g2.makeEdge(adj2, 21, 10);
         g2.makeEdge(adj2, 22, 11);
         g2.makeEdge(adj2, 23, 11);
         g2.makeEdge(adj2, 24, 12);
         g2.makeEdge(adj2, 25, 12);
         g2.makeEdge(adj2, 26, 13);
         g2.makeEdge(adj2, 27, 13);
         g2.makeEdge(adj2, 28, 14);
         g2.makeEdge(adj2, 29, 14);
         g2.makeEdge(adj2, 30, 15);
         g2.makeEdge(adj2, 31, 15);
         g2.makeEdge(adj2, 32, 16);
         g2.makeEdge(adj2, 33, 16);
         g2.makeEdge(adj2, 34, 17);
         g2.makeEdge(adj2, 35, 17);
         g2.makeEdge(adj2, 36, 18);
         g2.makeEdge(adj2, 37, 18);
         g2.makeEdge(adj2, 38, 19);
         g2.makeEdge(adj2, 39, 19);
         g2.makeEdge(adj2, 40, 20);
         g2.makeEdge(adj2, 41, 20);
         g2.makeEdge(adj2, 42, 21);
         g2.makeEdge(adj2, 43, 21);
         g2.makeEdge(adj2, 44, 22);
         g2.makeEdge(adj2, 45, 22);
         g2.makeEdge(adj2, 46, 23);
         g2.makeEdge(adj2, 47, 23);
         g2.makeEdge(adj2, 48, 24);
         g2.makeEdge(adj2, 49, 24);
         g2.makeEdge(adj2, 50, 25);
         g2.makeEdge(adj2, 51, 25);
         g2.makeEdge(adj2, 52, 26);
         g2.makeEdge(adj2, 53, 26);
         g2.makeEdge(adj2, 54, 27);
         g2.makeEdge(adj2, 55, 27);
         g2.makeEdge(adj2, 56, 28);
         g2.makeEdge(adj2, 57, 28);
         g2.makeEdge(adj2, 58, 29);
         g2.makeEdge(adj2, 59, 29);
         g2.makeEdge(adj2, 60, 30);
         g2.makeEdge(adj2, 61, 30);
         g2.makeEdge(adj2, 62, 31);
         g2.makeEdge(adj2, 63, 31);

         g2.printAdjacencyList(adj2);







         for (int i = 0; i < (v3+1); i++)
         adj3.add(new ArrayList<Integer>());
         Graph g3 = new Graph();

         // Adding edges one by one
         g2.makeEdge(adj3, 2, 1);
         g2.makeEdge(adj3, 3, 1);
         g2.makeEdge(adj3, 4, 2);
         g2.makeEdge(adj3, 5, 2);
         g2.makeEdge(adj3, 6, 3);
         g2.makeEdge(adj3, 7, 3);
         g2.makeEdge(adj3, 8, 4);
         g2.makeEdge(adj3, 9, 4);
         g2.makeEdge(adj3, 10, 5);
         g2.makeEdge(adj3, 11, 5);
         g2.makeEdge(adj3, 12, 6);
         g2.makeEdge(adj3, 13, 6);
         g2.makeEdge(adj3, 14, 7);
         g2.makeEdge(adj3, 15, 7);
         g2.makeEdge(adj3, 16, 8);
         g2.makeEdge(adj3, 17, 8);
         g2.makeEdge(adj3, 18, 9);
         g2.makeEdge(adj3, 19, 9);
         g2.makeEdge(adj3, 20, 10);
         g2.makeEdge(adj3, 21, 10);
         g2.makeEdge(adj3, 22, 11);
         g2.makeEdge(adj3, 23, 11);


         g3.printAdjacencyList(adj3);
         **/


    }

}

