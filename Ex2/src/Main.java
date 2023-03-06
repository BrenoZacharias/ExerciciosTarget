import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n1 = 0, n2 = 1, nInformado;
        nInformado = 34;
        ArrayList<Integer> seqFibonacci = new ArrayList<Integer>();
        while (n1 < nInformado) {
            seqFibonacci.add(n1);
            seqFibonacci.add(n2);
            n1 = n1 + n2;
            n2 = n2 + n1;
        }
        if(seqFibonacci.contains(nInformado)){
            System.out.println("Pertence a sequência");
        } else {
            System.out.println("Não pertence a sequência");
        }
    }
}
