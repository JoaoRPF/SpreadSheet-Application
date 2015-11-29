package calc.core;

public class Referencia extends Conteudo implements Argumento{
	
	private static final long serial=42129995183812L;
	
	private int numLinha;
	private int numColuna;
	private FolhaCalculo fc;
		
	public Referencia(FolhaCalculo fc, int[] posicao){

		this.fc=fc;
		this.numLinha = posicao[0];
		this.numColuna = posicao[1];
	}
	
	public Referencia (String cont){
		int[] posicao=Parser.parseEndereco(cont);
		this.numLinha=posicao[0];
		this.numColuna=posicao[1];
	}
		
	public String toString(){
		Celula celula=fc.getMatriz().getCelula(this.numLinha,this.numColuna);
		
		if(celula.CelulaVazia() || calcula() == null)
			return "#VALUE="+this.numLinha+";"+this.numColuna;
		
		else
			return calcula()+"="+this.numLinha+";"+this.numColuna;
	}
		
	public Integer getConteudo(){
		return calcula();
	}
		
	public Integer calcula(){
		if (fc.getMatriz().getCelula(this.numLinha,this.numColuna).getConteudo() == null)
			return null;
		else
			return fc.getMatriz().getCelula(this.numLinha,this.numColuna).getConteudo().getConteudo();
	}
	
	public Integer getValue(){
		return getConteudo();
	}
}
