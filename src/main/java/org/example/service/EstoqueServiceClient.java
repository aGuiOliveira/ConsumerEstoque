package org.example.service;
import org.example.util.SoapClient;

import java.util.List;

public class EstoqueServiceClient {

    public String listarProdutos() throws Exception {
        String request =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                        "xmlns:ser=\"http://service.example.org/\">" +
                        "<soapenv:Header/><soapenv:Body><ser:listarProdutos/></soapenv:Body></soapenv:Envelope>";

        return SoapClient.callSoapService(request);
    }

    public String adicionarProduto(String nome, float preco) throws Exception {
        String request =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                        "xmlns:ser=\"http://service.example.org/\">" +
                        "<soapenv:Header/><soapenv:Body><ser:adicionarProduto>" +
                        "<nome>" + nome + "</nome><preco>" + preco + "</preco>" +
                        "</ser:adicionarProduto></soapenv:Body></soapenv:Envelope>";

        return SoapClient.callSoapService(request);
    }

    public String removerProduto(int id) throws Exception {
        String request =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                        "xmlns:ser=\"http://service.example.org/\">" +
                        "<soapenv:Header/><soapenv:Body><ser:removerProduto>" +
                        "<id>" + id + "</id>" +
                        "</ser:removerProduto></soapenv:Body></soapenv:Envelope>";

        return SoapClient.callSoapService(request);
    }
}
