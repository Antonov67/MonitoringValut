package valuts;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main  {




    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.run();

    }

    //подключение к серверу для получения данных в виде строки
    static StringBuffer content;
    static HttpURLConnection connection;

    static String getStringFromServer(String urlAdress){
        BufferedReader reader;
        String line;
        content = new StringBuffer();
        //
        try {
            URL url = new URL(urlAdress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200){
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null){
                    content.append(line);
                }
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }


        return content.toString();
    }

    public static Data getUsd(){
        Gson gson = new Gson();
        String serverResponse;
        serverResponse = getStringFromServer("https://www.cbr-xml-daily.ru/daily_json.js");
        Valutes valutes = gson.fromJson(serverResponse, Valutes.class);
        double dinamikaUSD;
        dinamikaUSD = valutes.valute.usd.value - valutes.valute.usd.previous;
        Data data = new Data();
        data.dinamika = dinamikaUSD;
        if (dinamikaUSD > 0)
            data.dataString = "курс доллара " + valutes.valute.usd.value + " +" + String.format("%.2f", dinamikaUSD);
        else if (dinamikaUSD == 0)
            data.dataString =   "курс доллара " + valutes.valute.usd.value + " не изменился";
        else
           data.dataString =  "курс доллара " + valutes.valute.usd.value + " " + String.format("%.2f", dinamikaUSD);
        return data;
    }

    public static Data getEur(){
        Gson gson = new Gson();
        String serverResponse;
        serverResponse = getStringFromServer("https://www.cbr-xml-daily.ru/daily_json.js");
        Valutes valutes = gson.fromJson(serverResponse, Valutes.class);
        double dinamikaEUR;
        dinamikaEUR = valutes.valute.eur.value - valutes.valute.eur.previous;
        Data data = new Data();
        data.dinamika = dinamikaEUR;
        if (dinamikaEUR > 0) {
            data.dataString = "курс евро " + valutes.valute.eur.value + " +" + String.format("%.2f", dinamikaEUR);
        }
        else if (dinamikaEUR == 0) {
            data.dataString = "курс евро " + valutes.valute.eur.value + " не изменился";
        }
        else {
            data.dataString = "курс евро " + valutes.valute.eur.value + " " + String.format("%.2f", dinamikaEUR);
        }
        return data;
    }

}

