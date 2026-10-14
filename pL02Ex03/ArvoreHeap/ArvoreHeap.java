package ArvoreHeap;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArvoreHeap {
    public enum ladoArv {esq, dir};

	public class No {
	// Classe que define a estrutura e operacoes basicas de um no de arvore
	// binaria capaz de armazenar um numero do tipo int
		int valor;
		No esq;
		No dir;
		public No(int v) {
		// Construtor da classe, o no criado sera uma folha com o valor
		// recebido
			this.valor = v;
			this.esq = null;
			this.dir = null;
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
    }

    private No raiz;		// Armazenara o endereco da raiz geral da arvore

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
	
	public String insereNos(String valores) {
		// Insere varios nos na arvore
		String[] vals = valores.split(" ");
		
		for (int i = 1; i < vals.length; i++) {
			insereNo(Integer.parseInt(vals[i]));
		}
		return identificaHeap(this.getRaiz());
	}

	public boolean insereNo(int v) {
	// Insere um novo no na arvore
	// O novo no sera uma folha, com valor v
	
		// Instanciando um novo no na memoria
		No noh = new No(v);
		
		if (noh == null)
			return false;

		// Cuidando do encadeamento do novo no
		No pai = this.achaPai(this.getRaiz());

		if (pai == null)
			this.setRaiz(noh);
		else
			if(pai.getRef(ladoArv.esq) == null)
				pai.setRef(ladoArv.esq, noh);
			else
				pai.setRef(ladoArv.dir, noh);
		
			return true;
	}
	
	private No achaPai(No r) {
	// Retorna a referencia do ancestral imediato do novo no. Caso a arvore
	// esteja vazia, retorna nulo. Executa o processamento de forma RECURSIVA
	// (nao tem looping: a rotina chama a si mesma para prosseguir a busca)
		if (r == null)
			return null;

		Queue<No> queue = new ArrayDeque<>();
		No candidato = new No(0);

		queue.offer(r);					// Colocando o no r na fila
		while (!queue.isEmpty())
		{	candidato = queue.poll();	// Retirando um no da fila

			if (candidato.getRef(ladoArv.esq) != null)
				queue.offer(candidato.getRef(ladoArv.esq));	// Enfileirando
			else
				break;
			
			if (candidato.getRef(ladoArv.dir) != null)
				queue.offer(candidato.getRef(ladoArv.dir));	// Enfileirando
			else
				break;
		}

		return candidato;
		
	}	
    public String identificaHeap(No r) {
    // Identifica se a arvore com raiz em r e uma arvore do tipo heap
            if (maxHeap(r))
                return "max";
            else if (minHeap(r))
                return "min";
            else
                return "nada";
    }

	private boolean maxHeap(No r) {
	// Verifica se a arvore com raiz em r e uma arvore do tipo max
		if (r == null)
			return true;
		else {
			if (r.getRef(ladoArv.esq) != null && r.getValor() < r.getRef(ladoArv.esq).getValor())
				return false;
			if (r.getRef(ladoArv.dir) != null && r.getValor() < r.getRef(ladoArv.dir).getValor())
				return false;

			return maxHeap(r.getRef(ladoArv.esq)) && maxHeap(r.getRef(ladoArv.dir));
		}
	}

	private boolean minHeap(No r) {
	// Verifica se a arvore com raiz em r e uma arvore do tipo min
		if (r == null)
			return true;
		else {
			if (r.getRef(ladoArv.esq) != null && r.getValor() > r.getRef(ladoArv.esq).getValor())
				return false;
			if (r.getRef(ladoArv.dir) != null && r.getValor() > r.getRef(ladoArv.dir).getValor())
				return false;

			return minHeap(r.getRef(ladoArv.esq)) && minHeap(r.getRef(ladoArv.dir));
		}
	}
}

