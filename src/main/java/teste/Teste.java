package teste;

import controle.Controle;
import modelo.personagem.TipoPersonagem;
import visao.TabuleiroViewString;

public class Teste {
	
	private Controle controle;
	private TabuleiroViewString tv;
	
	public Teste(Controle controle) {
		this.controle = controle;
		this.tv = new TabuleiroViewString(controle);
		this.run();
	}
	
	public void run() {

		//cria um boneco para teste
		this.controle.selecionarPersonagem(1,4, TipoPersonagem.ARQUEIRO);
		
		//atualiza tabuleiro
		this.tv.mostrarTabuleiroAtual();
		
		//testa fazer acao (selecionar ou movimentar, por enquanto)
		//seleciona
		this.controle.selecionarAcao(1, 4);
		//move
		this.controle.selecionarAcao(1, 5);
		this.tv.mostrarTabuleiroAtual();
		
		//testa se personagem anda além do range de movimento
		this.controle.selecionarAcao(1, 13);
		this.controle.selecionarAcao(1, 20);
		this.tv.mostrarTabuleiroAtual();
		
		//testa se personagem pode andar depois de já ter andado
		this.controle.selecionarAcao(1, 13);
		this.controle.selecionarAcao(1,15);
		this.tv.mostrarTabuleiroAtual();
		
		//testa passar turno
		System.out.println("turno atual: " + this.controle.getJogo().turnoAtual());
		System.out.println(controle.getJogadorDaVez().getNome());
		this.controle.passarTurno();
		System.out.println("turno atual: " + this.controle.getJogo().turnoAtual());
		System.out.println(controle.getJogadorDaVez().getNome());

		//testa criar boneco segundo jogador
		this.controle.selecionarPersonagem(1, 27, TipoPersonagem.BARDO);
		this.tv.mostrarTabuleiroAtual();
		//
		
	}

}
