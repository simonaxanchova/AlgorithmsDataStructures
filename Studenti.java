// ТРЕТ ТЕРМИН (Прв колоквиум): Дадена е листа на студенти со индекс, име и поени. Да се најде студентот со најмалку поени и да се избрише. 
// Да се испечатат имињата на останатите студенти. 

import java.util.Scanner;

class SLLNode {
    String index;
    String name;
    int points;
    SLLNode succ;

    public SLLNode(String index, String name, int points, SLLNode succ) {
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

class SLL {
    SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void insertFirst(String index, String name, int points) {
        SLLNode ins = new SLLNode(index, name, points, first);
        first = ins;
    }

    public void insertLast(String index, String name, int points) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(index, name, points, null);
            tmp.succ = ins;
        } else {
            insertFirst(index, name, points);
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        if (first != null) {
            SLLNode tmp = first;
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

public class Students {

    public static void removeStudent(SLL students) {
        //todo: implement function
        SLLNode minIme= students.first;
        SLLNode node= students.first;
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
        SLL students =  new SLL();

        for(int i=0; i<n; i++){
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            students.insertLast(parts[0], parts[1], Integer.parseInt(parts[2]));
        }

        removeStudent(students);
        System.out.println(students.toString());
    }
}
