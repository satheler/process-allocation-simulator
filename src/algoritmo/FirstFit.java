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
 * @author SABRINA
 */
public class FirstFit extends Fit {    
    
    public FirstFit(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

        super(listaEntrada, tamanhoMemoria);
        this.tempoClock = 0;

    }
    //USA O PRIMEIRO BURACO QUE COUBER O PROCESSO
    //encontrar primeiro buraco vazio
    //verificar se tem espaço para o processo
    //se tiver insere se não procura novamente se não houver mais espaço retorna que não tem espaço para a terefa ser alocada 

    @Override
    public boolean executar() {

        ocorreuEvento = false;
        Processo processo;
        gerenciadorProcessos.percorreProcessos(tempoClock);

        for (int i = processosEmEspera.size() - 1; i >= 0; i--) {

            
            processo = processosEmEspera.get(i);
            heuristica(processo, i);

        }

        this.tentativasFalhas += processosEmEspera.size();
        
        if (gerenciadorProcessos.executarProcessos()) {
            ocorreuEvento = true;
        }

        tempoClock++;
        return ocorreuEvento;
    }

    private void heuristica(Processo processo, int indiceProcesso) {

        indiceProcura = 0;
        
        while (indiceProcura < memoria.getTamanho()) {

            procuraEspaco(indiceProcura, processo.getTamanho());

            if (espaco >= processo.getTamanho()) {

                gerenciadorProcessos.insereProcesso(processo, indiceProcura);
                processosEmEspera.remove(indiceProcesso);
                //Pula o indice de procura para não ficar sempre procurando
                //em locais no qual já passou.
                indiceProcura += processo.getTamanho();
                ocorreuEvento = true;
                break;

            } else {

                if (espaco == 0) {
                    indiceProcura += memoria.get(indiceProcura).getTamanho();
                } else {
                    indiceProcura += espaco;
                }
            }
        }
    }

    //metodo procuraEspaco espeficio para heuristica FirstFit, mais otimizado
    //pois retorna direto se encontrar espaco suficiente para o processo
    //não necessitando percorrer toda memoria quando está vazia, nem todo o 
    //buraco caso este seja muito grande
    private void procuraEspaco(int posicao, int tamanho) {

        espaco = 0;

        for (int i = posicao; i < memoria.getTamanho(); i++) {

            if (memoria.get(i) == null) {
                espaco++;

                if (espaco == tamanho) {
                    break;
                }

            } else {
                break;
            }

        }        

    }

}
