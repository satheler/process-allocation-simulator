package gerais;

public class Memoria {

    private final Processo[] memoriaVet;
    private final int tamanho;
    private int quantidadeProcessos;
    

    public Memoria(int tamanho) {
        this.memoriaVet = new Processo[tamanho];
        this.tamanho = tamanho;
        this.quantidadeProcessos = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Processo get(int indice) {

        try {
            return memoriaVet[indice];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " + e.getMessage());
        }
        return null;
        
    }

    public void inserirProcesso(Processo processo, int posicao) {
        for (int i = 0; i < processo.getTamanho(); i++) {
            if (memoriaVet[posicao + i] == null) {
                memoriaVet[posicao + i] = processo;
            }
        }        
        this.quantidadeProcessos++;
    }

    public void removerProcesso(Processo processo, int posicao) {
        for (int i = 0; i < processo.getTamanho(); i++) {
            memoriaVet[posicao + i] = null;
        }
        this.quantidadeProcessos--;
    }

    public int getQuantidadeProcessos() {
        return quantidadeProcessos;
    }
        
    @Override
    public String toString() {

        String memoriaString = "";

        for (Processo processo : memoriaVet) {
            if(processo != null){
                 memoriaString += " " + processo.toString();
            }else{
                memoriaString+= " -";
            }
           
        }

        return memoriaString;

    }

}
