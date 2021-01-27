// ЧЕТВРТ ТЕРМИН: Дадени се две листи. Потребно е да се нанижи втората листа на крајот на првата, и на крај се додава уште еден јазол кој ја содржи сумата од сите јазли во листата.

public static void main(String [] args) {

		Scanner input = new Scanner(System.in);
		//citanje na broj na elementi
		int m = input.nextInt();
		int n = input.nextInt();
		int suma = 0;

		DLL<Integer> lista1 = new DLL<Integer>();
		DLL<Integer> lista2 = new DLL<Integer>();

		//citaj listi, edna po edna
		for (int i = 0; i < m; i++) {
			int el = input.nextInt();
			lista1.insertLast(el);
		}

		for (int i = 0; i < n; i++) {
			int el = input.nextInt();
			lista2.insertLast(el);
		}

		DLLNode<Integer> current = lista1.getFirst();
		DLLNode<Integer> current2 = lista2.getFirst();


		//vasiot kod tuka..
		while(current2 != null) {
			lista1.insertLast(current2.element);
			current2 = current2.succ;
		}
		
		while(current != null) {
			suma += current.element;
			current = current.succ;
		}
		lista1.insertLast(suma);
 
	

		//pecatenje
		System.out.println(lista1.toString());
		System.out.println(lista1.toStringR());
	}
