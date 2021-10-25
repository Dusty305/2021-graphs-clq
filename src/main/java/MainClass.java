import com.mathsystem.graphapi.AbstractGraph;
import com.mathsystem.graphapi.GraphFactory;

import java.io.File;

public class MainClass {
    public static void main(String[] args) {
        BaseGraph graphSquare = new BaseGraph();

        AbstractGraph abstractGraph = GraphFactory.loadDirectedGraphFromFile(
                new File("C://Users//user//Downloads", "graph (2).txt"));
        System.out.println(graphSquare.execute(abstractGraph));
    }
}
