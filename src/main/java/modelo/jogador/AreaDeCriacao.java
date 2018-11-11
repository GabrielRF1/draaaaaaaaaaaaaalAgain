package modelo.jogador;
import modelo.tabuleiro.Celula;

public class AreaDeCriacao {

	private Celula infEsquerda;
	private Celula supEsquerda;

	private Celula infDireita;
	private Celula supDireita;

	public AreaDeCriacao(Celula infEsquerda, Celula supEsquerda, Celula infDireita, Celula supDireita) {
		this.infEsquerda = infEsquerda;
		this.supEsquerda = supEsquerda;
		this.infDireita = infDireita;
		this.supDireita = supDireita;
	}

	@Override
	public String toString() {
		return "AreaDeCriacao [infEsquerda=" + infEsquerda.toStringError() + ", supEsquerda=" + supEsquerda.toStringError() + ", infDireita="
				+ infDireita.toStringError() + ", supDireita=" + supDireita.toStringError() + "]";
	}

	public boolean estaDentroDaArea(Celula clickedPosition) {

		// inferior esquerda
		if (clickedPosition.getX() >= infEsquerda.getX() && clickedPosition.getY() >= infEsquerda.getY()) {
			
			// inferior direita
			if (clickedPosition.getX() <= infDireita.getX() && clickedPosition.getY() >= infDireita.getY()) {
				
				//superior direita
				if(clickedPosition.getX() <= supDireita.getX() && clickedPosition.getY() <= supDireita.getY()) {

					//superior esquerda
					if (clickedPosition.getX() >= supEsquerda.getX() && clickedPosition.getY() <= supEsquerda.getY()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}