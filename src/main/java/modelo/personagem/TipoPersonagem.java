package modelo.personagem;

public enum TipoPersonagem {

    ARQUEIRO(2, 8, 10, 20), GUERREIRO(2, 1, 3, 6), CLERIGO(0, 2, 5, 4), BARDO(0, 3, 5, 9), ASSASSINO(10, 2, 6, 7);
    /*para lembrar
        esps -> arc,  5 dano em todos inimigos
             -> gue,  ataca todas as regi'oes dentro de seu range, mesmo q sem alvos, dando 4 de dano
             -> cler,  heal 5% da vida total de todos os aliados
             -> bardo, reduz a energia de todos inimigos em 5
             -> assa,  instant kill em seu pro`ximo atk
     */
    private int dano;
    private int rangeAtacar;
    private int rangeMover;
    private int minimoEspecial;

    TipoPersonagem(int dano, int rangeAtacar, int rangeMover, int minimoEspecial) {
        this.dano = dano;
        this.rangeAtacar = rangeAtacar;
        this.rangeMover = rangeMover;
        this.minimoEspecial = minimoEspecial;
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

    public int getMinimoEspecial() {
        return minimoEspecial;
    }

}
