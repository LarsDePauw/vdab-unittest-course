package com.realdolmen;

import javax.xml.parsers.FactoryConfigurationError;
import java.util.Objects;

public class Fraction{
    private int teller;
    private int noemer;

    public int getTeller() {
        return teller;
    }

    public int getNoemer() {
        return noemer;
    }

    public Fraction(int teller, int noemer) {
            this.teller = teller;
            this.noemer = noemer;
        if (this.teller == 0) {
            throw new ArithmeticException("Teller mag niet nul zijn of het resultaat is oneindig.");
        }
        if (this.noemer == 0) {
            throw new ArithmeticException("Noemer mag niet nul zijn. Dit is onmogelijk onnozelaar.");
        }
        this.simplify();
    }

    protected void simplify() {
        int gmnschappelijk = Utilities.greatestCommonFactor(teller, noemer);
        this.noemer=this.noemer/gmnschappelijk;
        this.teller=this.teller/gmnschappelijk;

    }

    public String toString() {
        return teller + "/" + noemer;
    }


    public double asDouble() {
        return (((double) this.teller) / this.noemer);
    }

    @Override
    public boolean equals(Object o) {
        Fraction that = (Fraction)o;
        return this.noemer == that.noemer && this.teller == that.teller;
    }

    public Fraction reciprocal(){
        return new Fraction(this.getNoemer(), this.getTeller());
    }

    public Fraction multiply(Fraction that){
        return new Fraction((this.teller * that.teller), (this.noemer * that.noemer));
    }

    public Fraction add(Fraction that){
     return new Fraction((this.teller*that.noemer+that.teller*this.noemer),(this.noemer*that.noemer));
    }
}
