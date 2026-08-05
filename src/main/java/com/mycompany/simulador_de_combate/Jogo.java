package com.mycompany.simulador_de_combate;

import java.util.Random;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Personagem cacador = new Personagem("Caçador", 100, 25, 0.15);

        int sorteio = random.nextInt(6) + 1; 
        Monstro inimigo = null;

        switch (sorteio) {
            case 1:
                inimigo = new Dragao("Rathalos", 150, 25, "ROARRRR!!!", 10);
                break;
            case 2:
                inimigo = new Vampiro("Conde Drácula", 90, 20, "Mwahaha... sinta a sede de sangue!");
                break;
            case 3:
                inimigo = new Goblin("Goblin Ladrão", 60, 12, "Hehehe! Passa a poção!");
                break;
            case 4:
                inimigo = new Zumbi("Zumbi Putrefato", 80, 14, "Braaiinnss...");
                break;
            case 5:
                inimigo = new Bruxa("Bruxa dos Pântanos", 70, 15, "Hahaha! Sinta a minha maldição!");
                break;
            case 6:
                inimigo = new Esqueleto("Esqueleto Guerreiro", 75, 16, "Clack clack clack!");
                break;
            default:
                inimigo = new Goblin("Goblin Ladrão", 60, 12, "Hehehe! Passa a poção!");
                break;
        }

        System.out.println("=== INÍCIO DA CAÇADA ===");
        System.out.println("🌿 Você estava explorando o mapa...");
        System.out.println("⚠️ Um " + inimigo.getNome() + " selvagem apareceu!\n");

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
            System.out.println("🏆 Vitória!! O " + inimigo.getNome() + " foi derrotado!");
        } else {
            System.out.println("☠️ Você desmaiou. Missão fracassada...");
        }

        scanner.close();
    }
}
