package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class examJune {
    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        String vtor = stdin.readLine();
        String [] niza = vtor.split(" ");
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < niza.length; i++){
            Integer broj = Integer.parseInt(niza[i]);
            list.insertLast(broj);
        }

        DLLNode<Integer> node1 = list.getFirst();
        DLLNode<Integer> node2 = list.getLast();
        int bigger = 0;
        int sum = 0;

        for (int i = 0; i < list.length(); i++){
            if (node1.element > node2.element){
                bigger = node1.element;
            } else {
                bigger = node2.element;
            }

            if ((node1.succ == node2) || (node2.pred == node1)) {
                sum = node1.element + node2.element;
                list.insertBefore(sum, node1);
                list.delete(node1);
                list.insertBefore(bigger, node2);
                break;
            }

            if (node1 == node2){
                break;
            }

            sum = node1.element + node2.element;
            list.insertAfter(sum, node1);
            list.delete(node1);
            node1 = node1.succ;
            list.insertAfter(bigger, node1);

            node1 = node1.succ.succ;
            node2 = node2.pred;
        }
        System.out.println(list);
    }
}