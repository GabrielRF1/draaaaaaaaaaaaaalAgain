package modelo.tabuleiro;

import constante.Constantes;
import modelo.personagem.Personagem;

public class Tabuleiro {

    private Celula[][] tabuleiro;
    private int tamLinha;
    private int tamColuna;
    private static Tabuleiro tab;

    private Tabuleiro() {

        this.tamLinha = Constantes.getTamLinha();
        this.tamColuna = Constantes.getTamColuna();
        this.tabuleiro = new Celula[tamLinha][tamColuna];
        iniciarTabuleiroPadrao();

    }

    public static Tabuleiro getObject() {
        if (tab == null) {
            tab = new Tabuleiro();
        }
        return tab;
    }

    private void iniciarTabuleiroPadrao() {

        Celula celula;
        for (int i = 0; i < this.tamLinha; i++) {
            for (int j = 0; j < this.tamColuna; j++) {
                TipoSolo t = TipoSolo.GRAMA;
                if (i <= 4) {
                    t = TipoSolo.BASE_1;
                } else if (i >= 23) {
                    t = TipoSolo.BASE_2;
                } else if (i <= 17 && i >= 12) {
                    t = TipoSolo.AGUA;
                    if ((j >= 14 && j <= 18) || j == 3 || j == 24 || j == 10) {
                        t = TipoSolo.PONTE;
                    }
                }
                if ((i == 18 && j == 12)||(i == 11 && j == 20)) {
                t=TipoSolo.MONTANHA;
                }

                celula = new Celula(j, i, t);
                tabuleiro[j][i] = celula;
            }
        }
    }

    public Celula getCelula(int x, int y) {
        return this.tabuleiro[x][y];
    }

    public int getTamLinha() {
        return this.tamLinha;
    }

    public int getTamColuna() {
        return this.tamColuna;
    }

    public Celula[][] getTabuleiro() {
        return tabuleiro;
    }

    public void adicionarPersonagem(Celula base, Personagem personagem) {
        base.setPersonagem(personagem);
    }

    public void adicionarPersonagemAoTabuleiro(Celula celulaSelecionada, Personagem personagem) {

    }

    public boolean isInRange(int rangePersonagem, Celula pontoAtual, Celula destino) {

        return Math.abs(pontoAtual.getX() - destino.getX()) <= rangePersonagem
                && Math.abs(pontoAtual.getY() - destino.getY()) <= rangePersonagem;

    }
}
