package com.mycompany.simulador_de_combate;

import java.util.Random;

public class Zumbi extends Monstro {

    public Zumbi(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
    }

    @Override
    public void atacar(Personagem alvo) {
        super.atacar(alvo);

        Random random = new Random();
        if (alvo.isVivo() && random.nextDouble() < 0.30) {
            System.out.println("🧟 " + getNome() + " aplicou uma MORDIDA INFECTADA!");
            alvo.receberDano(10);
        }
    }
}
