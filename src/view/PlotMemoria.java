/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import gerais.Memoria;
import gerais.Processo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class PlotMemoria extends JPanel {

    Memoria memoria;
    int tamanhoVertical = 200;
    int espacamentoVertical = 20;
    int espacamentoHorizonal = 20;    

    public PlotMemoria(Memoria memoria) {

        this.memoria = memoria;        
        super.setBackground(Color.WHITE);
        super.setPreferredSize(new Dimension(memoria.getTamanho()+(espacamentoHorizonal*2),0));
        super.revalidate();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);       
        g.drawRect(espacamentoHorizonal-1, espacamentoVertical-1, memoria.getTamanho(), tamanhoVertical+1);
        
        
        for (int i = 0; i < memoria.getTamanho(); i++) {

            Processo processo = memoria.get(i);

            if (processo != null) {

                plotProcesso(g, processo, i);

                i += processo.getTamanho();

            } else {

                int tamanhoEspaco = getTamanhoEspaco(i);
                plotEspacoLivre(g, i,tamanhoEspaco);
                i += tamanhoEspaco;

            }

        }

    }

    private void plotProcesso(Graphics g, Processo processo, int i) {

        //Desenho do Processo
        g.setColor(new Color(0,200,0));
        g.fillRect(i + espacamentoHorizonal, espacamentoVertical, processo.getTamanho()-1, tamanhoVertical);

        //Escrever nome do Processo
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial Bold", Font.BOLD, 11));
        g.drawString(processo.getNome(), i + espacamentoHorizonal, espacamentoVertical + 50);

    }

    private void plotEspacoLivre(Graphics g, int i, int tamanhoEspaco) {

        //Desenho espaco livre
        g.setColor(Color.GRAY);
        g.fillRect(i + espacamentoHorizonal, espacamentoVertical, tamanhoEspaco-1, tamanhoVertical);
        
        
        //Escrever nome do Processo
//        g.setColor(Color.BLACK);
//        g.setFont(new Font("Arial Bold", Font.BOLD, 11));
//        g.drawString("Livre", i + espacamentoHorizonal, espacamentoVertical + 50);

    }

    public int getTamanhoEspaco(int posicao) {

        int espaco = 0;

        for (int i = posicao; i < memoria.getTamanho(); i++) {

            if (memoria.get(i) == null) {
                espaco++;
            } else {
                return espaco;
            }

        }

        return espaco;

    }

}
