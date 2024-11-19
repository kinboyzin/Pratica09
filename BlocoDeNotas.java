import java.util.ArrayList;

public class BlocoDeNotas {
	private ArrayList<Nota> notas;

	public BlocoDeNotas() {
		notas = new ArrayList<Nota>();

	}

	private int buscar(String conteudo) {
		for (int i = 0; i < notas.size(); i++) {
			Nota nota = notas.get(i);
			String conteudoNota = nota.getNota();
			if (conteudoNota != null && conteudoNota.equals(conteudo)) {
				return i;
			}
		}
		return -1;
	}

	public void addNota(Nota nota) {
		notas.add(nota);
	}

	public boolean removerNota(String conteudo) {
		int posicao = buscar(conteudo);
		if (posicao >= 0) {
			notas.remove(posicao);
			return true;
		} else {
			return false;
		}

	}

	public int procurarNota(String conteudo) {
		return buscar(conteudo);
	}

	public void listarNotas() {
		if (notas.isEmpty()) {
			System.out.println("Nenhuma nota encontrada.");
		} else {
			for (int i = 0; i < notas.size(); i++) {
				System.out.println((i + 1) + ". " + notas.get(i).getNota());
			}
		}
	}
}