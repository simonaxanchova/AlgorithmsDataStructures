package algoritmi20;
// 5
// 1 2 3 4 5
// 4
// 5 6 9 7


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpojNaizmenicno {
    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String prv = stdin.readLine();
        Integer N = Integer.parseInt(prv);
        String vtor = stdin.readLine();
        String [] niza = vtor.split(" ");
        SLL<Integer> list1 = new SLL<Integer>();
        for (int i = 0; i < niza.length; i++){
            Integer broj = Integer.parseInt(niza[i]);
            list1.insertLast(broj);
        }

        prv = stdin.readLine();
        N = Integer.parseInt(prv);
        vtor = stdin.readLine();
        niza = vtor.split(" ");
        SLL<Integer> list2 = new SLL<Integer>();
        for (int i = 0; i < niza.length; i++){
            Integer broj = Integer.parseInt(niza[i]);
            list2.insertLast(broj);
        }

        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();
        SLL<Integer> result = new SLL<Integer>();

        while (node1 != null && node2 != null){
            result.insertLast(node1.element);
            if (node1.succ != null){
                result.insertLast(node1.succ.element);
                node1 = node1.succ.succ;
            } else {
                node1 = node1.succ;
            }
            result.insertLast(node2.element);
            if (node2.succ != null){
                result.insertLast(node2.succ.element);
                node2 = node2.succ.succ;
            } else {
                node2 = node2.succ;
            }
        }

        if (node1 != null){
            while (node1 != null){
                result.insertLast(node1.element);
                node1 = node1.succ;
            }
        }

        if (node2 != null){
            while (node2 != null){
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        SLLNode<Integer> node = result.getFirst();
        while (node != null){
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }
}
