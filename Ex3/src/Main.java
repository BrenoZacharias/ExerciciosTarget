import model.FaturamentoDiario;
import model.FaturamentoMensal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JSONArray jsonArray;
        JSONParser parser = new JSONParser();

        ArrayList<FaturamentoDiario> faturamentosDiario = new ArrayList<FaturamentoDiario>();

        try {
            jsonArray = (JSONArray) parser.parse(new FileReader(
                    "C:\\Users\\T-GAMER\\Desktop\\PROJETOS\\JAVA\\ExsVagaTarget\\Ex3\\extra\\dados.json"));


            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                FaturamentoDiario faturamentoDiario = new FaturamentoDiario();
                faturamentoDiario.setDia((Long)jsonObject.get("dia"));
                faturamentoDiario.setValor((double)jsonObject.get("valor"));
                faturamentosDiario.add(faturamentoDiario);

            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FaturamentoMensal faturamentoMensal = new FaturamentoMensal(faturamentosDiario);
        faturamentoMensal.printaInformações();
    }
}
