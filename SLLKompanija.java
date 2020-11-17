package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Vraboten {
    private int ID;
    private int plata;

    public Vraboten (int ID, int plata){
        this.ID = ID;
        this.plata = plata;
    }

    public int getID(){
        return ID;
    }

    public void setID(int iD){
        this.ID = ID;
    }

    public int getPlata(){
        return plata;
    }

    public void setPlata(int plata){
        this.plata = plata;
    }
}

public class SLLKompanija {
    public static void main (String [] args) throws IOException {
        SLL<Vraboten> list = new SLL<Vraboten>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n; i++){
            list.insertLast(new Vraboten(Integer.parseInt(stdin.readLine()), Integer.parseInt(stdin.readLine())));
        }

        Integer sallary = Integer.parseInt(stdin.readLine());
        SLLNode<Vraboten> tmp = list.getFirst();
        while (tmp != null){
            if (tmp.element.getPlata() < sallary){
                SLLNode<Vraboten> tmp2 = tmp;
                list.delete(tmp2);
            }
            tmp = tmp.succ;
        }

        int i = 0;
        for (int j = 0; j < list.length() - 1; j++){
            SLLNode<Vraboten> currentNode = list.getFirst();
            for (i = 0; i < list.length() - 1 - j; i++){
                if (currentNode.element.getID() < currentNode.succ.element.getID()){
                    list.insertAfter(currentNode.element, currentNode.succ);
                    SLLNode<Vraboten> tmp2 = currentNode;
                    currentNode = currentNode.succ;
                    list.delete(tmp2);
                }
                currentNode = currentNode.succ;
            }
        }

        tmp = list.getFirst();
        if (tmp == null){
            System.out.println("nema");
        }

        while (tmp != null){
            System.out.println(tmp.element.getID() + " " + tmp.element.getPlata());
            tmp = tmp.succ;
        }

    }
}