package com.company;

import java.util.Random;
import java.util.Scanner;

public class Tabu {

    private int [][] Minas;
    private char [][] tab;
    private int Linha, Coluna;
    Random random = new Random();
    Scanner entrada = new Scanner(System.in);

    public Tabu(){
        Minas = new int[10][10];
        tab = new char [10][10];
        IniciaMinas(); //Vai colocar 0 em todas as posições
        SortMinas(); //Vai colocar aleatóriamente 10 minas no Tab
        PreencheDicas(); //Preenche o Tab de minas com o num de minas vizinha
        IniciaTabu();
    }

    public boolean Win(){
        int count=0;
        for(int line = 1 ; line < 9 ; line++)
            for(int column = 1 ; column < 9 ; column++)
                if(tab[line][column]=='_')
                    count++;
        if(count == 10)
            return true;
        else
            return false;
    }

    public void openOutras(){
        for(int i=-1 ; i<2 ; i++)
            for(int j=-1 ; j<2 ; j++)
                if( (Minas[Linha+i][Coluna+j] != -1) && (Linha != 0 && Linha != 9 && Coluna != 0 && Coluna != 9) ){
                    tab[Linha+i][Coluna+j]=Character.forDigit(Minas[Linha+i][Coluna+j], 10);
                }
    }



    public int getPosicao(int Linha, int Coluna){
        return Minas[Linha][Coluna];
    }

    public boolean setPosition(){

        do{
            System.out.print("\nLinha: ");
            Linha = entrada.nextInt();
            System.out.print("Coluna: ");
            Coluna = entrada.nextInt();

            if( (tab[Linha][Coluna] != '_') && ((Linha < 9 && Linha > 0) && (Coluna < 9 && Coluna > 0)))
                System.out.println("Esse campo já está sendo exibido");

            if( Linha < 1 || Linha > 8 || Coluna < 1 || Coluna > 8)
                System.out.println("Escolha números de 1 até 8");

        }while((Linha < 1 && Linha > 8) && (Coluna < 1 && Coluna > 8) || (tab[Linha][Coluna] != '_') );

        if(getPosicao(Linha, Coluna)== -1)
            return true;
        else
            return false;




    }

    public void Show(){
        System.out.println("\n     Linhas");
        for(int Linha = 8 ; Linha > 0 ; Linha--){
            System.out.print("       "+Linha + " ");

            for(int Coluna = 1 ; Coluna < 9 ; Coluna++){
                System.out.print("   "+ tab[Linha][Coluna]);
            }

            System.out.println();
        }

        System.out.println("\n            1   2   3   4   5   6   7   8");
        System.out.println("                      Colunas");

    }

    public void PreencheDicas(){
        for(int line=1 ; line < 9 ; line++)
            for(int column=1 ; column < 9 ; column++){

                for(int i=-1 ; i<=1 ; i++)
                    for(int j=-1 ; j<=1 ; j++)
                        if(Minas[line][column] != -1)
                            if(Minas[line+i][column+j] == -1)
                                Minas[line][column]++;

            }

    }

    public void ShowMinas(){
        for(int i=1 ; i < 9; i++)
            for(int j=1 ; j < 9 ; j++)
                if(Minas[i][j] == -1)
                    tab[i][j]='*';

        Show();
    }

    public void IniciaTabu(){
        for(int i=1 ; i<Minas.length ; i++)
            for(int j=1 ; j<Minas.length ; j++)
                tab[i][j]= '_';
    }

    public void IniciaMinas(){
        for(int i=0 ; i<Minas.length ; i++)
            for(int j=0 ; j<Minas.length ; j++)
                Minas[i][j]=0;
    }

    public void SortMinas(){
        boolean Sorteado;
        int Linha, Coluna;
        for(int i=0 ; i<10 ; i++){

            do{
                Linha = random.nextInt(8) + 1;
                Coluna = random.nextInt(8) + 1;

                if(Minas[Linha][Coluna] == -1)
                    Sorteado=true;
                else
                    Sorteado = false;
            }while(Sorteado);

            Minas[Linha][Coluna] = -1;
        }









}

}
