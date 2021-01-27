package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Students2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer size = Integer.parseInt(br.readLine());

        String line;
        SLL<String> list = new SLL<>();

        for (int i = 0; i < size; i ++) {
            line = br.readLine();
            list.insertLast(line);
        }

        SLLNode<String> node = list.getFirst();
        SLLNode<String> minNode = list.getFirst();
        int minPoeni = 10000000;
        while (node != null) {
            if (Integer.parseInt(node.element.split(" ")[2]) <= minPoeni) {
                minPoeni = Integer.parseInt(node.element.split(" ")[2]);
                minNode = node;
            }
            node = node.succ;
        }
        node = list.getFirst();
        while (node != null) {
            if (node.equals(minNode)) {
                list.delete(node);
            }
            node = node.succ;
        }

        System.out.println(list.toString());
    }
}
