package hu.petrik.bejegyzesprojekt;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bejegyzes {

    private String szerzo;

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok =0;
        this.letrejott= LocalDateTime.now();
        this.szerkesztve= LocalDateTime.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void like()
    {
        this.likeok++;
    }
    @Override
    public String toString(){
        if(this.szerkesztve == this.letrejott)
        {
            return String.format("%s - %d -s%\n" + "Szerkesztve:\n" + "%s", this.szerzo, this.likeok, this.letrejott, this.tartalom);

        }
else {
    return String.format("%s - %d -s%\n" + "Szerkesztve: %s\n" + "%s", this.szerzo, this.likeok, this.letrejott, this.szerkesztve, this.tartalom);

        }
    }

}
