
package com.mycompany.simulador_de_combate;

public class Monstro extends Personagem{
    String gritoDeGuerra;

    
    public Monstro(String nome, int vida, int ataqueBase, String gritoDeGuerra) {
        super(nome, vida, ataqueBase, 0.05);
        this.gritoDeGuerra = gritoDeGuerra;
    }
    
    @Override
    public void atacar(Personagem alvo){
        System.out.println(this.getNome() + " urra: \"" + this.gritoDeGuerra + "\"!");
        super.atacar(alvo);
    }
}
