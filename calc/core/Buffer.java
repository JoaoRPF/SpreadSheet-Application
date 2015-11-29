package calc.core;

import java.io.Serializable;

import java.util.ArrayList;

/**
 * Class Buffer allows the creation of new buffers where will
 * be saved the cells content(one cell or a range of cells)
 *
 *@author Joao Ferreira
 */
 
public class Buffer implements Serializable{
	
	/** Serial number for serialization. */
	private static final long serial = 9319491243121923L;

	/** Array of cell's contents*/
	public ArrayList <Conteudo> vetor;
	
	/**
	 * Constructor for the buffer
	 */
	public Buffer(){
		this.vetor = new ArrayList <Conteudo>();
	}
	
	/**
	 * Returns the buffer.
	 * 
	 * @return the buffer.
	 */
	public ArrayList<Conteudo> getBuffer(){
		return this.vetor;
	}
	
	/**
	 * Returns the content of one position in the buffer
	 * 
	 * @param posicao
	 * 				position in the buffer
	 *
	 * @return the content in the given position or null
	 * if the buffer is empty
	 */
	public Conteudo getVetor(int posicao){
		if(this.vetor.isEmpty())
			return null;
		else
			return this.vetor.get(posicao);
	}
	
	/**
	 * Inserts a content in the buffer
	 * 
	 * @param cont
	 * 				content that will be insert in the buffer
	 */
	public void insereVetor(Conteudo cont){
		this.vetor.add(cont);
	}
	
	/**
	 * Clear the buffer
	 */
	public void eliminaVetor(){
		this.vetor.clear();
			
	}
}
