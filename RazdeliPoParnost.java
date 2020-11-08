package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class razdeliPoParnost {
    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        s = stdin.readLine();
        String [] niza = s.split(" ");
        DLL<Integer> list = new DLL<Integer>();
        DLL<Integer> list1 = new DLL<Integer>();
        DLL<Integer> list2 = new DLL<Integer>();
        for (int i = 0; i < N; i++){
            list.insertLast(Integer.parseInt(niza[i]));
        }

        DLLNode<Integer> node = list.getFirst();
        while (node != null){
            if (node.element % 2 == 0){
                list1.insertLast(node.element);
            } else {
                list2.insertLast(node.element);
            }
            node = node.succ;
        }

        if (list1.getFirst() != null && list2.getFirst() != null){
            node = list2.getFirst();
            while (node != null){
                System.out.print(node.element);
                node = node.succ;
                if (node != null) System.out.print(" ");
            }
            node = list1.getFirst();
            System.out.println();
            while (node != null){
                System.out.print(node.element);
                node = node.succ;
                if (node != null) System.out.print(" ");
            }
        } else {
           if (list2.getFirst() != null){
               System.out.println(list2.toString());
           }
           if (list1.getFirst() != null){
               System.out.println(list2.toString());
           }
        }
    }
}
