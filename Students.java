// ТРЕТ ТЕРМИН (Прв колоквиум): Дадена е листа на студенти со индекс, име и поени. Да се најде студентот со најмалку поени и да се избрише. 
// Да се испечатат имињата на останатите студенти (се печатат само индексите).
// Example input:                   Example output:
// 3                                189652
// Joe 189652 100                   169753
// Nat 169753 50
// Steve 257653 40

package algoritmi20;
import java.util.Scanner;

class SLLNode1 {
    String index;
    String name;
    int points;
    SLLNode1 succ;

    public SLLNode1(String index, String name, int points, SLLNode1 succ) {
        this.index = index;
        this.name = name;
        this.points = points;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return name;
    }
}

class SLL1 {
    SLLNode1 first;

    public SLL1() {
        this.first = null;
    }

    public void insertFirst(String index, String name, int points) {
        SLLNode1 ins = new SLLNode1(index, name, points, first);
        first = ins;
    }

    public void insertLast(String index, String name, int points) {
        if (first != null) {
            SLLNode1 tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode1 ins = new SLLNode1(index, name, points, null);
            tmp.succ = ins;
        } else {
            insertFirst(index, name, points);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode1 tmp = first;
            ret.append(tmp).append("\n");
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret.append(tmp).append("\n");
            }
        } else
            ret = new StringBuilder("NO ELEMENTS");
        return ret.toString();
    }
}

public class Students2 {

    public static void removeStudent(SLL1 students) {
        //todo: implement function
        SLLNode1 minIme= students.first;
        SLLNode1 node= students.first;
        int min=students.first.points;
        while (node!= null){
            if (node.points<min){
                min=node.points;
                minIme=node;

            }
            node=node.succ;
        }
        node= students.first;
        if (minIme==node)
        {
            students.first=node.succ;

        }
        while (node!=null){
            if (node.succ==minIme){
                node.succ=minIme.succ;
            }
            node=node.succ;
        }

    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        SLL1 students =  new SLL1();

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            students.insertLast(parts[0], parts[1], Integer.parseInt(parts[2]));
        }

        removeStudent(students);
        System.out.println(students.toString());
    }
}
