package javaLG2.estruturaDeDados.memoriaDinamica;

class Celula<T> {

	T coisa;

	Celula<T> proximo;

	Celula(T coisa) {
		this.coisa = coisa;
		this.proximo = null;
	}
	
	@Override
	public String toString() {
		return this.coisa + "";
	}
}

public class FilaDinamica<T> {

	/**
	 * O tamanho da fila
	 */
	private int tamanho;

	/**
	 * O primeiro da fila
	 */
	private Celula<T> primeiro;

	public FilaDinamica() {
		this.primeiro = null;
		this.tamanho = 0;
	}

	/**
	 * O método percorre cada célula em procura de uma célula que não aponta para um
	 * outro elemento, então o último irá agora apontar para um novo elemento
	 * 
	 * @param elemento O elemento a ser adicionado
	 */
	public void adicionar(T elemento) {
		Celula<T> novaCelula = new Celula<>(elemento);

		if (primeiro == null) {
			primeiro = novaCelula;
		} else {
			Celula<T> atual = primeiro;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novaCelula;
		}
		tamanho++;
	}

	/**
	 * O método percorre a lista até o índice especificado, ao chegar nele, a célula naquele índice virtual
	 * irá agora apontar para o novo elemento, e ele por si irá apontar para o antigo próximo elemento
	 * 
	 * @param elemento O elemento a ser adicionado
	 * @param indice O indice do novo elemento
	 */
	public void adicionar(T elemento, int indice) {
		Celula<T> novaCelula = new Celula<>(elemento);
		Celula<T> atual = this.primeiro;
		Celula<T> atualProximo = atual.proximo;

		for (int i = 0; i < indice; i++) {
			atual = atual.proximo;
			atualProximo = atual.proximo;
		}
		atual.proximo = novaCelula;
		novaCelula.proximo = atualProximo;
	}
	
	@SuppressWarnings("unchecked")
	public T remover() {
		Celula<T> elemento = this.primeiro;
		
		while(elemento.proximo != null) {
			elemento = elemento.proximo;
		}
		
		T ultimo = (T) elemento;
		elemento = null;
		
		return ultimo;
	}

	public T get(int indice) {
		Celula<T> atual = this.primeiro;

		for (int i = 0; i < tamanho; i++) {
			atual = atual.proximo;
		}
		return atual.coisa;
	}

	public int tamanho() {
		return tamanho;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Celula<T> elemento = this.primeiro;
		
		sb.append("[ ");
		
		for(int i = 0; i < tamanho; i++) {
			sb.append(elemento + " ");
			elemento = elemento.proximo;
		}
		sb.append("]");
		
		return sb.toString();
	}
}