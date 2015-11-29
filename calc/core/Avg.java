package calc.core;

/**
 * Class Avg represents the average of all elements in the range
 *
 *@author Joao Ferreira
 */
public class Avg extends FuncaoIntervalo{
	
	private static final long serial=93128319231812L;
	
	/**
	 * Constructor.
	 * 
	 * @param funcao
	 *            	function name
	 * @param intervalo
	 *				string with the interval
	 * @param matriz
	 *				matrix for the creation of a new interval
	 */
	public Avg(String funcao, String intervalo, Matriz matriz){
		this.intervalo=intervalo;
		this.funcao=funcao;
		this.matriz=matriz;
	}

	/**
	 * Performs an addition of all elements in the range and
	 * divide it by the number of elements
	 * 
	 * @return null 
	 * 				if one cell in the range has a null content
	 *  
	 * @return resultadoFinal
	 *          	if it is possible to make the average
	 */
	public Integer calcula(){
		int[] posicoes = Parser.parseIntervalo(this.intervalo);
		Intervalo inter = new Intervalo (posicoes,this.matriz);
		
		int resultado=0;
		int vezesCalcula=0;
		
		for(Celula celula : inter.getIntervalo()){
			if (celula.getConteudo() == null){
				return null;
			}
			else{
				String conteudo = celula.getConteudo().toString();
				String conteudoAuxiliar = Parser.parseValor(conteudo);
				int conteudoFinal = Integer.parseInt(conteudoAuxiliar);
				vezesCalcula++;
				resultado=resultado+conteudoFinal;
			}
		}
		int resultadoFinal = resultado/vezesCalcula;
		return resultadoFinal;
	}
}
