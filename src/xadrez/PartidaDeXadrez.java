package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		this.tabuleiro = new Tabuleiro(8, 8);
		iniciarPartida();
	}
	
	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] pecas = new PecaDeXadrez[this.tabuleiro.getLinhas()][this.tabuleiro.getColunas()];
		for (int i=0; i < tabuleiro.getLinhas(); i++) 
			for (int j=0; j < tabuleiro.getColunas(); j++) {
				pecas[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		return pecas;
	}
	
	private void novoLugarDaPeca(Character coluna, Integer row, PecaDeXadrez pecaDeXadrez) {
		this.tabuleiro.lugarDaPeca(pecaDeXadrez, new PosicaoXadrez(coluna, row).posicaoMatriz());
	}
	
	private void iniciarPartida() {
		this.novoLugarDaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
		this.tabuleiro.lugarDaPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(1, 4));		
	}
}
