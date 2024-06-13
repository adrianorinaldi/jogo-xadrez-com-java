package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}

	@Override
	public boolean[][] possivelMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao posicaoLocal = new Posicao(0, 0);
		
		//cima
		posicaoLocal.setValues(super.posicao.getLinha() - 1, super.posicao.getColuna());
		while (getTabuleiro().existePosicao(posicaoLocal) && !getTabuleiro().temUmaPeca(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
			posicaoLocal.setLinha(posicaoLocal.getLinha() - 1);
		}
		
		if (getTabuleiro().existePosicao(posicaoLocal) && ehUmaPecaDoOponente(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
		}
		
		//esquerda
		posicaoLocal.setValues(super.posicao.getLinha(), super.posicao.getColuna() -1);
		while (getTabuleiro().existePosicao(posicaoLocal) && !getTabuleiro().temUmaPeca(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
			posicaoLocal.setColuna(posicaoLocal.getColuna() - 1);
		}
		
		if (getTabuleiro().existePosicao(posicaoLocal) && ehUmaPecaDoOponente(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
		}
		
		//direita
		posicaoLocal.setValues(super.posicao.getLinha(), super.posicao.getColuna() + 1);
		while (getTabuleiro().existePosicao(posicaoLocal) && !getTabuleiro().temUmaPeca(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
			posicaoLocal.setColuna(posicaoLocal.getColuna() + 1);
		}
		
		if (getTabuleiro().existePosicao(posicaoLocal) && ehUmaPecaDoOponente(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
		}
		
		//baixo
		posicaoLocal.setValues(super.posicao.getLinha() + 1, super.posicao.getColuna());
		while (getTabuleiro().existePosicao(posicaoLocal) && !getTabuleiro().temUmaPeca(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
			posicaoLocal.setLinha(posicaoLocal.getLinha() + 1);
		}
		
		if (getTabuleiro().existePosicao(posicaoLocal) && ehUmaPecaDoOponente(posicaoLocal)) {
			mat[posicaoLocal.getLinha()][posicaoLocal.getColuna()] = true;
		}
		
		return mat;
	}
}
