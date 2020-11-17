package algoritmi20;

import java.util.Scanner;

public class Messages {
    public static void main (String [] args){
        Scanner s = new Scanner(System.in);
        SLL<Message> list = new SLL<>();
        int n = s.nextInt();
        for (int i = 0; i < n; i++){
            Message b = new Message();
            b.name = s.next();
            b.email = s.next();
            b.text = s.nextLine();
            list.insertLast(b);
        }

        SLLNode<Message> node = list.getFirst();
        SLLNode<Message> node2 = list.getFirst();

        while (node != null){
            node2 = node.succ;
            while (node2 != null){
                if (node.element.email.equals(node2.element.email)){
                    list.insertAfter(node2.element, node);
                    list.delete(node2);
                    list.delete(node);
                    node = node.succ;
                }
                node2 = node2.succ;
            }
            node = node.succ;
        }

        SLLNode<Message> start = list.getFirst();
        node = start.succ;

        while (true) {
            while (node != null){
                if (node.element.email.compareTo(start.element.email) < 0){
                    list.insertAfter(start.element, node);
                    list.insertAfter(node.element, start);
                    list.delete(node);
                    list.delete(start);
                    start = start.succ;
                    node = node.succ.succ;
                } else {
                    node = node.succ;
                }
            }
            if (start == null){
                break;
            }

            start = start.succ;
            node = start;
        }

        node = list.getFirst();
        while (node != null){
            if (node.element.name.equals("SND")){
                System.out.print("[" + node.element.email + "] : " + node.element.text + "\n");
            } else if (node.element.name.equals("RCV")){
                System.out.print("[" + node.element.email + "] > " + node.element.text + "\n");
            }
            node = node.succ;
        }
    }
}

class Message {
    public String name;
    public String email;
    public String text;

    public Message(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Message() {}
}
