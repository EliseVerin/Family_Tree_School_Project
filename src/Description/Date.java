package Description;

public class Date {
    short jour, mois, annee;

    public Date(int jour, int mois, int annee){
        this.jour= (short) jour;
        this.mois= (short) mois;
        this.annee= (short) annee;
    }

    public Date(){
        this.jour=0;
        this.mois=0;
        this.annee=0;
    }

    public int compDate(Date naissance, Date mort){
        if (mort.annee ==0){
            return 2022-naissance.annee;
        }
        else {
            return mort.annee- naissance.annee;
        }
        //TODO probleme je l'ai pris comme un comparateur de date qui donne l'age de l'individu alors qu'il faut dire qui est le plus jeune
    }

    public boolean compDate_good(Date naissance_id1, Date naissance_id2) {
        //retourne un true si le premier est plus jeune
        if (naissance_id1.annee > naissance_id2.annee){
            return true;
        }
        else {
            return false;
        }
    }






////////////////////////////Get and set////////////////////////////
    public String getDate() {
        return "jours "+jour +" mois "+mois+" années "+annee;
    }
}

