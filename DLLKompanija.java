public class DLLKompanija {
    public static void main (String [] args) throws IOException {
        DLL<Vraboten> list = new DLL<Vraboten>();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(stdin.readLine());
        for (int i = 0; i < n; i++){
            list.insertLast(new Vraboten(Integer.parseInt(stdin.readLine()), Integer.parseInt(stdin.readLine())));
        }
        Integer sallary = Integer.parseInt(stdin.readLine());
        DLLNode<Vraboten> node = list.getFirst();
        while (node != null){
            if (node.element.getPlata() < sallary){
                DLLNode<Vraboten> node2 = node;
                list.delete(node2);
            }
            node = node.succ;
        }

        int i = 0;
        for (int j = 0; j < list.length(); j++){
            DLLNode<Vraboten> currentNode = list.getFirst();
            Vraboten auxNode;
            for (i = 0; i < list.length(); i++){
                if (currentNode.element.getID() < currentNode.succ.element.getID()){
                    auxNode = currentNode.element;
                    currentNode.element = currentNode.succ.element;
                    currentNode.succ.element = auxNode;
                }
                currentNode = currentNode.succ;
            }
        }

        node = list.getFirst();
        if (node != null){
            System.out.println("nema");
        }
        while (node != null){
            System.out.println(node.element.getID() + " " + node.element.getPlata());
            node = node.succ;
        }
    }
}
