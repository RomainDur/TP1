package sample.sample;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<Label>   {

    public class Edge {
        public int source;
        public int destination;
        public Label label;

        public Edge(int from, int to, Label label) {
            this.source = from;
            this.destination = to;
            this.label = label;
        }
        public int getSource(){return source;};
        public int getDestination(){return destination;};
        public Label getLabel(){return label;};
    }

    private int cardinal;
    public ArrayList<LinkedList<Edge>> incidency;


    public Graph(int size) {
        super();
        cardinal = size;
        incidency = new ArrayList<LinkedList<Edge>>(size+1);
        for (int i = 0;i<cardinal;i++) {
            incidency.add(i, new LinkedList<Edge>());
        }
    }

    public int order() {
        return cardinal;
    }

    public void addArc(int source, int dest, Label label) {
        incidency.get(source).addLast(new Edge(source,dest,label));
    }

    public LinkedList<Edge> arcsortant(int sommets){
        LinkedList<Edge> arcsortants = new LinkedList<>();
        arcsortants=incidency.get(sommets);
        return arcsortants;
    }


    public Graph<String> Grev(Label label,Graph<String> G){
        for (int i=0; i<= G.incidency.size()-1; i++){
            for (int j=0; j<= G.incidency.get(i).size()-1; j++){
                int source = G.incidency.get(i).get(j).getSource();
                int destination = G.incidency.get(i).get(j).getDestination();
                Graph<String>.Edge E = new Graph<String>.Edge(destination,source,"");
                G.incidency.get(i).set(j,E);
            }
        }
        return G;
    }

    public String toString() {
        String result = new String("");
        result = result.concat("Nombre sommets : " + cardinal + "\n");
        result = result.concat("Sommets : \n");
        for (int i = 0; i<cardinal;i++) {
            result = result.concat(i + " ");
        }
        result = result.concat("\nArcs : \n");
        for (int i = 0; i<cardinal;i++) {
            for (Edge e : incidency.get(i)) {
                result = result.concat(e.source + " -> " + e.destination + ", étiquette : "
                        + e.label.toString() + "\n");
            }
        }
        return result;

    }

}

    
}
