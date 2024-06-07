package xadrez;

import tabuleiro.Posicao;

public class PosicaoXadrez {

	private Character coluna;
	private Integer linha;
	
	public PosicaoXadrez(Character coluna, Integer linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException("Erro instanciando PosicaoXadrez. Valores inválidos.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public Character getColuna() {
		return coluna;
	}

	public Integer getLinha() {
		return linha;
	}
	
	protected Posicao posicaoMatriz() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoXadrez posicaoTabuleiro(Posicao posicao) {
		return new PosicaoXadrez(String.valueOf('a' - posicao.getColuna()).charAt(0), 8 - posicao.getLinha());
	}

	@Override
	public String toString() {
		return "PosicaoXadrez [coluna=" + coluna + ", linha=" + linha + "]";
	}

}
