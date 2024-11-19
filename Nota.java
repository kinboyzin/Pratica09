public class Teste {
    public static void main(String[] args) {
       
        BlocoDeNotas bloco = new BlocoDeNotas();


        bloco.addNota(new Nota("Comprar leite"));
        bloco.addNota(new Nota("Ler um livro"));
        bloco.addNota(new Nota("Revisar código"));


        System.out.println("Notas:");
        bloco.listarNotas();


        String busca = "Ler um livro";
        int posicao = bloco.procurarNota(busca);
        if (posicao >= 0) {
            System.out.println("\nNota encontrada: \"" + busca + "\" na posição " + (posicao + 1));
        } else {
            System.out.println("\nNota \"" + busca + "\" não encontrada.");
        }


        String remover = "Comprar leite";
        if (bloco.removerNota(remover)) {
            System.out.println("\nNota \"" + remover + "\" removida com sucesso.");
        } else {
            System.out.println("\nNota \"" + remover + "\" não encontrada para remoção.");
        }

      
        System.out.println("\nNotas atualizadas:");
        bloco.listarNotas();
    }
}
