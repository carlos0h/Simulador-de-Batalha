package com.mycompany.simulador_de_combate;

import java.util.Random;

public class Goblin extends Monstro {
    private double chanceRoubo;

    public Goblin(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
        this.chanceRoubo = 0.40; // 40% de chance de roubar poção
    }

    @Override
    public void atacar(Personagem alvo) {
        // Realiza o ataque normal
        super.atacar(alvo);

        // Se o alvo continuou vivo e possui poções, tenta roubar
        if (alvo.isVivo() && alvo.getQuantPocoes() > 0) {
            Random random = new Random();
            if (random.nextDouble() < this.chanceRoubo) {
                alvo.setQuantPocoes(alvo.getQuantPocoes() - 1);
                this.setQuantPocoes(this.getQuantPocoes() + 1);
                System.out.println("👺 " + getNome() + " foi sorrateiro e ROUBOU uma poção de " + alvo.getNome() + "!");
                System.out.println("   └─> Poções restantes do " + alvo.getNome() + ": " + alvo.getQuantPocoes());
            }
        }
    }
}
