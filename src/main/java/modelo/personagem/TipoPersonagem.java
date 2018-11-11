package modelo.personagem;

public enum TipoPersonagem {

	ARQUEIRO(2, 8, 10), GUERREIRO(2, 1, 3), CLERIGO(0, 1, 5), BARDO(0, 1, 5), ASSASSINO(10, 2, 6);

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