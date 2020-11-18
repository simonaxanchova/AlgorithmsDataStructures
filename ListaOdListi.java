package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ListaOdListi {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long proizvod = 1;
        DLLNode<DLL<Integer>> outsideNode = list.getFirst();
        while (outsideNode != null) {
            DLLNode<Integer> insideNode = outsideNode.element.getFirst();
            Integer sum = 0;
            while (insideNode != null) {
                sum += insideNode.element;
                insideNode = insideNode.succ;
            }
            proizvod *= sum;
            outsideNode = outsideNode.succ;
        }
        return proizvod;
    }


    public static void main (String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++){
            DLL<Integer> temp = new DLL<Integer>();
            for (int j = 0; j < m; j++){
                temp.insertLast(in.nextInt());
            }
            list.insertLast(temp);
        }
        System.out.println(findMagicNumber(list));
    }
}