public class Produkt {
    private double preis;
    
    public Produkt(double preis) {
        setPreis(preis);
    }
    
    public Produkt() {
        
    }
    
    public void setPreis(double preis) { 
        if (preis <= this.preis) { 
            throw new IllegalArgumentException("Nur Erhöhungen erlaubt!"); 
        }
        this.preis= preis; 
    }
    
    public double getPreis() { 
        return preis; 
    }
}