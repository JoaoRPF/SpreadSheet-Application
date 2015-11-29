package calc.core;

import java.io.Serializable;

/**
 * Class Conteudo represents the content of a cell. It can be
 * diferenciated in three type of contents (integers, references
 * to another cells or functions)
 *
 *@author Joao Ferreira
 */
 
public abstract class Conteudo implements Serializable{
	
	/** Cell where is the content */
	private Celula celula;
	
	/**
	 * Returns the cell where is the content
	 * 
	 * @return the cell where is the content
	 */
	public Celula getCelula(){
		return this.celula;
	}
	
	/**
	 * Gives the cell where is the content
	 * 
	 * @param celula
	 * 				cell where is the content
	 */
	public void setCelula(Celula celula){
		this.celula=celula;
	}
	
	/**
	 * Returns the value (integer or null) of a content.
	 * 
	 * @return the value of a content.
	 */
	public abstract Integer getConteudo();
	
	/**
	 * Returns the content in a string.
	 * 
	 * @return the content in a string.
	 */
	public abstract String toString();
}
