import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Stack;

public class ParcourProfondeurIteree {

    ArrayList<Graph<String>.Edge> predecesseur = new ArrayList<>();
    ArrayList<Boolean> parcouru = new ArrayList<>();
    ArrayList<Integer> TriTS = new ArrayList<>();
    ArrayList<Integer> TriTS1 = new ArrayList<>();

    public void explore(Graph<String>.Edge arc, Graph<String> G) {

        int sommet = arc.getDestination();
        if (!parcouru.get(sommet)) {
            parcouru.set(sommet, true);
            predecesseur.set(sommet, arc);
            TriTS.add(sommet);
            ArrayList<Graph<String>.Edge> arcsortants = G.arcsortant(sommet);
            for (int i=0; i <= arcsortants.size() - 1; i++) {
                explore(arcsortants.get(i),G);
            }
        }
    }

    public ArrayList<Graph<String>.Edge> PPI(Graph<String> G) {

        int cardinal=G.order();
        for (int i=0; i <= cardinal-1; i++) {
             if (!parcouru.get(i)) {
                 parcouru.set(i, true);
                 predecesseur.set(i,null);
                 ArrayList<Graph<String>.Edge> arcsortants = G.arcsortant(i);
                 for (int j=0; j <= arcsortants.size() - 1; j++) {
                     explore(arcsortants.get(j),G);
                 }

            }
        }
        return predecesseur;

    }

    public ArrayList<Integer> TriTs (Graph<String> G){
        int cardinal=G.order();
        for (int i=0; i <= cardinal-1; i++) {
            if (!parcouru.get(i)) {
                parcouru.set(i, true);
                TriTS.add(i);
                ArrayList<Graph<String>.Edge> arcsortants = G.arcsortant(i);
                for (int j=0; j <= arcsortants.size() - 1; j++) {
                    explore(arcsortants.get(j),G);
                }

            }
        }
        for (int i=0; i<=TriTS.size()-1;i++){
            TriTS1.set(i,TriTS.get(TriTS.size()-1-i));
        }
        return TriTS1;
    }

    public ArrayList<Graph<String>.Edge> PPIOrdo(Graph<String> G, ArrayList<Integer> Tri){

        for (int i=0; i <= Tri.size()-1; i++) {
            int j= Tri.get(i);
            if (!parcouru.get(j)) {
                parcouru.set(j, true);
                predecesseur.set(j,null);
                ArrayList<Graph<String>.Edge> arcsortants = G.arcsortant(j);
                for (int k=0; k<= arcsortants.size() - 1; k++) {
                    explore(arcsortants.get(k),G);
                }

            }
        }
        return predecesseur;

    }
}

