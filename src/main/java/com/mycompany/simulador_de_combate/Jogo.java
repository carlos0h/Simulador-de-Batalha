package com.mycompany.simulador_de_combate;

import java.util.Scanner;


public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Personagem cacador = new Personagem("Caçador", 100, 25);
        Monstro rathalos = new Monstro("Rathalos", 150, 30, "ROARRRR!!!");
        
        System.out.println("=== INICIO DA CAÇADA ===");
        System.out.println("Um " + rathalos.getNome() + "selvagem apareceu!\n");
        
        while(cacador.isVivo() && rathalos.isVivo()){
            
            System.out.println("--- Status ---");
            System.out.println(cacador.getNome() + "| HP: " + cacador.getVida());
            System.out.println(rathalos.getNome() + "| HP " + rathalos.getVida());
            System.out.println("--------------");

            System.out.println("--- Ações ---");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.println("Sua escolha: ");
            
            int escolha = scanner.nextInt();
            System.out.println();
            
            switch(escolha){
                case 1: 
                    cacador.atacar(rathalos);
                break;
                
                case 2:
                    System.out.println(cacador.getNome() + "tentou fugir, mas o monstro bloqueou o caminho!");
                break;
                default:
                    System.out.println("Ação Invalida! Você hesitou e perdeu o turno");
            }
            
            if(rathalos.isVivo()){
                System.out.println("\nTurno do Inimigo!");
                rathalos.atacar(cacador);
            }
            System.out.println("==============================================");
        }
        if(cacador.isVivo()){
            System.out.println("Vitóra!! O" + rathalos.getNome() + "foi derrotado!");
        }else{
            System.out.println("Você desmaiou. Missão fracassada");
        }
        scanner.close();
        
    }
}
