package algoritmi20;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}



class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                while(curr.succ != null) {
                    curr = curr.succ;
                }
                MapEntry<K, E> tmp = new MapEntry<K, E>(key, val);
                SLLNode<MapEntry<K, E>> tmp2 = new SLLNode<MapEntry<K, E>>(tmp, null);
                curr.succ = tmp2;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}

class LekApteka {
    String ime;
    String namena;
    Integer cena;

    public LekApteka(String ime, String namena, Integer cena) {
        this.ime = ime;
        this.namena = namena;
        this.cena = cena;
    }

    public String getIme() {
        return ime;
    }

    public String getNamena() {
        return namena;
    }

    public Integer getCena() {
        return cena;
    }
}

public class Farmacija {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int broj = Integer.parseInt(bf.readLine());

        CBHT<String, LekApteka> b = new CBHT<String, LekApteka>(broj);

        for (int i = 0; i < broj; i++) {
            String s = bf.readLine();
            String [] niza = s.split(" ");
            LekApteka l = new LekApteka(niza[0], niza[1], Integer.parseInt(niza[2]));
            b.insert(niza[1], l);

        }

        while (true) {
            String namena = bf.readLine();

            SLLNode<MapEntry<String, LekApteka>> lek = b.search(namena);
            if (lek == null) {
                System.out.print("Nema lek za baranata namena vo magacin");
                return;
            }

            LekApteka tmp = lek.element.value;
            Integer minCena = lek.element.value.getCena();
            while (lek.succ != null) {
                if (lek.element.value.getCena() < minCena) {
                    tmp = lek.element.value;
                    minCena = lek.element.value.getCena();
                }
                lek = lek.succ;
            }
            System.out.print(tmp.getIme());
        }

    }

}



