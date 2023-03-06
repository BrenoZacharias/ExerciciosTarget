import model.FaturamentoDiario;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        JSONArray jsonArray;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON

        ArrayList<FaturamentoDiario> faturamentoMensal = new ArrayList<FaturamentoDiario>();

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonArray = (JSONArray) parser.parse(new FileReader(
                    "C:\\Users\\T-GAMER\\Desktop\\PROJETOS\\JAVA\\ExsVagaTarget\\Ex3\\src\\dados.json"));


            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                FaturamentoDiario faturamentoDiario = new FaturamentoDiario();
                faturamentoDiario.setDia((Long)jsonObject.get("dia"));
                faturamentoDiario.setValor((double)jsonObject.get("valor"));
                faturamentoMensal.add(faturamentoDiario);

            }

        }
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("O menor valor de faturamento ocorrido em um dia do mês: " +
                faturamentoMensal.stream().min(Comparator.comparingDouble(FaturamentoDiario::getValor)).get().getValor());

        System.out.println("O maior valor de faturamento ocorrido em um dia do mês: " +
                faturamentoMensal.stream().max(Comparator.comparingDouble(FaturamentoDiario::getValor)).get().getValor());

        double totalMensal = faturamentoMensal.stream().filter(e -> e.getValor() != 0).mapToDouble(value -> value.getValor()).sum();

        double qtdDiasComFaturamento = faturamentoMensal.stream().filter(e -> e.getValor() != 0).count();

        double mediaMensal = totalMensal / qtdDiasComFaturamento;

        System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal: " +
                faturamentoMensal.stream().filter(e -> e.getValor() > mediaMensal).count());

    }
}
