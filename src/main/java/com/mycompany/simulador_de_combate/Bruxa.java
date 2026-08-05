package com.mycompany.simulador_de_combate;

import java.util.Random;

public class Bruxa extends Monstro {

    public Bruxa(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
    }

    @Override
    public void atacar(Personagem alvo) {
        Random random = new Random();

        if (random.nextDouble() < 0.35) {
            int danoMagico = getAtaqueBase() + 12;
            System.out.println("🧙‍♀️ " + getNome() + " lançou uma POÇÃO NEGRA MÁGICA!");
            alvo.receberDano(danoMagico);
        } else {
            super.atacar(alvo);
        }
    }
}
