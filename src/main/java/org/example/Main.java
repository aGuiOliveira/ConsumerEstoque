package org.example;

import org.example.service.EstoqueServiceClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstoqueServiceClient client = new EstoqueServiceClient();

        while (true) {
            System.out.println("\n=== MENU ESTOQUE ===");
            System.out.println("1 - Listar Produtos");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            try {
                switch (opcao) {
                    case 1:
                        System.out.println("Produtos:\n" + client.listarProdutos());
                        break;
                    case 2:
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço do produto: ");
                        String preco = scanner.nextLine();
                        preco = preco.replace(",",".");
                        float precoFloat = Float.parseFloat(preco);
                        System.out.println(client.adicionarProduto(nome, precoFloat));
                        break;
                    case 3:
                        System.out.print("ID do produto: ");
                        int id = scanner.nextInt();
                        System.out.println(client.removerProduto(id));
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro ao consumir serviço SOAP: " + e.getMessage());
            }
        }
    }
}
