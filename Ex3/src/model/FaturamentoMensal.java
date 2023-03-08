package model;

import java.util.ArrayList;
import java.util.Comparator;

public class FaturamentoMensal {
    ArrayList<FaturamentoDiario> faturamentosDiario = new ArrayList<FaturamentoDiario>();

    public FaturamentoMensal(ArrayList<FaturamentoDiario> faturamentosDiario) {
        this.faturamentosDiario = faturamentosDiario;
    }

    public void printaInformações(){
        System.out.println("O menor valor de faturamento ocorrido em um dia do mês: " + retornaMenorValorFaturamentoEmUmDia());
        System.out.println("O maior valor de faturamento ocorrido em um dia do mês: " + retornaMaiorValorFaturamentoEmUmDia());
        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " +
                retornaQtdDiasQFaturamentoFoiMaiorQMediaMensal());
    }

    private double retornaMenorValorFaturamentoEmUmDia(){
        return faturamentosDiario.stream().min(Comparator.comparingDouble(FaturamentoDiario::getValor)).get().getValor();
    }

    private double retornaMaiorValorFaturamentoEmUmDia(){
        return faturamentosDiario.stream().max(Comparator.comparingDouble(FaturamentoDiario::getValor)).get().getValor();
    }

    private double retornaMediaMensal(){
        return retornaTotalMensal() / retornaQtdDiasComFaturamento();
    }

    private double retornaTotalMensal() {
        return faturamentosDiario.stream().filter(e -> e.getValor() != 0).mapToDouble(value -> value.getValor()).sum();
    }

    private long retornaQtdDiasComFaturamento() {
        return  faturamentosDiario.stream().filter(e -> e.getValor() != 0).count();
    }

    private long retornaQtdDiasQFaturamentoFoiMaiorQMediaMensal(){
        return faturamentosDiario.stream().filter(e -> e.getValor() > retornaMediaMensal()).count();
    }

}
