package com.company;

import java.security.spec.RSAOtherPrimeInfo;

public class Game {

    private Tabu board;
    boolean Term = false;
    boolean Win = false;
    int[] Jogada;
    int Round = 0;

    public Game(){
        board = new Tabu();
        Start (board);
        Jogada = new int[2];

    }

    public void Start (Tabu board){
        do{
            Round++;
            System.out.println("Rodada " + Round);
            board.Show();
            Term = board.setPosition();

            if(!Term){
                board.openOutras();
                Term = board.Win();
            }

        }while(!Term);

        if (!board.Win()){
            System.out.println("Você tocou em uma das minas! GAME OVER!!");
            board.ShowMinas();
        }else{
            System.out.println("Congratulations, você deixou os 8 campos de minas livres em "+ Round + "rodadas");
            board.ShowMinas();
        }
    }
}
