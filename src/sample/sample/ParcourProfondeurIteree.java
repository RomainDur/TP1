package sample.sample;


import java.util.*;
import java.lang.*;
import java.util.Collections;
import java.util.*;
import java.lang.*;
import java.util.Collections;

public class ParcourProfondeurIteree {

    int taille;

    public ParcourProfondeurIteree (int cardinal){
        this.taille=cardinal;
    }

    ArrayList<sample.sample.Graph<String>.Edge> predecesseur = new ArrayList<>(taille+1);
    ArrayList<Boolean> parcouru = new ArrayList<>(taille+1);
    ArrayList<Integer> TS = new ArrayList<>(taille+1);
    ArrayList<Integer> TriTS = new ArrayList<>(taille+1);
    int ts =0;

    public void explore(sample.sample.Graph<String>.Edge arc, sample.sample.Graph<String> G) {

        int sommet = arc.getDestination();
        if (!parcouru.get(sommet)) {
            parcouru.set(sommet, true);
            predecesseur.set(sommet, arc);
            LinkedList<sample.sample.Graph<String>.Edge> arcsortants = G.arcsortant(sommet);
            for (int i=0; i <= arcsortants.size() - 1; i++) {
                explore(arcsortants.get(i),G);
                TS.add(i,ts++);
            }
        }
    }

    public ArrayList<sample.sample.Graph<String>.Edge> PPI(sample.sample.Graph<String> G) {

        for (int i=0; i <= taille+1; i++) {
            if (!parcouru.get(i)) {
                parcouru.set(i, true);
                predecesseur.set(i,null);
                LinkedList<sample.sample.Graph<String>.Edge> arcsortants = G.arcsortant(i);
                for (int j=0; j <= arcsortants.size() - 1; j++) {
                    explore(arcsortants.get(j),G);
                }

            }
        }
        return predecesseur;

    }

    public ArrayList<Integer> TriTs (sample.sample.Graph<String> G){
        for (int i=0; i <= taille-1; i++) {
            if (!parcouru.get(i)) {
                parcouru.set(i, true);
                LinkedList<sample.sample.Graph<String>.Edge> arcsortants = G.arcsortant(i);
                for (int j=0; j <= arcsortants.size() - 1; j++) {
                    explore(arcsortants.get(j),G);
                    TS.add(j,ts++);
                }
            }
        }
        System.out.println(TS);
        // while(TS.size()!=0){
        //   int max =Collections.max(TS);
        //    int i= TriTS.indexOf(max);
        //   TriTS.add(i);
        //   TS.remove(max);
        // }
        return TS;
    }

    public ArrayList<sample.sample.Graph<String>.Edge> PPIOrdo(sample.sample.Graph<String> G, ArrayList<Integer> Tri){

        for (int i=0; i <= Tri.size()-1; i++) {
            int j= Tri.get(i);
            if (!parcouru.get(j)) {
                parcouru.set(j, true);
                predecesseur.set(j,null);
                LinkedList<sample.sample.Graph<String>.Edge> arcsortants = G.arcsortant(j);
                for (int k=0; k<= arcsortants.size() - 1; k++) {
                    explore(arcsortants.get(k),G);
                }

            }
        }
        return predecesseur;

    }

}

