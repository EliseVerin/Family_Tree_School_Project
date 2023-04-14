import Arbre.*;
import Description.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Main_test {

    public static void main(String[] args) {
        Genealogie_2 g = new Genealogie_2();
        int ia = g.adj("Arthur", -1, -1, new Date(9, 11, 1879), new Date(12, 11, 1934 ));
        int im = g.adj("Marcel", ia, -1, new Date(1, 7, 1928), new Date(21, 9, 2004 ));
        int ic = g.adj("Clothilde", -1, -1, new Date(30, 8, 1929), new Date(26, 4, 2005 ));
        int ije = g.adj("Jeanne", im, ic, new Date(13,4, 1948 ), new Date());
        int ihe = g.adj("Henri", -1,-1, new Date(2,8, 1947), new Date());
        int ial = g.adj("Aline", -1,-1, new Date(7,9, 1943 ), new Date());
        int ipi = g.adj("Pierre", -1,-1, new Date(26,6, 1941), new Date());
        int iju = g.adj("Julien", ipi, ial, new Date(13,8, 1965), new Date());
        int ialex = g.adj("Alex", ipi, ial, new Date(18,4, 1969), new Date());
        int iso = g.adj("Sophie", ihe, ije, new Date(9,11, 1972), new Date());
        int icl = g.adj("Clementine", ihe, ije, new Date(12,10, 1973), new Date());
        int ima = g.adj("Marion", ihe, ije, new Date(5,5, 1976), new Date());
        int ich = g.adj("Christian", -1, -1, new Date(13,2, 1971), new Date());
        int itho = g.adj("Thomas", ialex, iso, new Date(18,10, 2012), new Date());
        int icloe = g.adj("Cloe", ialex, iso, new Date(21,6, 2002), new Date());
        int ihu = g.adj("Hugo", ialex, iso, new Date(12,5, 2005), new Date());
        int isa = g.adj("Isabelle", ich, ima, new Date(28,4, 2003), new Date());

//        for (int i = 1; i <= 17; i++){
////            System.out.println("@ : " +g.getMap().get(i).getNom());
//            g.affiche_descendance(i);
//        }
    }
}