/**
 * Gruppe 03
 * @author Schehat
 * U20 Bruch 
 */
public class Bruch {
    public int zaehler, nenner, ggt;

    /**
     * constructor
     * @param zaehler
     * @param nenner
     */
    public Bruch (int zaehler, int nenner) {
        setZaehler(zaehler);
        setNenner(nenner);
        int zaehlerP = Math.abs(zaehler);
        int nennerP = Math.abs(nenner);
        if (zaehlerP > nennerP) {
            ggt = ggT(zaehlerP, nennerP);
        } else {
            ggt = ggT(nennerP, zaehlerP);        
        }
    }

    /**
     * check if 2 Bruch Objects are equal
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Bruch) {
            Bruch o = (Bruch) other;
            
            int oZaehlerP = Math.abs(o.zaehler);
            int oNennerP = Math.abs(o.nenner);
            int ggtO = 1;
            if (oZaehlerP > oNennerP) {
                ggtO = ggT(oZaehlerP, oNennerP);
            } else {
                ggtO = ggT(oNennerP, oZaehlerP);        
            }

            return this.hashCode() == o.hashCode(); 
        }
        return false;
    }

    /**
     * create own hashCode
     */
    @Override
    public int hashCode() {
        System.out.println(zaehler);
        if (zaehler < 0 && nenner > 0) {
            zaehler *= -1;
            nenner *= -1;
        }
        System.out.println(zaehler);
        return java.util.Objects.hash(zaehler / ggt, nenner / ggt);
    }

    /**
     * get Zähler
     * @return
     */
    public int getZaehler() {
        return zaehler;
    }
    
    /**
     * get Nenner
     * @return
     */
    public int getNenner() {
        return nenner;
    }

    /**
     * set Zähler
     * @param zaehler
     */
    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }

    /**
     * set Nenner
     * @param nenner
     */
    public void setNenner(int nenner) {
        if (nenner == 0) {
            throw new IllegalArgumentException("Nenner darf nicht 0 sein!");
        }
        this.nenner = nenner;
    }

    /**
     * 
     * @return zahl as double
     */
    public double zahl() {
        return (double)zaehler / nenner;
    }

    /**
     * calculate ggT with euklid algorithm
     * @param a
     * @param b
     * @return ggT
     */
    public int ggT (int a, int b) {
        int rest = 1;
        while (a % b != 0) {
            rest = a % b;
            b = a;
            a = rest;
        }
        return rest;
    }
}
