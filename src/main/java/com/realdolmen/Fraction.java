package com.realdolmen;

public class Fraction {
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
    }

    protected String simplify() {
        int gmnschappelijk = Utilities.greatestCommonFactor(teller, noemer);
        return (teller / gmnschappelijk) + "/" + (noemer / gmnschappelijk);

    }

    public String toString() {
        return teller + "/" + noemer;
    }


    public double asDouble() {
        return (((double) this.teller) / this.noemer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else {
            return false;
        }
    }
}
