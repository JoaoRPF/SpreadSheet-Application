package calc.core;

/**
 * Class FuncaoBinaria allows to calculate functions that receive
 * only two arguments (an integer or a reference to another cell)
 *
 *@author Joao Ferreira
 */
public abstract class FuncaoBinaria extends Funcao{
	
	/** Function name */
	public String funcao;
	
	/** First argument of the function */
	public Argumento argumento1;
	
	/** Second argument of the function */
	public Argumento argumento2;
	
	/**
	 * Gives one name to function.
	 * 
	 * @param funcao
	 * 				function name
	 */
	public void setFuncao(String funcao){
		this.funcao=funcao;
	}
	
	/**
	 * Returns the function name.
	 * 
	 * @return the function name.
	 */
	public String getFuncao(){
		return this.funcao;
	}
	
	/**
	 * Returns the result of the realization of the function
	 * It returns null or an integer
	 * 
	 * @return the result of the realization of the function
	 */
	public Integer getConteudo(){
		return calcula();
	}
	
	/**
	 * Returns the function in a string.
	 * 
	 * @return the function in a string.
	 */
	@Override
	public String toString(){
		String argAuxiliar1 = this.argumento1.toString();
		String argAuxiliar2 = this.argumento2.toString();
		if (argAuxiliar1.contains("=")){
			String[] dadosA = argAuxiliar1.split("=");
			argAuxiliar1 = dadosA[1];
		}
		
		if (argAuxiliar2.contains("=")){
			String[] dadosB = argAuxiliar2.split("=");
			argAuxiliar2 = dadosB[1];
		}
		if (calcula()==null)
			return "#VALUE"+"="+this.funcao+"("+argAuxiliar1+","+argAuxiliar2+")";
		else
			return calcula()+"="+this.funcao+"("+argAuxiliar1+","+argAuxiliar2+")";
	}
}
