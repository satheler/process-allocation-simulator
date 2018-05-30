/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Lucas
 */
public class LeitorArquivo {

    private static File arquivo;
    private static int quantidadeProcessos;

    public static File carregarArquivo() {

        JFileChooser chooser = new JFileChooser();
        
        FileFilter filter = new FileNameExtensionFilter("Arquivo CSV", "csv");
        chooser.addChoosableFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);

        int retorno = chooser.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Arquivo importado com sucesso");
            return arquivo;
        }

        if (arquivo == null) {
            JOptionPane.showMessageDialog(null, "Arquivo Não Selecionado");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado será mantido o anterior");
        }

        return arquivo;
    }

    public static ArrayList montarLista(File arquivo) {

        FileReader reader;
        BufferedReader br;

        ArrayList<Processo> listaProcessos = new ArrayList();

        try {
            reader = new FileReader(arquivo);
            br = new BufferedReader(reader);

            String[] entradaArray;
            String entradaString;
            String nomeProcesso;

            int tamanho;
            int tempoCheg;
            int tempoExec;

            while ((entradaString = br.readLine()) != null) {
                entradaArray = entradaString.split(",");
                nomeProcesso = entradaArray[0];
                tamanho = Integer.parseInt(entradaArray[1]);
                tempoCheg = Integer.parseInt(entradaArray[2]);
                tempoExec = Integer.parseInt(entradaArray[3]);

                listaProcessos.add(new Processo(nomeProcesso, tamanho, tempoCheg, tempoExec));
            }

        } catch (IOException ex) {
            Logger.getLogger(LeitorArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        Collections.sort(listaProcessos, (Processo o1, Processo o2) -> o1.getTempoCheg() - o2.getTempoCheg());
        LeitorArquivo.quantidadeProcessos = listaProcessos.size();
        return listaProcessos;
    }

    public static int getQuantidadeProcessos() {
        return quantidadeProcessos;
    }
}
