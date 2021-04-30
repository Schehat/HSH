import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class X implements Serializable { 
    private int x1; 
    public X(int x) { x1= x; }
    public String toString() {
        return "hier " + x1;
    }
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream("x.dat"));
        out.writeObject(new X(1)); 
        out.writeObject(new X(2));
        out.close();
        
        ObjectInputStream in= new ObjectInputStream(new FileInputStream("x.dat"));
        @SuppressWarnings("unchecked")
        // Ist keine Liste was in.readObject ausgibt
        ArrayList<X> list= (ArrayList<X>)in.readObject();
        in.close();
    }
}

