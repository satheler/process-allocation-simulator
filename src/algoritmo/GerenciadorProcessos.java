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
 * @author Lucas
 */
public class GerenciadorProcessos {

    private final ArrayList<Processo> processosDeEntrada;
    private final ArrayList<Processo> processosEmEspera;
    private final ArrayList<Processo> processosEmExecucao;
    private final Memoria memoria;

    public GerenciadorProcessos(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

        this.processosDeEntrada = listaEntrada;
        this.processosEmEspera = new ArrayList();
        this.processosEmExecucao = new ArrayList();
        this.memoria = new Memoria(tamanhoMemoria);

    }

    public void percorreProcessos(int tempoClock) {

        for (int i = 0; i < processosDeEntrada.size(); i++) {
            Processo processo = processosDeEntrada.get(i);
            if (processo.getTempoCheg() == tempoClock) {
                processosEmEspera.add(processo);
                processosDeEntrada.remove(i);
                //Retorna um no contador para não pular nenhum processo da lista
                i--;
            } else {
                /*A lista de entrada está sempre ordenada por tempo de chegada
                então para otimização se o tempo não é igual ao tempo de clock 
                não é necessário percorrer toda a lista*/
                break;
            }
        }

    }

    public void insereProcesso(Processo processo, int posicao) {
        memoria.inserirProcesso(processo, posicao);
        processosEmExecucao.add(processo);
        processo.setPosicaoMemoria(posicao);
    }

    public boolean executarProcessos() {

        boolean removeuAlgumProcesso = false;

        for (int i = processosEmExecucao.size() - 1; i >= 0; i--) {
            Processo processo = processosEmExecucao.get(i);
            processo.executar();
            if (processo.getTempoExec() == 0) {
                removerProcessoFinalizado(processo);
                removeuAlgumProcesso = true;
            }
        }

        return removeuAlgumProcesso;

    }

    public void removerProcessoFinalizado(Processo processo) {

        memoria.removerProcesso(processo, processo.getPosicaoMemoria());
        processosEmExecucao.remove(processo);

    }

    public ArrayList<Processo> getProcessosEmEspera() {
        return processosEmEspera;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public boolean finalizou() {

        if (processosDeEntrada.size() == 0 && processosEmEspera.size() == 0
                && processosEmExecucao.size() == 0) {
            return true;
        }
        return false;
    }

}
