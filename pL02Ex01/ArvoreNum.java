// Programa cliente para manipulacao de arvore binaria de busca de inteiros
// a ser utilizado como base para o Exercicio 1 da Lista 2 de ED.
// Os detalhes de implementacao da arvore estao contidos no package 
// ArvBinBuscaNum.
import java.util.Scanner;
import ArvBinBuscaNum.ArvBinBuscaNum;

public class ArvoreNum {
	public static void main(String[] args) {
		ArvBinBuscaNum arv = new ArvBinBuscaNum();
		int valor;
		
		Scanner s = new Scanner(System.in);

		// Construindo a arvore com os valores informados
		while (true) {
			valor = s.nextInt();
		
			if (valor == -999)
				break;
		
			if (arv.insereNo(valor) == false)
			{	System.out.println("Memoria insuficiente para inclusoes");
				break;
			}
		}
		
		// Exibindo o conteúdo da arvore que foi gerada
		if (arv.arvoreVazia(arv.getRaiz()))
			System.out.println("Arvore vazia");
		else {
			arv.imprimeArv(arv.getRaiz(), 0);
			System.out.println("A arvore possui " + arv.contaNos(arv.getRaiz()) + " nos");
			System.out.println();
		}
		
		// Pesquisando um valor na arvore
		while (true) {
			System.out.println("Informe um valor para ser pesquisado na arvore:");
			valor = s.nextInt();
		
			if (valor == -999)
				break;
			
			if (arv.pesquisaValor(valor) != null)
				System.out.println("O valor " + valor + " foi encontrado na arvore");
			else
				System.out.println("O valor " + valor + " NAO EXISTE na arvore");
		}
	}
}
