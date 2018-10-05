
package modelo.tabuleiro;

import modelo.personagem.Personagem;

public class Celula {
	
	private int x;
	private int y;
	private Personagem personagem;
	private TipoSolo tipoSolo;

	public Celula(int x, int y, TipoSolo tipoSolo) {
		this.x = x;
		this.y = y;
		this.tipoSolo = tipoSolo;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Personagem getPersonagem() {
		return this.personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public TipoSolo getTipoSolo() {
		return this.tipoSolo;
	}

	public void setTipoSolo(TipoSolo tipoSolo) {
		this.tipoSolo = tipoSolo;
	}
}
