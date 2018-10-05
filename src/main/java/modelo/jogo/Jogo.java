package modelo.jogo;

import modelo.jogador.AreaDeCriacao;
import modelo.jogador.Jogador;
import modelo.personagem.Personagem;
import modelo.personagem.TipoPersonagem;
import modelo.tabuleiro.Celula;
import modelo.tabuleiro.Tabuleiro;

public class Jogo {

    //private Tabuleiro tabuleiro;
    private Jogador jogadorUm;
    private Jogador jogadorDois;
    private int turnoAtual;

    public Jogo() {

        //Tabuleiro.getObject() = new Tabuleiro();
        this.jogadorUm = new Jogador("Jogador 1");
        this.jogadorDois = new Jogador("Jogador 2");
        this.turnoAtual = 0;

    }

    public Personagem selecionarPersonagem(TipoPersonagem tipoPersonagem) {

        switch (tipoPersonagem) {

            case BARDO:
                return new Personagem(0, 0, TipoPersonagem.BARDO);

            case ARQUEIRO:
                return new Personagem(0, 0, TipoPersonagem.ARQUEIRO);

            case ASSASSINO:
                return new Personagem(0, 0, TipoPersonagem.ASSASSINO);

            case CLERIGO:
                return new Personagem(0, 0, TipoPersonagem.CLERIGO);

            case GUERREIRO:
                return new Personagem(0, 0, TipoPersonagem.GUERREIRO);

            default:
                return null;
        }
    }

    public void mover(Celula origem, Celula destino) {

        Personagem personagem = origem.getPersonagem();
        int rangePersonagem = personagem.getTipoPersonagem().getRangeMover();

        if (Tabuleiro.getObject().isInRange(rangePersonagem, origem, destino)) {

            if (!personagem.getMoveu()) {

                destino.setPersonagem(personagem);
                personagem.setMoveu(true);
                origem.setPersonagem(null);

            }
        }
    }

    public boolean ehEtapaDeSelecionarPersonagem() {
        if (this.turnoAtual == 0 || this.turnoAtual == 1) {
            return true;
        }
        return false;
    }

    public void atacar(Celula origem, Celula alvo) {

        //personagens na ação
        Personagem personagemAtck = origem.getPersonagem();
        Personagem personagemDfns = alvo.getPersonagem();

        //atributos de range do personagem atacante
        int rangePersonagem = personagemAtck.getTipoPersonagem().getRangeAtacar();

        //atributos de dano do personagem atacante
        int danoDoPersonagem = personagemAtck.getTipoPersonagem().getDano();
        int energia = personagemAtck.getEnergia();

        int danoAInfligir = this.calcularDanoAInfligir(danoDoPersonagem, energia);

        if (Tabuleiro.getObject().isInRange(rangePersonagem, origem, alvo)) {

            personagemDfns.setDanoInfligido(danoAInfligir);

        }
    }

    public int calcularDanoAInfligir(int dano, int energia) {

        return 0;
    }

    public int calcularEnergiaAdicional() {
        return 0;
    }

    public void adicionarAreaDeCriacaoDosJogadores() {
        Celula infEsquerda;
        Celula supEsquerda;

        Celula infDireita;
        Celula supDireita;
        AreaDeCriacao areaDeCriacao;

        //Jogador UM
        infEsquerda = Tabuleiro.getObject().getCelula(0, 0);
        supEsquerda = Tabuleiro.getObject().getCelula(0, 4);

        infDireita = Tabuleiro.getObject().getCelula(27, 0);
        supDireita = Tabuleiro.getObject().getCelula(27, 4);

        areaDeCriacao = new AreaDeCriacao(infEsquerda, supEsquerda, infDireita, supDireita);
        this.jogadorUm.setAreaDeCriacao(areaDeCriacao);

        // Jogador DOIS
        infEsquerda = Tabuleiro.getObject().getCelula(0, 23);
        supEsquerda = Tabuleiro.getObject().getCelula(0, 27);

        infDireita = Tabuleiro.getObject().getCelula(27, 23);
        supDireita = Tabuleiro.getObject().getCelula(27, 27);

        areaDeCriacao = new AreaDeCriacao(infEsquerda, supEsquerda, infDireita, supDireita);
        this.jogadorDois.setAreaDeCriacao(areaDeCriacao);

    }

    public void passarTurnoAtual() {
        this.turnoAtual++;
    }

    public int turnoAtual() {
        return this.turnoAtual;
    }

    public Jogador getJogadorUm() {
        return this.jogadorUm;
    }

    public Jogador getJogadorDois() {
        return this.jogadorDois;
    }

    public Tabuleiro getTabuleiro() {
        return Tabuleiro.getObject();
    }

}
