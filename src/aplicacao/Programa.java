package aplicacao;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Programa {
	
	public static void main(String[] args) {

		PartidaDeXadrez partida = new PartidaDeXadrez();
	
		UI.mostrarTabuleiro(partida.getPecas());
	}

}
