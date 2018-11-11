package modelo.personagem;

public class Personagem {

    private int hp;
    private int energia;
    private TipoPersonagem tipoPersonagem;
    private boolean moveu;
    private boolean atacou;
    private final int side;

    public Personagem(int hp, int energia, TipoPersonagem tipoPersonagem, int side) {
        this.hp = hp;
        this.energia = energia;
        this.tipoPersonagem = tipoPersonagem;
        this.moveu = false;
        this.atacou = false;
        this.side = side;
    }
    
    @Override
	public String toString() {
		return "Personagem [hp=" + hp + ", energia=" + energia + ", tipoPersonagem=" + tipoPersonagem + ", moveu="
				+ moveu + ", atacou=" + atacou + "]";
	}

	public int getHP() {
        return this.hp;
    }

    public int getSide() {
        return side;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean getMoveu() {
        return moveu;
    }

    public void setMoveu(boolean moveu) {
        this.moveu = moveu;
    }

    public boolean getAtacou() {
        return this.atacou;
    }

    public void setAtacou(boolean atacou) {
        this.atacou = atacou;
    }
    
    public TipoPersonagem getTipoPersonagem() {
        return this.tipoPersonagem;
    }

	public int getEnergia() {
		return energia;
	}

	public void setDanoInfligido(int danoAInfligir) {
		this.hp = this.hp - danoAInfligir;
		
	}
}
