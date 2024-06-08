package aplicacao;

import java.util.Scanner;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;

public class Programa {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
	
		while (true) {
			UI.mostrarTabuleiro(partida.getPecas());
			System.out.println();
			System.out.println("Origem: ");
			PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
			
			System.out.println();
			System.out.println("Destino: ");
			PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
			
			PecaDeXadrez pecaXadrez = partida.executarMovimentoDeXadrez(origem, destino);
		}
	}

}
