package com.mycompany.simulador_de_combate;

public class Vampiro extends Monstro {
    private double percentualRouboVida;

    public Vampiro(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, gritoDeGuerra);
        this.percentualRouboVida = 0.30;
    }

    @Override
    public void atacar(Personagem alvo) {
        int vidaAntesDoAtaque = alvo.getVida();
        
        super.atacar(alvo);
        
        int danoCausado = vidaAntesDoAtaque - alvo.getVida();

        if (danoCausado > 0) {
            int cura = (int) (danoCausado * this.percentualRouboVida);
            if (cura > 0) {
                this.receberCura(cura);
                System.out.println("🦇 " + getNome() + " drenou " + cura + " de HP do sangue de " + alvo.getNome() + "! (HP atual: " + getVida() + ")");
            }
        }
    }
}
