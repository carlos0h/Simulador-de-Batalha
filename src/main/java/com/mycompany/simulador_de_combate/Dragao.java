package com.mycompany.simulador_de_combate;
import java.util.Random;


public class Dragao extends Monstro {
    private int danoFogo;
    
    public Dragao(String nome, int vida, int ataqueBase, String gritoDeGuerra, int danoFogo){
        super(nome, vida, ataqueBase, gritoDeGuerra);
        this.danoFogo = danoFogo;
    }
    
    @Override 
    public void atacar(Personagem alvo){
        Random random = new Random();
        
        if(random.nextDouble() < 0.30){
            System.out.println("🔥 " + getNome() + " RESPIRA FUNDO E SOLTA UMA BOLA DE FOGO!");
            int danoTotal = calcularDano() + this.danoFogo;
            alvo.receberDano(danoTotal);
        }else{
            super.atacar(alvo);
        }
    }
}
