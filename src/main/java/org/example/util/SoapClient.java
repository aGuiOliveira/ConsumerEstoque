package org.example.util;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class SoapClient {
    private static final String SERVICE_URL = "http://localhost:8080/estoque";

    public static String callSoapService(String soapRequest) throws Exception {
        URL url = new URL(SERVICE_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            os.write(soapRequest.getBytes());
        }

        Scanner scanner = new Scanner(connection.getInputStream());
        StringBuilder response = new StringBuilder();
        while (scanner.hasNext()) {
            response.append(scanner.nextLine());
        }
        scanner.close();

        return extractAllReturnContents(response.toString());
    }

    private static String extractAllReturnContents(String soapResponse) {
        // Verifica se existem tags <return>
        if (!soapResponse.contains("<return>")) {
            // Não há produtos, retorna a mensagem inteira
            return soapResponse;
        }

        StringBuilder resultado = new StringBuilder();
        Pattern pattern = Pattern.compile("<return>(.*?)</return>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(soapResponse);

        while (matcher.find()) {
            String bloco = matcher.group(1);

            String id = extractTagValue(bloco, "id");
            String nome = extractTagValue(bloco, "nome");
            String preco = extractTagValue(bloco, "preco");

            if(!nome.isEmpty() && !preco.isEmpty() && !id.isEmpty()) {
                resultado.append(nome)
                        .append(" - ID: ").append(id)
                        .append(" - Preço: ").append(preco)
                        .append("\n");
            } else {
                resultado.append(bloco).append("\n");
            }

        }

        return resultado.toString();
    }

    private static String extractTagValue(String xml, String tag) {
        Pattern p = Pattern.compile("<" + tag + ">(.*?)</" + tag + ">");
        Matcher m = p.matcher(xml);
        if (m.find()) {
            return m.group(1).trim();
        }
        return "";
    }

}
