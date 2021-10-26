import com.mathsystem.entity.graph.Color;
import com.mathsystem.graphapi.AbstractEdge;
import com.mathsystem.graphapi.AbstractGraph;
import com.mathsystem.graphapi.Vertex;
import com.mathsystem.plugin.GraphProperty;

import java.util.ArrayList;
import java.util.HashSet;

public class BaseGraph implements GraphProperty {
    private HashSet<String> reachedVertecies;

    @Override
    public boolean execute(AbstractGraph abstractGraph) {
        ArrayList<Vertex> baseVertecies = new ArrayList<>();
        reachedVertecies = new HashSet<>();

        // Все красные вершины - проверяемая база графа
        for (Vertex v : abstractGraph.getVertices()) {
            if (v.getColor() == Color.red) {
                System.out.println("Reachable vertex: " + v.getIndex());
                baseVertecies.add(v);
                reachedVertecies.add(v.getName());
            }
        }

        for(Vertex bv : baseVertecies){
            reachEach(bv);
        }

        if(abstractGraph.getVertexCount() == reachedVertecies.size())
            return true;
        else
            return false;
    }

    void reachEach(Vertex vertex){
        for (AbstractEdge e : vertex.getEdgeList()){
            Vertex reachedVertex = e.getW();
            if (!reachedVertecies.contains(reachedVertex.getName())) {
                reachedVertecies.add(reachedVertex.getName());
                reachEach(reachedVertex);
            }
        }
    }
}
