/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciabanco;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author alanabarbosa
 */
public class Banco {
    private Usuario usuario;
    private ContaBancaria conta;
    
    public Banco() {
        conta = new ContaBancaria();
    }
    
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
       do {
            System.out.println("\n--- Gerenciamento Bancário ---");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Realizar Depósito");
            System.out.println("4. Realizar Saque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarSaque();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while(opcao != 5);

        scanner.close();        
    }
    
    private void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        usuario = new Usuario(nome, sobrenome, cpf);
        System.out.println("Usuário cadastrado: " + usuario.toString());
    }
    
    private void consultarSaldo() {
        System.out.println("Saldo atual: R$" + conta.consultarSaldo());
    }
    
    private void realizarDeposito() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); 
        System.out.print("Valor do depósito: R$");
        double valor = scanner.nextDouble();
        conta.depositar(valor);
    }


    private void realizarSaque() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Valor do saque: R$");
        double valor = scanner.nextDouble();
        conta.sacar(valor);
    }    
}
