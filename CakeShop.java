// Во еднострана поврзана листа се чуваат податоци за торти (име и цена). Треба да се отстранат сите торти од листата што имаат поголема цена од просечната цена.
// Не смее да се користи дополнителна листа.


import java.util.Scanner;

class SLLNode {
    String name;
    int price;
    SLLNode succ;

    public SLLNode(String name, int price, SLLNode succ) {
        this.name = name;
        this.price = price;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(String name, int price) {
        SLLNode ins = new SLLNode(name, price, first);
        first = ins;
    }

    public void insertLast(String name, int price) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(name, price, null);
            tmp.succ = ins;
        } else {
            insertFirst(name, price);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}
public class CakeShop {

    public static void removeCakes(SLL cakes) {
        //todo: implement method
        SLLNode dvizi = cakes.first;
        SLLNode prv = cakes.first;
        SLLNode pom = cakes.first;
        int sum = 0;
        float avg = 0;
        int c=0;
        boolean flag = true;

        while(dvizi!=null){
            sum+=dvizi.price;
            c++;
            dvizi=dvizi.succ;
        }
        avg = (float)sum/c;

        dvizi = cakes.first;

        while(dvizi!=null){
            if (dvizi.price<=avg && flag){
                prv=dvizi;
                pom=dvizi;
                flag =false;
            } else if (dvizi.price<=avg){
                pom.succ=dvizi;
                pom = dvizi;
            } //else if (dvizi.price==avg){
            //pom.succ=dvizi;
            // pom = dvizi;
            //}
            if(dvizi.succ==null){
                pom.succ=null;
            }

            dvizi=dvizi.succ;
        }
        cakes.first = prv;


    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL cakes =  new SLL();

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            cakes.insertLast(parts[0], Integer.parseInt(parts[1]));
        }

        removeCakes(cakes);
        System.out.println(cakes.toString());
    }
}
