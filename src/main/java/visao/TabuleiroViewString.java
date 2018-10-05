package visao;



import controle.Controle;
import modelo.tabuleiro.Celula;

public class TabuleiroViewString {
	private Controle controle;
	
	public TabuleiroViewString(Controle controle) {
		this.controle = controle;
		this.mostrarTabuleiroAtual();
	}

	public void mostrarTabuleiroAtual() {
		int tamLinha = this.controle.getJogo().getTabuleiro().getTamLinha();
		int tamColuna = this.controle.getJogo().getTabuleiro().getTamColuna();

		Celula c;
		
		System.out.println("\n");
		
		for (int i = 0; i <tamLinha; i++) {

			for (int j = 0; j < tamColuna; j++) {
				
				c = this.controle.getJogo().getTabuleiro().getCelula(i, j);
				if (c.getPersonagem() != null) {

					System.out.print("[("+i+", "+j+", "+c.getPersonagem().getTipoPersonagem()+")]");
				} else {
					System.out.print("[("+i+", "+j+", "+c.getTipoSolo()+")]");
				}
				
				if (j == 27) {
					System.out.println("\n");
				}
			}
		}
		System.out.println("\n");
		
	}

}
