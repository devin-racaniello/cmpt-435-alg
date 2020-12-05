
import java.util.ArrayList;

public class GraphNode {
    public int vertex;
    public ArrayList<GraphNode> link = new ArrayList<GraphNode>();


    GraphNode(int dta) {
        this.vertex = dta;
    }
    GraphNode() {
        this.vertex = -1;
    }

    public String toString() {
        return vertex + "";
    }

    public void addLinks(ArrayList<GraphNode> gn){
        for (int i = 0; i < gn.size();i++){
            link.add(gn.get(i));
        }
    }

    public void addLink(GraphNode linky){
        link.add(linky);
    }







}
