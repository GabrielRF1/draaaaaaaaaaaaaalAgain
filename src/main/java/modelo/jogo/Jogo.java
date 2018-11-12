package modelo.jogo;

import controle.Controle;
import modelo.jogador.AreaDeCriacao;
import modelo.jogador.Jogador;
import modelo.personagem.Personagem;
import modelo.personagem.TipoPersonagem;
import modelo.tabuleiro.Celula;
import modelo.tabuleiro.Tabuleiro;
import modelo.tabuleiro.TipoSolo;

public class Jogo {

    //private Tabuleiro tabuleiro;
    private Jogador jogadorUm;
    private Jogador jogadorDois;

    public void suporte(Celula origem, Celula alvo) {
        Personagem buffedTarget = alvo.getPersonagem();
        Personagem buffer = origem.getPersonagem();
        TipoPersonagem tipo = origem.getPersonagem().getTipoPersonagem();
        if (!buffer.getAtacou()) {
            if (tipo.equals(TipoPersonagem.BARDO)) {
                if (Tabuleiro.getObject().isInRange(tipo.getRangeAtacar(), origem, alvo)) {
                    buffedTarget.setEnergia(buffedTarget.getEnergia() + 70);
                    buffer.setAtacou(true);
                }
            } else {
                if (Tabuleiro.getObject().isInRange(tipo.getRangeAtacar(), origem, alvo)) {
                    buffedTarget.setDanoInfligido(-2);
                    buffer.setAtacou(true);
                }
            }
            buffer.setEnergia(buffer.getEnergia() + 1);

        }
    }

    private enum estadoGame {
        EstadoDeCriacao, EstadoDeJogo
    };
    private estadoGame estadoAtual;
    private int turnoAtual;

    public Jogo() {
        //Tabuleiro.getObject() = new Tabuleiro();
        this.jogadorUm = new Jogador("Jogador 1");
        this.jogadorDois = new Jogador("Jogador 2");
        this.estadoAtual = estadoGame.EstadoDeCriacao;
        this.turnoAtual = 0;
    }

    public void changeState() {
        switch (estadoAtual) {
            case EstadoDeCriacao:
                estadoAtual = estadoGame.EstadoDeJogo;
                break;
            case EstadoDeJogo:
                estadoAtual = estadoGame.EstadoDeCriacao;
                break;
            default:
                return;
        }
    }

    public void matar(Personagem p) {
        if (estadoAtual.equals(estadoGame.EstadoDeJogo)) {
            if (jogadorUm.getPersonagens().contains(p)) {
                jogadorUm.removerPersonagem(p);
            } else {
                jogadorDois.removerPersonagem(p);
            }
        }
    }

    public int getTurnoAtual() {
        return this.turnoAtual;
    }

    public Personagem selecionarPersonagem(TipoPersonagem tipoPersonagem, int side) {
        if (this.estadoAtual == estadoGame.EstadoDeCriacao) {
            switch (tipoPersonagem) {

                case BARDO:
                    return new Personagem(15, 2, TipoPersonagem.BARDO, side);

                case ARQUEIRO:
                    return new Personagem(5, 5, TipoPersonagem.ARQUEIRO, side);

                case ASSASSINO:
                    return new Personagem(6, 3, TipoPersonagem.ASSASSINO, side);

                case CLERIGO:
                    return new Personagem(7, 20, TipoPersonagem.CLERIGO, side);

                case GUERREIRO:
                    return new Personagem(40, 0, TipoPersonagem.GUERREIRO, side);

                default:
                    return null;
            }
        }
        return null;
    }

    public void mover(Celula origem, Celula destino) {
        if (estadoAtual.equals(estadoGame.EstadoDeJogo)) {
            if (!destino.getTipoSolo().equals(TipoSolo.AGUA)) {
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
        }
    }

    public void atacar(Celula origem, Celula alvo) {
        if (estadoAtual.equals(estadoGame.EstadoDeJogo)) {

            //personagens na ação
            Personagem personagemAtck = origem.getPersonagem();
            Personagem personagemDfns = alvo.getPersonagem();

            //atributos de range do personagem atacante
            int rangePersonagem = personagemAtck.getTipoPersonagem().getRangeAtacar();
            if (personagemAtck.getTipoPersonagem().equals(TipoPersonagem.ARQUEIRO) && origem.getTipoSolo().equals(TipoSolo.MONTANHA)) {
                rangePersonagem += 3;
            }
            //atributos de dano do personagem atacante
            int danoDoPersonagem = personagemAtck.getTipoPersonagem().getDano();
            if (personagemAtck.getTipoPersonagem() == TipoPersonagem.GUERREIRO && personagemAtck.getPowerHit()) {
                danoDoPersonagem = 4;
            }

            int energia = personagemAtck.getEnergia();

            boolean isInRange = Tabuleiro.getObject().isInRange(rangePersonagem, origem, alvo);
            boolean atacou = personagemAtck.getAtacou();

            if (!atacou && isInRange) {
                if (personagemAtck.getTipoPersonagem() == TipoPersonagem.ASSASSINO && personagemAtck.getPowerHit()) {
                    personagemDfns.setDanoInfligido(personagemDfns.getHP());
                    personagemAtck.setPowerHit(false);
                } else {
                    personagemDfns.setDanoInfligido(danoDoPersonagem);
                }
                personagemAtck.setAtacou(true);
                personagemAtck.setEnergia(energia + 1);
            }
        }
    }

    public void usarEspecial(Personagem p) {
        Jogador oponente = null;
        if (Controle.getObject().getJogadorDaVez().equals(jogadorUm)) {
            oponente = jogadorDois;
        } else {
            oponente = jogadorUm;
        }
        switch (p.getTipoPersonagem()) {
            case ARQUEIRO:
                for (Personagem pe : oponente.getPersonagens()) {
                    pe.setDanoInfligido(5);
                }
                break;
            case GUERREIRO:
                Celula origem = Controle.getObject().getJogadorDaVez().getCelulaSelecionada();
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX(), origem.getY() + 1));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX(), origem.getY() - 1));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() + 1, origem.getY()));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() - 1, origem.getY()));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() + 1, origem.getY() + 1));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() - 1, origem.getY() - 1));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() - 1, origem.getY() + 1));
                p.setPowerHit(true);
                atacar(origem, Tabuleiro.getObject().getCelula(origem.getX() + 1, origem.getY() - 1));
                p.setPowerHit(false);
                break;
            case ASSASSINO:
                p.setPowerHit(true);
                break;
            case BARDO:
                for (Personagem pe : oponente.getPersonagens()) {
                    pe.setEnergia(pe.getEnergia() - 5);
                }
                break;
            default:
                for (Personagem pe : Controle.getObject().getJogadorDaVez().getPersonagens()) {
                    if (pe != p) {
                        pe.setDanoInfligido(-(pe.getHP() + 5));
                    }
                }
        }
    }

    public void adicionarAreaDeCriacaoDosJogadores() {
        if (estadoAtual.equals(estadoGame.EstadoDeCriacao)) {

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
