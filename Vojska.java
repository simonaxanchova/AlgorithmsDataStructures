package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vojska {
    public static void main (String [] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        String s = reader.readLine();
        String [] razdeli = s.split(" ");
        DLL<Integer> list = new DLL<Integer>();
        for(int i = 0; i < razdeli.length; i++) {
            list.insertLast(Integer.parseInt(razdeli[i]));
        }
        
        s = reader.readLine();
        String[] intervali = s.split(" ");
        int a = Integer.parseInt(intervali[0]);
        int b = Integer.parseInt(intervali[1]);
        
        s = reader.readLine();
        intervali = s.split(" ");
        int c = Integer.parseInt(intervali[0]);
        int d = Integer.parseInt(intervali[1]);
        
        DLL<Integer> predPrv = new DLL<Integer>();
        DLL<Integer> prv = new DLL<Integer>();
        DLL<Integer> izmegju = new DLL<Integer>();
        DLL<Integer> vtor = new DLL<Integer>();
        DLL<Integer> posleVtor = new DLL<Integer>();

        DLLNode<Integer> node = list.getFirst();

        while (node.element != a) {
            predPrv.insertLast(node.element);
            node = node.succ;
        }

        while (node.element != b) {
            prv.insertLast(node.element);
            node = node.succ;
        }
        prv.insertLast(node.element);
        node = node.succ;

        while (node.element != c) {
            izmegju.insertLast(node.element);
            node = node.succ;
        }

        while (node.element != d) {
            vtor.insertLast(node.element);
            node = node.succ;
        }
        vtor.insertLast(node.element);
        node = node.succ;

        while (node != null) {
            posleVtor.insertLast(node.element);
            node = node.succ;
        }


        //////////////////////

        list.deleteList();

        node = predPrv.getFirst();
        while (node != null) {
            list.insertLast(node.element);
            node = node.succ;
        }

        node = vtor.getFirst();
        while (node != null) {
            list.insertLast(node.element);
            node = node.succ;
        }

        node = izmegju.getFirst();
        while (node != null) {
            list.insertLast(node.element);
            node = node.succ;
        }

        node = prv.getFirst();
        while (node != null) {
            list.insertLast(node.element);
            node = node.succ;
        }

        node = posleVtor.getFirst();
        while (node != null) {
            list.insertLast(node.element);
            node = node.succ;
        }
        System.out.println(list.toString());
    }
}
