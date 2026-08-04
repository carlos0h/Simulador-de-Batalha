package com.mycompany.simulador_de_combate;

import java.util.Scanner;
import java.util.Random;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        Personagem cacador = new Personagem("Caçador", 100, 25, 0.15);
        
        int sorteio = random.nextInt(3) + 1;
        Monstro inimigo = null;
        
        switch (sorteio){
            case 1:
                inimigo = new Dragao("Rathalos ", 150, 25, " ROARRR!!! ", 10);
            break;
            
            case 2:
                inimigo = new Vampiro("Conde Dracula ", 90, 20, "Muahaha... sinto a sede de sangue!");
            break;
            
            case 3:
                inimigo = new Goblin("Goblin selvagem ", 80, 15, "Hehehe, me passe suas poções!");
                break;
        }
        
    System.out.println("=== INÍCIO DA CAÇADA ===");
    System.out.println(" Você estava explorando o mapa...");
    System.out.println(" O " + inimigo.getNome() + " apareceu!\n");

        
        while (cacador.isVivo() && inimigo.isVivo()) {

            System.out.println("--- Status ---");
            System.out.println(cacador.getNome() + " | HP: " + cacador.getVida() + " | Poções: " + cacador.getQuantPocoes());
            System.out.println(inimigo.getNome() + " | HP: " + inimigo.getVida());
            System.out.println("--------------");

            System.out.println("--- Ações ---");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.println("3 - Usar poção de cura");
            System.out.print("Sua escolha: ");

            int escolha = scanner.nextInt();
            System.out.println();

            switch (escolha) {
                case 1:
                    cacador.atacar(inimigo);
                    break;

                case 2:
                    System.out.println(cacador.getNome() + " tentou fugir, mas " + inimigo.getNome() + " bloqueou o caminho!");
                    break;

                case 3:
                    cacador.usarPot();
                    break;

                default:
                    System.out.println("Ação Inválida! Você hesitou e perdeu o turno.");
            }

         
            if (inimigo.isVivo()) {
                System.out.println("\n--- Turno do Inimigo ---");
                inimigo.atacar(cacador);
            }
            System.out.println("==============================================\n");
        }

     
        if (cacador.isVivo()) {
            System.out.println("Vitória!! O " + inimigo.getNome() + " foi derrotado!");
        } else {
            System.out.println("Você desmaiou. Missão fracassada...");
        }

        scanner.close();
    }
}