//
//	Classe para Arvore Binaria de Busca de numeros (inteiros)
//  a ser utilizada como base para o Exercicio 1 da Lista 2 de ED.
//

package ArvBinBuscaNum;

import java.util.ArrayList;

public class ArvBinBuscaNum {
	// Enumeracao para indicar as subarvores de um no
	public enum ladoArv {esq, dir};

	public class No {
	// Classe que define a estrutura e operacoes basicas de um no de arvore
	// binaria capaz de armazenar um numero do tipo int
		int valor;
		No esq;
		No dir;
		int quant;

		public No(int v) {
		// Construtor da classe, o no criado sera uma folha com o valor
		// recebido
				this.valor = v;
				this.esq = null;
				this.dir = null;
				this.quant = 1;	
		}

		public void setValor(int v) {
		// Atribui o valor v ao no referenciado
			this.valor = v;
		}
		
		public int getValor() {
		// Retorna o inteiro armazenado no no referenciado
			return this.valor;
		}
	
		public void setRef(ladoArv lado, No p) {
		// Atribui a referencia p (que e um endereco de memoria) ao ponteiro
		// para a subarvore da esquerda ou da direita, conforme indicado no
		// primeiro parametro
			if (lado == ladoArv.esq)
				this.esq = p;
			else
				this.dir = p;
		}
		
		public No getRef(ladoArv lado) {
		// Retorna a referencia da subarvore da esquerda ou da direita do no,
		// conforme indicado no parametro
			if (lado == ladoArv.esq)
				return this.esq;
			
			return this.dir;
		}

		public void setQuant(int q) {
		// Atribui a quantidade q ao no referenciado
			this.quant = q;
		}
		
		public int getQuant() {
		// Retorna a quantidade de vezes que o valor armazenado no no foi inserido
			return this.quant;
		}

		public boolean equals(Object o) {
		// Compara o conteudo util de dois nos, retornando true se forem
		// identicos e false em caso contrario
			No outro = (No) o;
			return (this.valor == outro.valor);
		}
	}

	private No raiz;		// Armazenara o endereco da raiz geral da arvore

	public ArvBinBuscaNum() {
	// Construtor da classe ArvBinBuscaNum. Cria uma arvore vazia (raiz nula)
		this.raiz = null;
	}

	public No getRaiz() {
	// Retorna o conteudo da raiz geral da arvore (nulo ou o endereco do no raiz)
		return this.raiz;
	}

	public void setRaiz(No r){
	// Atribui o endereco de um no especifico para ser a raiz geral da arvore
		this.raiz = r;
	}
		
	public boolean arvoreVazia(No r) {
	// Retorna false se a arvore nao contiver no algum e true em caso contrario
		return (r == null);
	}
	
	public boolean insereNo(int v) {
	// Insere um novo no na arvore
	// O novo no sera uma folha, com valor v
	
		// Instanciando um novo no na memoria
		if(pesquisaValor(v) != null){
			pesquisaValor(v).setQuant(pesquisaValor(v).getQuant() + 1);
			return true;
		}
		else {
		No noh = new No(v);
		
		if (noh == null)
			return false;

		// Cuidando do encadeamento do novo no
		No pai = this.achaPai(noh, this.getRaiz());

		if (pai == null)
			this.setRaiz(noh);
		else
			if (v <= pai.getValor())
				pai.setRef(ladoArv.esq, noh);
			else
				pai.setRef(ladoArv.dir, noh);
		
			return true;
		}
	}
	
	private No achaPai(No novoNo, No candidato) {
	// Retorna a referencia do ancestral imediato do novo no. Caso a arvore
	// esteja vazia, retorna nulo. Executa o processamento de forma RECURSIVA
	// (nao tem looping: a rotina chama a si mesma para prosseguir a busca)
		
		if (candidato == null)
			return null;
		else
			if (novoNo.getValor() <= candidato.getValor())
				if (candidato.getRef(ladoArv.esq) == null)
					return candidato;
				else
					return achaPai(novoNo, candidato.getRef(ladoArv.esq));
			else
				if (candidato.getRef(ladoArv.dir) == null)
					return candidato;
				else
					return achaPai(novoNo, candidato.getRef(ladoArv.dir));
	}	

	public void imprimeArv(No r, int nivel) {
	// Imprime o conteudo de uma arvore binaria, com a raiz alinhada no
	// lado esquerdo da tela. Conforme aumenta o nivel do no, seu valor e
	// impresso mais afastado do inicio da linha.
		if (r == null) {
			return;
		}

		// Processando a primeira subarvore
		imprimeArv(r.getRef(ladoArv.esq), nivel + 1);
		
		// Fazendo o processamento do valor a imprimir
		
		// Ajustando o deslocamento horizontal na tela
		for (int i = 0; i < nivel; i++)
			System.out.printf("   ");
	
		// Imprimindo o valor e descendo uma linha
		System.out.println(r.getValor() + (r.getQuant() > 1 ? " [" + r.getQuant() + "]" : ""));	
		
		// Processando a segunda subarvore
		imprimeArv(r.getRef(ladoArv.dir), nivel + 1);
	}
	
	public No pesquisaValor(int v) {
	// Rotina inicial para encaminhar a pesquisa.
	
		No procurado = new No(v);
		ArrayList<No> caminho = new ArrayList<>();
		return pesquisaValorRec(procurado, this.getRaiz(), caminho);	
	}

	public ArrayList<No> pesquisaCaminho(int v){
		ArrayList<No> caminho = new ArrayList<>();
		No procurado = new No(v);

		if(pesquisarCaminhoRec(procurado, this.getRaiz(), caminho))
			return caminho;

		return null;
	}

	public boolean pesquisarCaminhoRec(No procurado, No atual, ArrayList<No> caminho ){
		if(atual == null)
			return false;
		caminho.add(atual);
		if(atual.equals(procurado))
			return true;
		else
			if(procurado.getValor() < atual.getValor())
				return pesquisarCaminhoRec(procurado, atual.getRef(ladoArv.esq), caminho);
			else
				return pesquisarCaminhoRec(procurado, atual.getRef(ladoArv.dir), caminho);
	}

	public No pesquisaValorRec(No procurado, No atual, ArrayList<No> caminho) {
	// Pesquisa se um valor informado existe ou nao na arvore. Caso exista, 
	// retorna sua referencia, caso nao exista, retorna nulo. Faz a busca de
	// forma RECURSIVA (nao tem looping: a rotina chama a si mesma para 
	// prosseguir a busca)
		if (atual == null)				// Arvore vazia
			return null;
		
		caminho.add(atual);
		if (atual.equals(procurado))
			return atual;
		else
			if (procurado.getValor() < atual.getValor())
				return pesquisaValorRec(procurado, atual.getRef(ladoArv.esq), caminho);
			else
				return pesquisaValorRec(procurado, atual.getRef(ladoArv.dir), caminho);
	}
	
	public int contaNos(No r) {
	// Retorna a quantidade de nos da arvore com raiz em r
		if (r == null)
			return 0;
		else
			return 1 
					+ contaNos(r.getRef(ladoArv.esq)) 
					+ contaNos(r.getRef(ladoArv.dir));
	}
}
