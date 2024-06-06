package tabuleiro;

public class Tabuleiro {

	private Integer linhas;
	private Integer colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(Integer linhas, Integer colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro criando tabuleiro: é necessário que tenha uma linha e uma coluna.");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		this.pecas = new Peca[linhas][colunas];
	}

	public Integer getLinhas() {
		return linhas;
	}

	public Integer getColunas() {
		return colunas;
	}
	
	public Peca peca(Integer linha, Integer coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Posição não existe no tabuleiro.");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Posição não existe no tabuleiro.");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void lugarDaPeca(Peca peca, Posicao posicao) {
		if (temUmaPeca(posicao)) {
			throw new TabuleiroException("Já existe uma peça nessa posição.");
		}
		this.pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	private Boolean existePosicao(Integer linha, Integer coluna) {
		return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;	
	}
	
	public Boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public Boolean temUmaPeca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("Posição não existe no tabuleiro.");
		}
		return this.peca(posicao) != null;
	}
}
