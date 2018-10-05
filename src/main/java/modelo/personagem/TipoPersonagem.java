package modelo.personagem;

public enum TipoPersonagem {

	ARQUEIRO(100, 5, 5), GUERREIRO(100, 5, 5), CLERIGO(100, 5, 5), BARDO(100, 5, 5), ASSASSINO(100, 5, 5);

	private int dano;
	private int rangeAtacar;
	private int rangeMover;

	TipoPersonagem(int dano, int rangeAtacar, int rangeMover) {
		this.dano = dano;
		this.rangeAtacar = rangeAtacar;
		this.rangeMover = rangeMover;
	}

	public int getDano() {
		return this.dano;
	}

	public int getRangeAtacar() {
		return this.rangeAtacar;
	}

	public int getRangeMover() {
		return this.rangeMover;
	}

}