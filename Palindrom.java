package algoritmi20;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Palin {
    public static int isItPalindrome(DLL<Integer> list){
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        for (int i = 0; i < list.length() / 2; i++){
            if (first.element != last.element){
                return -1;
            }
            first = first.succ;
            last = last.pred;
        }
        return 1;
    }

    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        Integer N = Integer.parseInt(s);
        String vtor = stdin.readLine();
        String [] niza = vtor.split(" ");
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < niza.length; i++){
            Integer broj = Integer.parseInt(niza[i]);
            list.insertLast(broj);
        }
        System.out.println(isItPalindrome(list));
    }
}


