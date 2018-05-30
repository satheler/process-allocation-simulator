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
public class BestFit extends Fit {
    
    int menorEspaco = Integer.MAX_VALUE;  
    
    int indiceMenor = -1;

    public BestFit(ArrayList<Processo> listaEntrada, int tamanhoMemoria) {

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

            if (indiceMenor >= 0) {

                gerenciadorProcessos.insereProcesso(processo, indiceMenor);
                processosEmEspera.remove(i);
                indiceMenor = -1;
                menorEspaco = Integer.MAX_VALUE;
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

            if (espaco == processo.getTamanho()) {               
                //Pula o indice de procura para não ficar sempre procurando
                //em locais no qual já passou.
                indiceMenor = indiceProcura;
                indiceProcura += processo.getTamanho();                
                ocorreuEvento = true;
                break;
                
            } else {

                if (espaco >= processo.getTamanho()) {
                    if (menorEspaco > espaco) {
                        menorEspaco = espaco;
                        indiceMenor = indiceProcura;
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

}
