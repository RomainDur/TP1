import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Parser {

    public int NbrVar() {
        String Svar;
        int var = 0;
        try {
            // Lit le fichier d'entrée
            File file = new File("formula0.txt");
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            int i = 1;
            while ((line = br.readLine()) != null && i <= 2) {
                if (i == 2) {
                    Svar = line.substring(7, 8);
                    var = Integer.parseInt(Svar);
                }
                i++;
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return var;
    }

    public Graph<String> CreateImpGraph() {
        ArrayList<Integer> sommets = new ArrayList<Integer>();
        String Sx1;
        String Sx2;
        Graph<String> G = new Graph<String>(this.NbrVar());
        try {
            // Lit le fichier d'entrée
            File file = new File("formula0.txt");
            FileReader fr = new FileReader(file);

            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            int i = 1;
            while ((line = br.readLine()) != null) {
                if (i > 2) {
                    Sx1 = line.substring(1, 2);
                    if (Sx1.equals("-")) {
                        Sx1 = line.substring(1, 3);
                    }
                    float x1 = Float.parseFloat(Sx1);
                    Sx2 = line.substring(3, 4);
                    if (Sx2.equals("-")) {
                        Sx2 = line.substring(3, 5);
                    }
                    float x2 = Float.parseFloat(Sx2);
                    // ajouter les sommets a la liste
                    G.addArc(code.Transform(-x1, this.NbrVar()), code.Transform(x2, this.NbrVar()), "");
                    G.addArc(code.Transform(-x2, this.NbrVar()), code.Transform(x1, this.NbrVar()), "");
                }
                i++;
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    return G;
    }
}

