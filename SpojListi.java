package av2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpojListi {
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
        Integer last = null;

        while (node1 != null && node2 != null){
            if (node1.element < node2.element){
                if (last != node1.element){
                    result.insertLast(node1.element);
                    last = node1.element;
                }
                node1 = node1.succ;
            } else if (node1.element > node2.element){
                if (last != node2.element){
                    result.insertLast(node2.element);
                    last = node2.element;
                }
                node2 = node2.succ;
            } else {
                if (last != node2.element){
                    result.insertLast(node2.element);
                    last = node2.element;
                }
                node1 = node1.succ;
                node2 = node2.succ;
            }
        }

        while (node1 != null){
            if (last != node1.element){
                result.insertLast(node1.element);
                last = node1.element;
            }
            node1 = node1.succ;
        }

        while (node2 != null){
            if (last != node2.element){
                result.insertLast(node2.element);
                last = node2.element;
            }
            node2 = node2.succ;
        }

        SLLNode<Integer> node = result.getFirst();
        while (node != null){
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }
}
