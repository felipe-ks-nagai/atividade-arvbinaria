package ArvoreHeap;

public class ArvoreHeap {
    public enum ladoArv {esq, dir};

	public class No {
	// Classe que define a estrutura e operacoes basicas de um no de arvore
	// binaria capaz de armazenar um numero do tipo int
		int valor;
		No esq;
		No dir;
        int Max = 0;
        int Min = 0;

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
	
	public boolean insereNo(int v) {
	// Insere um novo no na arvore
	// O novo no sera uma folha, com valor v
	
		// Instanciando um novo no na memoria
		No noh = new No(v);
		
		if (noh == null)
			return false;

		// Cuidando do encadeamento do novo no
		No pai = this.achaPai(noh, this.getRaiz());

		if (pai == null)
			this.setRaiz(noh);
		else
            if(noh.getValor() <= pai.getValor()){
                
            }

		
			return true;
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

    public No pesquisaValor(int v) {
	// Rotina inicial para encaminhar a pesquisa.
	
		No procurado = new No(v);
		return pesquisaValorRec(procurado, this.getRaiz());	
	}

    public No pesquisaValorRec(No procurado, No atual) {
	// Pesquisa se um valor informado existe ou nao na arvore. Caso exista, 
	// retorna sua referencia, caso nao exista, retorna nulo. Faz a busca de
	// forma RECURSIVA (nao tem looping: a rotina chama a si mesma para 
	// prosseguir a busca)
		if (atual == null)				// Arvore vazia
			return null;
		if (atual.equals(procurado))
			return atual;
		else
			if (procurado.getValor() < atual.getValor())
				return pesquisaValorRec(procurado, atual.getRef(ladoArv.esq));
			else
				return pesquisaValorRec(procurado, atual.getRef(ladoArv.dir)	);
	}

    public void identificaHeap(No r) {
    // Identifica se a arvore com raiz em r e uma arvore do tipo heap
        if (r == null)
            System.out.println("Arvore vazia");
        else {
            if (verificaHeap(r))
                System.out.println("A arvore e do tipo heap");
            else
                System.out.println("A arvore nao e do tipo heap");
        }
    }

    private boolean verificaHeap(No r) {
    // Verifica se a arvore com raiz em r e uma arvore do tipo heap
        if (r == null)
            return true;
        else {
            if (r.getRef(ladoArv.esq) != null && r.getValor() < r.getRef(ladoArv.esq).getValor())
                return false;
            if (r.getRef(ladoArv.dir) != null && r.getValor() < r.getRef(ladoArv.dir).getValor())
                return false;

            return verificaHeap(r.getRef(ladoArv.esq)) && verificaHeap(r.getRef(ladoArv.dir));
        }
    }
}

