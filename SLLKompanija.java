package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

class Vraboten {
    private int ID;
    private int plata;

    public Vraboten(int ID, int plata) {
        this.ID = ID;
        this.plata = plata;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }
}

public class SLLKompanija {
    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        SLL<Vraboten> list = new SLL<Vraboten>();
        for (int i = 0; i < n; i++) {
            list.insertLast(new Vraboten(Integer.parseInt(stdin.readLine()), Integer.parseInt(stdin.readLine())));
        }

        Integer sallary = Integer.parseInt(stdin.readLine());
        SLLNode<Vraboten> node = list.getFirst();
        while (node != null) {
            if (node.element.getPlata() < sallary) {
                SLLNode<Vraboten> tmp = node;
                list.delete(tmp);
            }
            node = node.succ;
        }

        for (int i = 0; i < list.length(); i++) {
            SLLNode<Vraboten> currentNode = list.getFirst();
            Vraboten auxNode;
            for (int j = 0; j < list.length() - 1; j++) {
                if (currentNode.element.getID() < currentNode.succ.element.getID()) {
                    auxNode = currentNode.element;
                    currentNode.element = currentNode.succ.element;
                    currentNode.succ.element = auxNode;
                }
                currentNode = currentNode.succ;
            }
        }

        node = list.getFirst();
        if (node == null) {
            System.out.println("nema");
        }

        while (node != null) {
            System.out.println(node.element.getID() + " " + node.element.getPlata());
            node = node.succ;
        }
    }
}
