/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import gerais.Memoria;
import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Bittecourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 * <gustavosatheler@gmail.com>
 */
public abstract class Fit {

    protected ArrayList<Processo> processosEmEspera;
    protected GerenciadorProcessos gerenciadorProcessos;
    protected Memoria memoria;
    protected int tempoClock;
    protected int espaco;
    protected int indiceProcura;
    protected int tentativasFalhas;
    protected boolean ocorreuEvento;

    public Fit(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

        this.gerenciadorProcessos = new GerenciadorProcessos(listaEntrada, tamanhoMemoria);
        this.processosEmEspera = gerenciadorProcessos.getProcessosEmEspera();
        this.memoria = gerenciadorProcessos.getMemoria();
        this.tentativasFalhas = 0;

    }

    public void procuraEspaco(int posicao) {

        espaco = 0;

        for (int i = posicao; i < memoria.getTamanho(); i++) {

            if (memoria.get(i) == null) {
                espaco++;
            } else {
                break;
            }

        }

    }

    public int contarEspacos() {
        indiceProcura = 0;
        int quantidadeEspacos = 0;

        while (indiceProcura < memoria.getTamanho()) {
            procuraEspaco(indiceProcura);
            if (espaco == 0) {
                indiceProcura += memoria.get(indiceProcura).getTamanho();
            } else {
                quantidadeEspacos++;
                indiceProcura += espaco;
            }
        }
        
        return quantidadeEspacos;
        
    }

    abstract public boolean executar();
    
    public Memoria getMemoria() {
        return memoria;
    }

    @Override
    public String toString() {
        return memoria.toString();
    }

    public GerenciadorProcessos getGerenciadorProcessos() {
        return gerenciadorProcessos;
    }

    public int getTempoClock() {
        return tempoClock;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

   

}
