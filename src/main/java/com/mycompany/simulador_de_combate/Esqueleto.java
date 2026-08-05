package com.mycompany.simulador_de_combate;

import java.util.Random;

public class Esqueleto extends Monstro {

    public Esqueleto(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
    }

    @Override
    public void atacar(Personagem alvo) {
        super.atacar(alvo);

        Random random = new Random();
        if (alvo.isVivo() && random.nextDouble() < 0.30) {
            System.out.println("💀 " + getNome() + " usou ATAQUE DUPLO!");
            super.atacar(alvo);
        }
    }
}
