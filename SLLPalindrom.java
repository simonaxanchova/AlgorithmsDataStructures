package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SLLPalindrome {
    public static int isItPalindrome (SLL<Integer> list) {
        SLL<Integer> mirrorList =  new SLL<Integer>();
        SLLNode<Integer> node1 = list.getFirst();
        while (node1 != null) {
            mirrorList.insertLast(node1.element);
            node1 = node1.succ;
        }
        mirrorList.mirror();
        node1 = list.getFirst();
        SLLNode<Integer> node2 = mirrorList.getFirst();

        while (node1 != null && node2 != null) {
            if (!node1.element.equals(node2.element)) return -1;
            node1 = node1.succ;
            node2 = node2.succ;
        }
        return 1;
    }

    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String prv = stdin.readLine();
        Integer.parseInt(prv);
        String vtor = stdin.readLine();
        String [] niza = vtor.split(" ");
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < niza.length; i++) {
            Integer broj = Integer.parseInt(niza[i]);
            list.insertLast(broj);
        }
        System.out.println(isItPalindrome(list));
    }
}
