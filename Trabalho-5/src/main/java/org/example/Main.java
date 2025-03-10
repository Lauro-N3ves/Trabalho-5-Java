package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            System.out.println("\nEscolha o tipo de notificação:");
            System.out.println("1 - Email");
            System.out.println("2 - SMS");
            System.out.println("3 - Push Notification");
            System.out.println("0 - Sair");
            System.out.print("Digite o número correspondente: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }

            String type = "";
            switch (choice) {
                case 1:
                    type = "email";
                    break;
                case 2:
                    type = "sms";
                    break;
                case 3:
                    type = "push";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.print("Digite a mensagem a ser enviada: ");
            String message = scanner.nextLine();

            Notification notification = NotificationFactory.createNotification(type);
            notification.send(message);
        }

        scanner.close();
    }
}
