import java.util.Comparator;

public abstract class AnteilAnlage implements Comparable<AnteilAnlage>, Comparator<AnteilAnlage> {
    private String isin;
    private double gesamtKosten;

    public AnteilAnlage(String isin) {
        this.isin= isin;
        gesamtKosten= 0.0;
    }

    @Override public int compareTo(AnteilAnlage other) {
        return this.getIsin().compareTo(other.getIsin());
    }
    
    Comparator<AnteilAnlage> cmp1= new Comparator<AnteilAnlage>() {
        @Override public int compare(AnteilAnlage a1, AnteilAnlage a2) {
        return a1.getIsin().compareTo(a2.getIsin());
        }
        };
    
    Comparator<AnteilAnlage> cmp2 = (a, b) -> a.getIsin().compareTo(b.getIsin());

    public void addiereKosten(double kosten) {
        gesamtKosten += kosten;
    }
    public String getIsin() {
        return isin;
    }
    public double getGesamtKosten() {
        return gesamtKosten;
    }
    public double getGewinn(double aktuellerKurs) {
        return getMarktwert(aktuellerKurs) - getGesamtKosten();
    }
    public abstract double getMarktwert(double aktuellerKurs);
}
