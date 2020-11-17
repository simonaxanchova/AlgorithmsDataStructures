package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParoviBroevi {
    public  static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < N; i++){
            list.insertLast(Integer.parseInt(stdin.readLine()));
        }

        SLLNode<Integer> node = list.getFirst();

        while (node != null){
            if (node.element % 2 == 0){
                SLLNode<Integer> node2 = node.succ;
                Integer suma = 0;
                while (node2 != null){
                    if (node2.element % 2 == 0){
                        suma = node.element + node2.element;
                        SLLNode<Integer> node1 = node;
                        list.insertAfter(suma, node);
                        node = node.succ;
                        list.delete(node2);
                        list.delete(node1);
                        break;
                    }
                    node2 = node2.succ;
                }
                node = node.succ;
                continue;
            }

            if (node.element % 2 == 1){
                SLLNode<Integer> node2 = node.succ;
                Integer razlika = 0;
                while (node2 != null){
                    if (node2.element % 2 == 1){
                        razlika = node.element - node2.element;
                        SLLNode<Integer> node1 = node;
                        list.insertAfter(razlika, node);
                        node = node.succ;
                        list.delete(node2);
                        list.delete(node1);
                        break;
                    }
                    node2 = node2.succ;
                }
                node = node.succ;
            }
        }

        SLLNode<Integer> tmp = list.getFirst();
        while (tmp != null){
            System.out.print(tmp.element + " ");
            tmp = tmp.succ;
        }
    }
}