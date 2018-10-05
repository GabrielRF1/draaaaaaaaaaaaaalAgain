package controle;

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
        iniciarJogo();
        //new Teste(this);
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

    }

    public void selecionarPersonagem(int x, int y, TipoPersonagem tipoPersonagem) {

        Personagem personagem = this.jogo.selecionarPersonagem(tipoPersonagem);
        Celula clickedPosition = this.jogo.getTabuleiro().getCelula(x, y);
        System.out.println(this.jogadorDaVez.getAreaDeCriacao().estaDentroDaArea(clickedPosition));

        if (clickedPosition.getPersonagem() == null
                && this.jogadorDaVez.getAreaDeCriacao().estaDentroDaArea(clickedPosition)) {
            clickedPosition.setPersonagem(personagem);
            this.jogadorDaVez.adicionarPersonagem(personagem);
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

    public void verRegras() {

    }

    public void sair() {
        System.exit(0);
    }

    public void selecionarAcao(int x, int y) {

        Celula clickedPosition = this.jogo.getTabuleiro().getCelula(x, y);
        Personagem personagem = clickedPosition.getPersonagem();
        Celula celulaSelecionada = this.jogadorDaVez.getCelulaSelecionada();

        //System.out.println("posicao clicada: " + x + ", " + y);
        if (personagem != null) {

            if (this.jogadorDaVez.personagemPertenceAoJogador(personagem)) {
                // SELECIONAR
                System.out.println("selecionar");
                this.jogadorDaVez.setCelulaSelecionada(clickedPosition);
            } else {
                // ATACAR
                System.out.println("atacar");
                this.jogo.atacar(celulaSelecionada, clickedPosition);
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
        checarfimTurno();
    }

    public boolean checarfimTurno() {
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

            if (this.jogadorDaVez == this.jogo.getJogadorUm()) {
                this.jogadorDaVez = this.jogo.getJogadorDois();
            } else {
                this.jogadorDaVez = this.jogo.getJogadorUm();
            }

            this.jogo.passarTurnoAtual();
        }

    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public Jogador getJogadorDaVez() {
        return this.jogadorDaVez;
    }
}
