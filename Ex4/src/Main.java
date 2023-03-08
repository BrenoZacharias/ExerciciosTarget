import model.FaturaEstado;
import model.FaturaGeral;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <FaturaEstado> faturaEstados = new ArrayList<FaturaEstado>();
        faturaEstados.add(new FaturaEstado("SP", 67836.43));
        faturaEstados.add(new FaturaEstado("RJ", 36678.66));
        faturaEstados.add(new FaturaEstado("MG", 29229.88));
        faturaEstados.add(new FaturaEstado("ES", 27165.48));
        faturaEstados.add(new FaturaEstado("Outros", 19849.53));

        FaturaGeral faturaGeral = new FaturaGeral(faturaEstados);
        faturaGeral.informarPercentual();

    }
}
