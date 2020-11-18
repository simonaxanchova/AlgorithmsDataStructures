package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vojska {
    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String numSoldier = stdin.readLine();
        Integer N = Integer.parseInt(numSoldier);
        String elements = stdin.readLine();
        String [] niza = elements.split(" ");
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < niza.length; i++) {
            list.insertLast(Integer.parseInt(niza[i]));
        }

        numSoldier = stdin.readLine();
        String [] intervals = numSoldier.split(" ");
        int a = Integer.parseInt(intervals[0]);
        int b = Integer.parseInt(intervals[1]);

        numSoldier = stdin.readLine();
        intervals = numSoldier.split(" ");
        int c = Integer.parseInt(intervals[0]);
        int d = Integer.parseInt(intervals[1]);

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