package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Rechtschreibtrainer implements Serializable {

    private int richtig;
    private int insgesamt;
    private Wortpaar wortpaar;

    private ArrayList<Wortpaar> wortpaare;

    public Rechtschreibtrainer() {

    }

    public void waehleWortpaar(int index) {
        this.wortpaar = wortpaare.get(index);
    }

    public void waehleRandomWortpaar() {
        waehleWortpaar((int) Math.random() * this.wortpaare.size());
    }

    public int getRichtig() {
        return richtig;
    }

    public int getInsgesamt() {
        return insgesamt;
    }

    public void setRichtig(int richtig) {
        if(richtig < 0) {
            throw new IllegalArgumentException("richtig negative");
        }
        this.richtig = richtig;
    }

    public void setInsgesamt(int insgesamt) {
        if(insgesamt < 0) {
            throw new IllegalArgumentException("insgesamt negative");
        }
        this.insgesamt = insgesamt;
    }

    public void addWortpaar(Wortpaar wortpaar) {
        this.wortpaare.add(wortpaar);
    }

    public String getBildURL() {
        return this.wortpaar.getUrl();
    }
}
