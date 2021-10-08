package sample.sample;



public class Main {


    public static void main(String[] args) {

        sample.sample.Graph<String> c3;

        c3 = new sample.sample.Graph<String>(3);
        c3.addArc(0,1,"");
        c3.addArc(1,2,"");
        c3.addArc(2,3,"");

        ParcourProfondeurIteree pi= new ParcourProfondeurIteree(3);

        System.out.print(pi.TriTs(c3));

    }