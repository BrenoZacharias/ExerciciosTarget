package model;

import java.util.ArrayList;
import java.util.List;

public class FaturaGeral {

    ArrayList<FaturaEstado> faturaEstados;

    public FaturaGeral(ArrayList<FaturaEstado> faturaEstados) {
        this.faturaEstados = faturaEstados;
    }

    public void popularLista(List<FaturaEstado> faturaEstados){
        this.faturaEstados.addAll(faturaEstados);
    }

    private double retornaTotal() {
        return faturaEstados.stream().mapToDouble(value -> value.getValor()).sum();
    }

    private double retornaPercentual(double valorFaturaMensal){
        return (valorFaturaMensal * 100) / retornaTotal();
    }

    public void informarPercentual () {
        faturaEstados.stream().forEach(faturaEstado -> System.out.printf("%s Percentual: %5.2f\n",
                faturaEstado.getSigla(), retornaPercentual(faturaEstado.getValor())));
    }
}
