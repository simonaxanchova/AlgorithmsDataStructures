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

        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        int bigger = 0;
        int zbir = 0;

        for (int i = 0; i < list.length(); i++){
            if (first.element > last.element){
                bigger = first.element;
            } else {
                bigger = last.element;
            }

            if ((first.succ == last) || (last.pred == first)){ //parna lista
                zbir = first.element + last.element;
                list.insertBefore(zbir, first);
                list.delete(first);
                list.insertBefore(bigger, last);
                break;
            }

            if (first == last){
                break;
            }

            zbir = first.element + last.element;
            list.insertAfter(zbir, first);
            list.delete(first);
            first = first.succ;
            list.insertAfter(bigger, first);

            first = first.succ.succ;
            last = last.pred;
        }
        System.out.println(list);
    }
}
