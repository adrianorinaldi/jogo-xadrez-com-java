package xadrez;

import tabuleiro.Peca;
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
	
	public boolean[][] possivelMovimentos(PosicaoXadrez posicaoDeOrigem) {
		Posicao posicao = posicaoDeOrigem.posicaoMatriz();
		validarPosicaoDeOrigem(posicao);
		return tabuleiro.peca(posicao).possivelMovimentos();
	}
	
	public PecaDeXadrez executarMovimentoDeXadrez(PosicaoXadrez posicaoDeOrigem, PosicaoXadrez posicaoDeDestino) {
		Posicao origem = posicaoDeOrigem.posicaoMatriz();
		Posicao destino = posicaoDeDestino.posicaoMatriz();
		
		validarPosicaoDeOrigem(origem);
		validarPosicaoDeDestino(origem, destino);
		Peca capturarPeca = fazerMovimento(origem, destino);
		return (PecaDeXadrez) capturarPeca;
	}
	
	private Peca fazerMovimento(Posicao origem, Posicao destino) {
		Peca peca = this.tabuleiro.removerPeca(origem);
		Peca pecaCapturada = this.tabuleiro.removerPeca(destino);
		this.tabuleiro.lugarDaPeca(peca, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoDeOrigem(Posicao posicao) {
		if (!this.tabuleiro.temUmaPeca(posicao)) {
			throw new XadrezException("Não existe uma peça nesta posição.");
		}
		if (!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new XadrezException("Não existe movimento possível para a peça escolhida.");
		}
	}
	
	private void validarPosicaoDeDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).possivelMovimento(destino)) {
			throw new XadrezException("A peça escolhida não pode se mover para a posição destino.");
		}
	}
	
	private void novoLugarDaPeca(Character coluna, Integer row, PecaDeXadrez pecaDeXadrez) {
		this.tabuleiro.lugarDaPeca(pecaDeXadrez, new PosicaoXadrez(coluna, row).posicaoMatriz());
	}
	
	private void iniciarPartida() {

		this.novoLugarDaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		this.novoLugarDaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		this.novoLugarDaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		this.novoLugarDaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		this.novoLugarDaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		this.novoLugarDaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		this.novoLugarDaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		this.novoLugarDaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		this.novoLugarDaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		this.novoLugarDaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		this.novoLugarDaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		this.novoLugarDaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
