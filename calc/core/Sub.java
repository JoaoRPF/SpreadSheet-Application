package calc.core;

/**
 * Class Sub makes the subtraction of two arguments
 *
 *@author Joao Ferreira
 */
public class Sub extends FuncaoBinaria{

	private static final long serial=93182316273126L;
	
	/**
	 * Constructor.
	 * 
	 * @param funcao
	 *            	function name
	 * @param arg1
	 *				first argument of the function
	 * @param arg2
	 *				second argument of the function
	 */
	public Sub(String funcao,Argumento arg1, Argumento arg2){
		this.argumento1 = arg1;
		this.argumento2 = arg2;
		this.funcao=funcao;
	}
	
	/**
	 * Performs a subtraction
	 * 
	 * @return null
	 * 				if one of the arguments is null
	 *  
	 * @return resultado
	 *          	if it is possible to make the subtraction
	 */
	@Override
	public Integer calcula(){
		if (this.argumento1.getValue() == null || this.argumento2.getValue() == null)
			return null;
		else{
			int resultado=this.argumento1.getValue()-(this.argumento2.getValue());
			return resultado;
		}
	}
}
