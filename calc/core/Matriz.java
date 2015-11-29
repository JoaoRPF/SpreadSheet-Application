package calc.core;

import java.io.Serializable;

public class Matriz implements Serializable{
	
	private static final long serial = 931283123121923L;
	
	private int numLinhas;
	private int numColunas;
	private Celula[][] matrizFolha;
	
	
	public Matriz(int numLinhas, int numColunas){
		this.numLinhas=numLinhas;
		this.numColunas=numColunas;
		this.matrizFolha=new Celula[numLinhas+1][numColunas+1];
		for (int i=0; i<=this.numLinhas; i++){
			for (int p=0; p<=this.numColunas; p++){
				this.matrizFolha[i][p] = new Celula(i,p);
			}
		}
	}
	
	public Matriz(){
		this.matrizFolha=null;
	}
	
	public Matriz iniciaMatrizDefinida(int numLinhas, int numColunas){
		Matriz matrizFolha = new Matriz(numLinhas,numColunas);
		return matrizFolha;
	}
	
	public void insereConteudo(int linha, int coluna, Conteudo cont){
		this.matrizFolha[linha][coluna].insereConteudo(cont);
	}
	
	public void insereMatriz(int linha, int coluna, Conteudo cont){
		this.matrizFolha[linha][coluna].insereConteudo(cont);
	}
	
	public void apagaMatriz(int linha, int coluna){
		this.matrizFolha[linha][coluna].apagaConteudo();
	}
	
	public Conteudo copia(int linha, int coluna){
		return this.matrizFolha[linha][coluna].copiaConteudo();
	}
	
	public void cola(int linha, int coluna, Conteudo cont){
		this.matrizFolha[linha][coluna].colaConteudo(cont);
	}
	
	public int maxLinhas(){
		return this.numLinhas;
	}
	
	public int maxColunas(){
		return this.numColunas;
	}
	
	public Celula getCelula(int numLinha, int numColuna){
		return this.matrizFolha[numLinha][numColuna];
	}	
}
