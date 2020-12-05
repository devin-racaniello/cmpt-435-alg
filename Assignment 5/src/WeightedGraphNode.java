
import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraphNode {
    public int vertex;
    public HashMap<WeightedGraphNode,Integer> linkMap = new HashMap<WeightedGraphNode,Integer>();
    public ArrayList<WeightedGraphNode> link = new ArrayList<WeightedGraphNode>();






    WeightedGraphNode(int dta) {
        this.vertex = dta;
    }
    WeightedGraphNode() {
        this.vertex = -1;
    }

    public String toString() {
        return vertex + "";
    }

    /**
    public void addLinks(ArrayList<WeightedGraphNode> gn){
        for (int i = 0; i < gn.size();i++){
            link.add(gn.get(i));
        }
    }**/

    public void addLink(WeightedGraphNode linky,int weight){
        linkMap.put(linky,weight);
        link.add(linky);
    }











}
