package modelo.personagem;

public class Personagem {

    private int hp;
    private int energia;
    private TipoPersonagem tipoPersonagem;
    private boolean moveu;
    private boolean atacou;
    private static final String imagePath = "";

    public Personagem(int hp, int energia, TipoPersonagem tipoPersonagem) {
        this.hp = hp;
        this.energia = energia;
        this.tipoPersonagem = tipoPersonagem;
        this.moveu = false;
        this.atacou = false;
    }

    public int getHP() {
        return this.hp;
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
