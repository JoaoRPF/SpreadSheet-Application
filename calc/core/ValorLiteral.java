package calc.core;

public class ValorLiteral extends Conteudo implements Argumento{
	
	private static final long serial = 913812131238123812L;
	
	private int literal;
	
	public ValorLiteral(String literal){
		this.literal = Integer.parseInt(literal);
	}
	
	public Integer getConteudo(){
		return this.literal;
	}
	
	public Integer getValue(){
		return getConteudo();
	}
	
	public String toString(){
		return ""+this.literal;
	}
}
