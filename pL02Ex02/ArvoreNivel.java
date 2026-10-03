// Programa cliente para manipulacao de arvore binaria de inteiros em niveis
// a ser utilizado como base para o Exercicio 2 da Lista 2 de ED.
// Os detalhes de implementacao da arvore estao contidos no package 
// ArvNumNivel.
import java.util.Scanner;
import ArvNumNivel.ArvNumNivel;

public class ArvoreNivel {
	public static void main(String[] args) {
		ArvNumNivel arv = new ArvNumNivel();
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
//			arv.imprimeArvNvl(arv.getRaiz(), "Conteudo da arvore");
			System.out.println();
			System.out.println("Resumo");
			System.out.println("  Qtde nos: " + arv.contaNos(arv.getRaiz()));
			System.out.println("  Altura .: " + arv.alturaArv(arv.getRaiz(), 0));
			System.out.println("  Pares ..: " + arv.contaPares(arv.getRaiz()));
			System.out.println();
		}
		
		// Pesquisando um valor na arvore
		while (true) {
			//System.out.println("Informe um valor para ser pesquisado na arvore:");
			valor = s.nextInt();
		
			if (valor == -999)
				break;
			
			if (arv.pesquisaValor(valor))
				System.out.println(valor + " encontrado");
			else {
				System.out.println("Valor " + valor + " nao existe na arvore");
			}
		}
		s.close();
	}
}
