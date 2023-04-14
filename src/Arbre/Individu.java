package Arbre;

import Description.Date;

import java.util.HashMap;

import java.util.Map;

import Description.Date;

public class Individu {
    String nom;
    Date naissance, mort;
    int pere, mere, cadet, faine ;

    public Individu(String nom,int pere, int mere, Date naissance, Date mort){
        this.nom=nom;
        this.pere=pere;
        this.mere=mere;
        this.naissance=naissance;
        this.mort=mort;
        this.cadet=0;
        this.faine=0;

    }

////////////////////Gestion faine et cadet/////////////////


    public Date getMort() {
        return this.mort;
    }

    public Date getNaissance() {
        return this.naissance;
    }

    public int getMere() {
        if (this.mere==-1){
            return -1;
        }
        return this.mere;
    }

    public int getPere() {
        if (this.pere==-1){
            return -1;
        }
        return this.pere;
    }

    public String getNom() {
        return this.nom;
    }

    public int getCadet() {
        return this.cadet;
    }

    public int getFaine() {
        return this.faine;
    }

    ///////////////////////////

    public void setFaine(int faine) {
        this.faine = faine;
    }

    public void setCadet(int cadet) {
        this.cadet = cadet;
    }

    /////////////////////TEST///////////////////////////////
}
