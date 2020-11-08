package algoritmi20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Array<E> {
    private E niza[];
    private int n;


    public Array(int n) {
        niza = (E[]) new Object[n];
        this.n=n;
    }

    public void set(int position, E ob)
    {
        for(int i=0;i<n;i++)
        {
            if(position>=0&&position<n)
            {
                niza[position] = ob;
            }
        }
    }

    public E get(int position)
    {
        if(position>=0 && position<n)
            return niza[position];
        else
            System.out.println("Nevalidna pozicija");
        return null;
    }

    public int find(E ob)
    {
        for(int i=0;i<n;i++)
        {
            if(niza[i].equals(ob)==true)
            {
                return i;
            }
        }
        return -1;
    }

    public int getLength()
    {
        return n;
    }


    public static int brojDoProsek(Array<Integer> niza){
        int suma = 0;
        int prosek = 0;

        for (int i = 0; i < niza.getLength(); i++){
            suma = suma + niza.get(i);
        }
        prosek = suma / niza.getLength();

        int min = Math.abs(niza.get(0) - prosek);
        int index = 0;

        for (int i = 0; i < niza.getLength(); i++){
            if (Math.abs(niza.get(i) - prosek ) < min){
                min = Math.abs(niza.get(i) - prosek);
                index = i;
            }
            if (Math.abs(niza.get(i) - prosek ) == min){
                if (niza.get(i) < niza.get(index)){
                    min = Math.abs(niza.get(i) - prosek);
                    index = i;
                }
            }
        }

        if (min == 0) return prosek;
        else
            return niza.get(index);
    }

    public static void main (String [] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        Array<Integer> niza = new Array<Integer>(N);
        for (int i = 0; i < N; i++){
            s = stdin.readLine();
            niza.set(i, Integer.parseInt(s));
        }

        System.out.println(brojDoProsek(niza));
    }

}
