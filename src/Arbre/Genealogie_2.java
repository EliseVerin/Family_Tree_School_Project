package Arbre;

import java.util.ArrayList;

import Description.Date;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Genealogie_2 {
    HashMap <Integer, Individu> map;
    Integer id_cur;

    public Genealogie_2() {
        this.id_cur = 1;
        map = new HashMap<>();

    }

    public int adj(String nom, int pere, int mere, Date naissance, Date mort) {
        if (verification_nom(nom)==false){
            System.out.println("le nom n'est pas valide");
        }
        else {
            Individu nw_id = new Individu(nom, pere, mere, naissance, mort);

            map.put(id_cur, nw_id);
            if (nw_id.getPere() != -1 && nw_id.getMere() != -1) {
                //on a les deux parents
                MAJ_faine_cadet(nw_id, id_cur, pere, mere);
            }
            if (nw_id.getPere() != -1 && nw_id.getMere() == -1) {
                // on a seulement le pere
                MAJ_faine_cadet_pere(nw_id, id_cur, pere);
            }
            if (nw_id.getPere() == -1 && nw_id.getMere() != -1) {
                //on a seulement la mere
                MAJ_faine_cadet_mere(nw_id, id_cur, mere);
            }

        }
        return id_cur++;

    }

    public void MAJ_faine_cadet(Individu nw_id, int id_cur, int pere, int mere){
        if (map.get(pere).getFaine() == 0 && map.get(mere).getFaine() == 0){
            //cas pas d'enfant encore enregistré

            map.get(pere).setFaine(id_cur);
            map.get(mere).setFaine(id_cur);

        }
        else {
            //les parents ont des enfants
            int faine_parent = map.get(pere).getFaine();
            if (nw_id.naissance.compDate(nw_id.getNaissance(),nw_id.getMort()) > map.get(faine_parent).naissance.compDate(map.get(faine_parent).getNaissance(),map.get(faine_parent).getMort())){
                //nw id est plus grand que l'autre enfant
                map.get(pere).setFaine(id_cur);
                map.get(mere).setFaine(id_cur);

            }
            else {
                //si nw id est plus jeune on regarde si l'ancien faine a un cadet
                if (map.get(faine_parent).cadet == 0) {
                    // faine_parent n'a pas de cadet
                    map.get(faine_parent).setCadet(id_cur);

                }
                else {
                    // faine_parent a un cadet
                    int cadet = map.get(faine_parent).getCadet();
                    if (map.get(cadet).naissance.compDate(map.get(cadet).naissance, map.get(cadet).getMort()) > nw_id.naissance.compDate(nw_id.getNaissance(), nw_id.getMort())) {
                        //on regarde juste si le cadet est plus vieux que le nw individu
                        map.get(cadet).setCadet(id_cur);
                    }
                }


            }
        }
    }

    public void MAJ_faine_cadet_pere(Individu nw_id, int id_cur, int pere){

        if (map.get(pere).getFaine()==0){
            //cas pas d'enfant
            map.get(pere).setFaine(id_cur);

        }
        else{
            //les parents ont des enfants
            int faine_parent = map.get(pere).getFaine();
            if (nw_id.naissance.compDate(nw_id.getNaissance(),nw_id.getMort()) > map.get(faine_parent).naissance.compDate(map.get(faine_parent).getNaissance(),map.get(faine_parent).getMort())){
                //nw id est plus grand que l'autre
                map.get(pere).setFaine(id_cur);

            }
            else {
                //on regarde si l'ancien faine a un cadet
                if (map.get(faine_parent).cadet == 0) {
                    // faine_parent n'a pas de cadet
                    map.get(faine_parent).setCadet(id_cur);
                }
                else {
                    // faine_parent a un cadet
                    int cadet = map.get(faine_parent).getCadet();
                    if (map.get(cadet).naissance.compDate(map.get(cadet).naissance, map.get(cadet).getMort()) > nw_id.naissance.compDate(nw_id.getNaissance(), nw_id.getMort())) {
                        //on regarde juste si le cadet est plus vieux que le nw individu
                        map.get(cadet).setCadet(id_cur);
                    }
                }


            }
        }
    }

    public void MAJ_faine_cadet_mere(Individu nw_id, int id_cur, int mere){

        if (map.get(mere).getFaine()==0){
            //cas pas d'enfant
            map.get(mere).setFaine(id_cur);

        }
        else{
            //les parents ont des enfants
            int faine_parent = map.get(mere).getFaine();
            if (nw_id.naissance.compDate(nw_id.getNaissance(),nw_id.getMort()) > map.get(faine_parent).naissance.compDate(map.get(faine_parent).getNaissance(),map.get(faine_parent).getMort())){
                //nw id est plus grand que l'autre
                map.get(mere).setFaine(id_cur);

            }
            else {
                //on regarde si l'ancien faine a un cadet
                if (map.get(faine_parent).cadet == 0) {
                    // faine_parent n'a pas de cadet
                    map.get(faine_parent).setCadet(id_cur);
                }
                else {
                    // faine_parent a un cadet
                    int cadet = map.get(faine_parent).getCadet();
                    if (map.get(cadet).naissance.compDate(map.get(cadet).naissance, map.get(cadet).getMort()) > nw_id.naissance.compDate(nw_id.getNaissance(), nw_id.getMort())) {
                        //on regarde juste si le cadet est plus vieux que le nw individu
                        map.get(cadet).setCadet(id_cur);
                    }
                }


            }
        }
    }

    public boolean verification_nom(String nom){

        if (nom == ""){
            return false;
        }
        return true;
    }


    ////Exercice 2/////


    public boolean freres_soeurs(int x, int y){
        // x et y se sont les id_cur
        //D'abord trouvé l'id relié à l'identifiant

        ///Puis regarde si ils ont les mêmes parents

        if (map.get(x).getPere() == -1 &&
                map.get(y).getPere() == -1 &&
                map.get(x).getMere()== -1 &&
                map.get(y).getMere() == -1){
            return false;
        }


        else if (map.get(x).getPere() == map.get(y).getPere() &&
                 map.get(x).getMere() == map.get(y).getMere()){
            return true;
        }

        else {
            return false;
        }
    }
//TODO Faire une recurcive sur le freres_soeurs

    public boolean cousins(int x, int y){

        //peut faire une recurcive maybe
        int pere_id_1=map.get(x).getPere();
        int mere_id_1=map.get(x).getMere();
        int pere_id_2=map.get(y).getPere();
        int mere_id_2=map.get(y).getMere();

        if (pere_id_1==-1 || mere_id_1 ==-1 || pere_id_2==-1||mere_id_2==-1){
            return false;
        }

        int gpP_id_1=map.get(pere_id_1).getPere();//l
        int gmP_id_1=map.get(pere_id_1).getMere();//l

        int gpM_id_1=map.get(mere_id_1).getPere();//mm
        int gmM_id_1=map.get(mere_id_1).getMere();//mm

        int gpP_id_2=map.get(pere_id_2).getPere();//l
        int gmP_id_2=map.get(pere_id_2).getMere();//l

        int gpM_id_2=map.get(mere_id_2).getPere();//mm
        int gmM_id_2=map.get(mere_id_2).getMere();//mm

        ArrayList<Integer> grand_parents = new ArrayList<Integer>();
        grand_parents.add(gpP_id_1);
        grand_parents.add(gmP_id_1);
        grand_parents.add(gpM_id_1);
        grand_parents.add(gmM_id_1);
        grand_parents.add(gpP_id_2);
        grand_parents.add(gmP_id_2);
        grand_parents.add(gpM_id_2);
        grand_parents.add(gmM_id_2);


        ArrayList<Integer>grand_parents_sous_liste_1=new ArrayList<>(grand_parents.subList(0,4));
        ArrayList<Integer>grand_parents_sous_liste_2=new ArrayList<>(grand_parents.subList(4,8));

        int compteur1 = 0;
        for (int i=0; i<=1; i++) {
            int compteur2 = 0;
            for (int a=0; a<=1; a++) {
                int total_1 = grand_parents_sous_liste_1.get(compteur1) + grand_parents_sous_liste_1.get(compteur1 + 1);
                int total_2 = grand_parents_sous_liste_2.get(compteur2) + grand_parents_sous_liste_2.get(compteur2 + 1);
                if (total_1 == total_2 && freres_soeurs(x, y) == false && total_1 != -2 && total_1!=-1) {
                    return true;
                } else {
                    compteur2 = compteur2 + 2;
                }
            }
            compteur1=compteur1+2;
        }

        return false;

    }

    public void affiche_oncles(int x){
        int pere=map.get(x).getPere();
        int mere=map.get(x).getMere();
        System.out.println("les oncles tantes du coté du pere sont : ");

        if (pere == -1){
            System.out.println("Pas de père connu donc pas d'oncle ou de tante paternelle");
        }
        else {
            afficher_freres_soeurs(pere);
        }

        if (mere == -1){
            System.out.println("Pas de mère connu donc pas d'oncle ou de tante maternelle");
        }
        else {
            System.out.println("\nles oncles et tantes du coté de la mère sont : ");
            afficher_freres_soeurs(mere);
        }
    }

    public void afficher_freres_soeurs(int x){
        for (int i=1; i<= map.size();i++){
            if (freres_soeurs(x,i) == true && x !=i){
                System.out.println(map.get(i).getNom());
            }

        }

    }

    public void affiche_enfants(int x){
        boolean sans_enfant = true;
        for (int i=1; i<= map.size();i++) {
            if (map.get(i).getPere() == x || map.get(i).getMere() == x){
                System.out.println(map.get(x).getNom()+" est parent de "+map.get(i).getNom());
                sans_enfant = false;
            }
        }

        if (sans_enfant==true){
            System.out.println("N'a pas d'enfants");
        }

    }

    public void affiche_cousins(int x) {
        for (int i = 1; i <= map.size(); i++) {
            if (cousins(x, i) == true) {
                System.out.println(map.get(x).getNom() + " a comme cousin ou cousine " + map.get(i).getNom());
            }
        }
    }

    public boolean ancetre(int x, int y) {

        // ici on cherche juste à trouver si deux personnes sont de la même lignée
        int ancetre__ = 0;
        int jeune = 0;
        boolean test =false;
        ArrayList <Integer> noeud = new ArrayList<>();

        //Il faut vérifier qu'entre chaque boucle récessive on garde ancetre_explored
        //regarder et definir qui est le plus jeune ça permet de prendre une direction
        if (map.get(x).naissance.compDate_good(map.get(x).getNaissance(), map.get(y).getNaissance()) == true){
            ancetre__ = y;
            jeune = x;
        } else {
            ancetre__ = x;
            jeune = y;

        }

        while (test == false &&
                noeud.isEmpty()==false ||
                map.get(jeune).getPere() != -1 && map.get(jeune).getMere() != -1 ||
                map.get(jeune).getPere() == -1 && map.get(jeune).getMere() != -1 ||
                map.get(jeune).getPere() != -1 && map.get(jeune).getMere() == -1) {
            //tant que on a pas trouvé les parents que on a un truc dans le noeud
            //la porte de sortie c'est quand on obtient le true
            if (map.get(jeune).getPere() == ancetre__ || map.get(jeune).getMere() == ancetre__){
                //Ici on valide si on l'ancetre commun dans l'un des parents du jeune
                test= true;
                return test;
            }

            else if(map.get(jeune).getPere() != -1 && map.get(jeune).getMere() != -1 &&
                    test ==false) {
                //cas ou on monte de 1 parent lors d'un noeud
                noeud.add(map.get(jeune).getMere());
                //sauvegarde la mere
                jeune=map.get(jeune).getPere();

            }

            else if (map.get(jeune).getPere() == -1 && map.get(jeune).getMere() == -1 ||
                    map.get(jeune).getPere() == -1 && map.get(jeune).getMere() != -1 ||
                    map.get(jeune).getPere() != -1 && map.get(jeune).getMere() == -1 ||
                    noeud.isEmpty() == false &&
                            test == false){
                //cas ou on a pas de parents mais un noeud

                int last_noeud = noeud.get(noeud.size()-1);

                noeud.remove(noeud.get(noeud.size()-1));

                jeune = last_noeud;

                //il faut repartir du noeud pour remonter en utilisant le dernier ajouter

            }

            else if (map.get(jeune).getPere() == -1 && map.get(jeune).getMere() == -1 &&
                    noeud.isEmpty() == true &&
                    test == false) {

                //cas ou on a pas de parents ni de noeud porte de sortie

                return test;
            }

        }

        return test;

    }

    public int plus_ancien(int x){
        int int_ancien=0;

        for (int i=1; i <= getMap().size(); i++){
            if (i==x){
                continue;
            }
            if (ancetre(x, i) ==true){
                if (int_ancien==0){
                    int_ancien=i;
                }
                else if (map.get(i).naissance.compDate_good(map.get(i).getNaissance(), map.get(int_ancien).getNaissance()) == false) {
                    int_ancien=i;
                }
            }
        }
        if (map.get(int_ancien).naissance.compDate_good(map.get(int_ancien).getNaissance(), map.get(x).getNaissance()) == true){
            return x;
        }
        return int_ancien;

        //TODO marche tres bien mais pourquoi le 1 ne marche pas?
    }

    public void affiche_parente(int x) {
        ArrayList<Integer> a_tester=new ArrayList<>();
        a_tester.add(x);
        show_parents_generation(a_tester,0);
    }

    public void affiche_descendance (int x) {
        ArrayList<Integer> a_tester=new ArrayList<>();
        a_tester.add(x);
        show_enfants_generation(a_tester,0);

    }

    public void show_parents_generation (ArrayList <Integer> a_tester, int generation){
        ArrayList <Integer> next_gen_a_tester = new ArrayList<>();
        for (int i=0; i< a_tester.size();i++){
            if (map.get(a_tester.get(i)).getPere() !=-1){
                next_gen_a_tester.add(map.get(a_tester.get(i)).getPere());
            }
            if (map.get(a_tester.get(i)).getMere() !=-1){
                next_gen_a_tester.add(map.get(a_tester.get(i)).getMere());
            }
        }
        if (generation<0) {
            System.out.println(generation + ":");
            for (int i = 0; i < a_tester.size(); i++) {
                System.out.println(map.get(a_tester.get(i)).getNom());
                afficher_freres_soeurs(a_tester.get(i));
            }
            System.out.println("\n");
        }
        if (next_gen_a_tester.size()>0) {
            show_parents_generation(next_gen_a_tester, generation-1);
        }
        //TODO ici on a eu un probleme de décallage car onafficher la next gen au lieu de la generation courante
    }

    public void show_enfants_generation (ArrayList <Integer> a_tester, int generation){
        ArrayList <Integer> next_gen_a_tester = new ArrayList<>();
        for (int i=0; i< a_tester.size();i++){
            for (int j=1; j <= map.size();j++) {
                if (map.get(j).getPere() == a_tester.get(i) || map.get(j).getMere() == a_tester.get(i)){
                    next_gen_a_tester.add(j);
                }

            }
        }
        if (generation<0) {
            System.out.println(generation + ":");
            for (int i = 0; i < a_tester.size(); i++) {
                System.out.println(map.get(a_tester.get(i)).getNom());
            }
            System.out.println("\n");
        }
        if (next_gen_a_tester.size()>0) {
            show_enfants_generation(next_gen_a_tester, generation-1);
        }
    }



    //////////////////////Get and Set//////////////////////

    public Map<Integer, Individu> getMap() {
        return map;
    }

    public Individu get(int x){
        if (map.containsKey(x)){
            return map.get(x);
        }
        else {
            return null;
        }
    }

}
//TODO resoudre le probleme avec le +1 et -1 sur les parents