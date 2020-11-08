package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


public class DLLKompanija {
    public static void main (String [] args) throws IOException {
        DLL<Vraboten> list = new DLL<Vraboten>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n; i++){
            list.insertLast(new Vraboten(Integer.parseInt(stdin.readLine()), Integer.parseInt(stdin.readLine())));
        }
        Integer sallary = Integer.parseInt(stdin.readLine());
        DLLNode<Vraboten> node = list.getFirst();
        while (node != null){
            if (node.element.getPlata() < sallary){
                DLLNode<Vraboten> node2 = node;
                list.delete(node2);
            }
            node = node.succ;
        }

        for (int j = 0; j < list.length(); j++){
            DLLNode<Vraboten> currentNode = list.getFirst();
            Vraboten auxNode;
            for (int i = 0; i < list.length() - 1; i++){
                if (currentNode.element.getID() < currentNode.succ.element.getID()){
                    auxNode = currentNode.element;
                    currentNode.element = currentNode.succ.element;
                    currentNode.succ.element = auxNode;
                }
                currentNode = currentNode.succ;
            }
        }

        node = list.getFirst();
        if (node == null){
            System.out.println("nema");
        }

        while (node != null){
            System.out.println(node.element.getID() + " " + node.element.getPlata());
            node = node.succ;
        }
    }
}
