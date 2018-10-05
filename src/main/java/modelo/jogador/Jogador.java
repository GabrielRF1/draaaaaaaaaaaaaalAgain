package modelo.jogador;

import java.util.ArrayList;

import modelo.personagem.Personagem;
import modelo.tabuleiro.Celula;

public class Jogador {

	private String nome;
	private Celula celulaSelecionada;
	private ArrayList <Personagem> personagens;
	private AreaDeCriacao areaDeCriacao;

	public Jogador(String nome) {
		this.nome = nome;
		this.personagens = new ArrayList<>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCelulaSelecionada(Celula celula) {
		this.celulaSelecionada = celula;
	}

	public Celula getCelulaSelecionada() {
		return this.celulaSelecionada;
	}

	public ArrayList<Personagem> getPersonagens() {
		return this.personagens;
	}

	public void adicionarPersonagem(Personagem p) {
		this.personagens.add(p);
	}

	public void removerPersonagem (Personagem p) {

		for (int i = 0; i < this.personagens.size(); i++) {
			if (p == this.personagens.get(i)) {
				this.personagens.remove(p);
			}
		}

	}

	public void setAreaDeCriacao(AreaDeCriacao areaDeCriacao) {
		this.areaDeCriacao = areaDeCriacao;
	}

	public AreaDeCriacao getAreaDeCriacao() {
		return this.areaDeCriacao;
	}

	public boolean personagemPertenceAoJogador(Personagem personagem) {

		if (this.personagens.contains(personagem))
			return true;
		return false;
	
	}

	public void atualizarStatusDosPersonagens() {

		Personagem personagem = null;
		
		for (int i = 0; i < this.personagens.size(); i++) {
			personagem = personagens.get(i);
			personagem.setMoveu(false);
			personagem.setAtacou(false);
		}
		
	}
}
