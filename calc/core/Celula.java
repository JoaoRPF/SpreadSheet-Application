package calc.core;

import java.io.Serializable;

/**
 * Class Celula contains information about cells. Each cell 
 * is identified by their line and column and have a content
 *
 *@author Joao Ferreira
 */
public class Celula implements Serializable{

	/** Serial number for serialization. */
	private static final long serial=3812831283812L;
	
	/** Cell line */
	private int linha;
	
	/** Cell column */
	private int coluna;
	
	/** Cell content */
	private Conteudo ct;
	
	/** Matrix where the cell is */
	private Matriz matriz;
	
	/**
	 * Constructor for a cell (receiving a line and column)
	 * The content is initializated with null
	 * 
	 * @param linha
	 *            	cell line
	 * @param numColunas
	 *				cell column
	 */
	public Celula (int linha, int coluna){
		this.linha=linha;
		this.coluna=coluna;
		this.ct=null;
	}
	
	/**
	 * Constructor for a cell (receiving a line, a column and a matrix)
	 * The content is initializated with null
	 
	 * @param linha
	 *            	cell line
	 * @param numColunas
	 *				cell column
	 * @param matriz
	 * 				matrix where the cell is
	 */
	public Celula(int linha, int coluna, Matriz matriz){
		this.linha=linha;
		this.coluna=coluna;
		this.ct=null;
		this.matriz=matriz;
	}
	
	/**
	 * Returns the line of the cell.
	 * 
	 * @return the line of the cell.
	 */
	public final int getLinha(){
		return this.linha;
	}
	
	/**
	 * Returns the column of the cell.
	 * 
	 * @return the column of the cell.
	 */
	public final int getColuna(){ 
		return this.coluna;
	}
	
	/**
	 * Returns the content of the cell.
	 * 
	 * @return the content of the cell.
	 */
	public Conteudo getConteudo (){
		return this.ct;
	}
	
	/**
	 * Gives one content to the cell.
	 * 
	 * @param ct
	 * 				cell content
	 */
	public void setConteudo (Conteudo ct){
		this.ct = ct;
	}
	
	/**
	 * Returns the matrix where the cell is
	 * 
	 * @return the matrix where the cell is
	 */
	public Matriz getMatriz(){
		return this.matriz;
	}
	
	/**
	 * Inserts a content in a cell.
	 * 
	 * @param cont
	 * 				content that will be inserted
	 */
	public void insereConteudo(Conteudo cont){
    	cont.setCelula(this);
    	this.setConteudo(cont);
  	}
	
	/**
	 * Delets a content in a cell
	 */ 
	public void apagaConteudo(){
		this.ct = null;
    }
    
  	/**
	 * Returns the content of the cell to copy it to
	 * the buffer
	 * 
	 * @return the content of the cell.
	 */
    public Conteudo copiaConteudo(){
    	return this.ct;
    }
    
  	public void colaConteudo(Conteudo cont){
    	insereConteudo(cont);
    }
  	
  	/**
	 * Check if a cell has a null content
	 *
	 * @return true if cell has a null content or false if 
	 * the cell has a "valid" content
	 */ 
	public boolean CelulaVazia(){
		if(this.ct == null)
			return true;
		else
			return false;
	}
}
