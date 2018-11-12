package controle;

import com.jettasoft.jettacargo.log.BasicLogger;

import constante.Constantes;
import modelo.jogador.Jogador;
import modelo.jogo.Jogo;
import modelo.personagem.Personagem;
import modelo.personagem.TipoPersonagem;
import modelo.tabuleiro.Celula;
import visao.TelaInicial;

public class Controle {

    private Jogo jogo;
    private Jogador jogadorDaVez;
    private static Controle control;

    private Controle() {

        new TelaInicial().setVisible(true);
    }

    public static Controle getObject() {
        if (control == null) {
            control = new Controle();
        }
        return control;
    }

    public void iniciarJogo() {
        this.jogo = new Jogo();
        this.jogo.adicionarAreaDeCriacaoDosJogadores();
        this.jogadorDaVez = this.jogo.getJogadorUm();
        BasicLogger.logInfo("Jogo iniciado.");
    }

    public void selecionarPersonagem(int x, int y, TipoPersonagem tipoPersonagem, int side) {

        Personagem personagem = this.jogo.selecionarPersonagem(tipoPersonagem, side);
        Celula clickedPosition = this.jogo.getTabuleiro().getCelula(x, y);
        System.out.println(this.jogadorDaVez.getAreaDeCriacao().estaDentroDaArea(clickedPosition));
        System.out.println(this.jogadorDaVez.getAreaDeCriacao().estaDentroDaArea(clickedPosition));
        BasicLogger.logInfo(this.jogadorDaVez.getNome() + " : " + personagem.getTipoPersonagem()
                + " foi selecionado para criação.");

        if (clickedPosition.getPersonagem() == null) {

            if (this.jogadorDaVez.getAreaDeCriacao().estaDentroDaArea(clickedPosition)) {
                clickedPosition.setPersonagem(personagem);
                this.jogadorDaVez.adicionarPersonagem(personagem);
                BasicLogger.logInfo(this.jogadorDaVez.getNome() + " : " + personagem.getTipoPersonagem() + " foi adicionado ao tabuleiro.");
                BasicLogger.logInfo("Posição: " + clickedPosition.getX() + ", " + clickedPosition.getY());
            }

            BasicLogger.logDebug(clickedPosition.toString() + " está fora da área de criação.");
            BasicLogger.logDebug(this.jogadorDaVez.getNome() + ": " + this.jogadorDaVez.getAreaDeCriacao().toString());
        }

        if (this.atingiuLimiteDePersonagens()) {
            this.passarTurno();
        }

    }

    public boolean atingiuLimiteDePersonagens() {
        if (Constantes.getNumeroDePersonagemPorJogador() == this.jogadorDaVez.getPersonagens().size()) {
            return true;
        }
        return false;
    }

    public void handleEndOfCreation() {
        this.jogo.changeState();
    }

    public void sair() {
        System.exit(0);
    }

    public void selecionarAcao(int x, int y) throws NullPointerException {

        Celula clickedPosition = this.jogo.getTabuleiro().getCelula(x, y);
        Personagem personagem = clickedPosition.getPersonagem();
        Celula celulaSelecionada = this.jogadorDaVez.getCelulaSelecionada();

        if (personagem != null) {

            if (this.jogadorDaVez.personagemPertenceAoJogador(personagem)) {
                // SELECIONAR
                if (celulaSelecionada != null
                        && (celulaSelecionada.getPersonagem().getTipoPersonagem().equals(TipoPersonagem.BARDO)
                        || celulaSelecionada.getPersonagem().getTipoPersonagem().equals(TipoPersonagem.CLERIGO))) {
                    this.jogo.suporte(celulaSelecionada, clickedPosition);
                    this.jogadorDaVez.setCelulaSelecionada(null);
                    System.out.println("Suporte");
                } else {
                    System.out.println("selecionar");
                    this.jogadorDaVez.setCelulaSelecionada(clickedPosition);
                }
            } else {
                // ATACAR
                System.out.println("atacar");
                this.jogo.atacar(celulaSelecionada, clickedPosition);
                this.atualizarVivas(clickedPosition);
                this.jogadorDaVez.setCelulaSelecionada(null);
            }
        } else {
            // MOVER
            System.out.println("mover");
            if (celulaSelecionada != null) {
                this.jogo.mover(celulaSelecionada, clickedPosition);
                this.jogadorDaVez.setCelulaSelecionada(null);
            }
        }
        if (ehFimTurno()) {
            passarTurno();
        }
    }

    public void doSpecialMove() {
        if (this.jogadorDaVez.getCelulaSelecionada() != null) {
            Personagem p = jogadorDaVez.getCelulaSelecionada().getPersonagem();
            if (p.getEnergia() >= p.getTipoPersonagem().getMinimoEspecial() && !p.getAtacou()) {
                this.jogo.usarEspecial(p);
                p.setAtacou(true);
                p.setEnergia(p.getEnergia() - p.getTipoPersonagem().getMinimoEspecial());
                this.jogadorDaVez.setCelulaSelecionada(null);
            }
            if (ehFimTurno()) {
                passarTurno();
            }
        }
    }

    public boolean ehFimTurno() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < this.jogadorDaVez.getPersonagens().size(); i++) {
            if (this.jogadorDaVez.getPersonagens().get(i).getMoveu()) {
                x++;
            }
            if (this.jogadorDaVez.getPersonagens().get(i).getAtacou()) {
                y++;
            }
        }
        return (x == this.getJogadorDaVez().getPersonagens().size()
                && y == this.getJogadorDaVez().getPersonagens().size());
    }

    public void passarTurno() {

        if (jogo != null) {
            this.jogadorDaVez.atualizarStatusDosPersonagens();
            BasicLogger.logInfo("Passar turno");
            BasicLogger.logInfo(this.jogadorDaVez.getNome() + ": personagens atualizados.");

            if (this.jogadorDaVez == this.jogo.getJogadorUm()) {
                this.jogadorDaVez = this.jogo.getJogadorDois();
            } else {
                this.jogadorDaVez = this.jogo.getJogadorUm();
            }

            BasicLogger.logInfo("Jogador da vez: " + this.jogadorDaVez.getNome());
            this.jogo.passarTurnoAtual();
            BasicLogger.logInfo(this.jogadorDaVez.getNome() + " : turno atual : " + this.jogo.getTurnoAtual());
        }

    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public Jogador getJogadorDaVez() {
        return this.jogadorDaVez;
    }

    private void atualizarVivas(Celula clicked) {
        if (clicked.getPersonagem().getHP() <= 0) {
            this.jogo.matar(clicked.getPersonagem());
            clicked.setPersonagem(null);
        }
    }
}
