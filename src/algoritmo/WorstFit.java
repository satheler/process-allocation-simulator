/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import gerais.Processo;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Bittecourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 * <gustavosatheler@gmail.com>
 */
public class WorstFit extends Fit {

    int maiorEspaco = Integer.MIN_VALUE;

    int indiceMaior = -1;

    public WorstFit(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

        super(listaEntrada, tamanhoMemoria);
        this.tempoClock = 0;

    }

    @Override
    public boolean executar() {

        ocorreuEvento = false;
        Processo processo;
        gerenciadorProcessos.percorreProcessos(tempoClock);

        for (int i = processosEmEspera.size() - 1; i >= 0; i--) {

            processo = processosEmEspera.get(i);

            heuristica(processo, i);

            if (indiceMaior >= 0) {

                gerenciadorProcessos.insereProcesso(processo, indiceMaior);
                processosEmEspera.remove(i);
                indiceMaior = -1;
                maiorEspaco = Integer.MIN_VALUE;
                ocorreuEvento = true;

            } else {
                //contar tentativas falhas;
            }

        }

        if (gerenciadorProcessos.executarProcessos()) {
            ocorreuEvento = true;
        }

        this.tentativasFalhas += processosEmEspera.size();
        tempoClock++;
        return ocorreuEvento;
    }

    private void heuristica(Processo processo, int indiceProcesso) {

        indiceProcura = 0;

        while (indiceProcura < memoria.getTamanho()) {

            procuraEspaco(indiceProcura);

            if (espaco >= processo.getTamanho()) {
                if (maiorEspaco < espaco) {
                    maiorEspaco = espaco;
                    indiceMaior = indiceProcura;
                    indiceProcura += espaco;
                }else{
                    indiceProcura += espaco;
                }
            } else {
                //caso exista um processo onde foi procurado
                if (espaco == 0) {
                    indiceProcura += memoria.get(indiceProcura).getTamanho();
                } else {
                    indiceProcura += espaco;
                }
            }
        }
    }

}
