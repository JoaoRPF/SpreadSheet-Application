package calc.core;

/**
 * Class Prd represents the multiplication of all elements in the range
 *
 *@author Joao Ferreira
 */
public class Prd extends FuncaoIntervalo{

	private static final long serial=7312316231281L;

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
	public Prd(String funcao, String intervalo, Matriz matriz){
		this.intervalo=intervalo;
		this.funcao=funcao;
		this.matriz=matriz;
	}

	/**
	 * Performs a multiplication of all elements in the range
	 * 
	 * @return null 
	 * 				if one cell in the range has a null content
	 *  
	 * @return resultadoFinal
	 *          	if it is possible to make the multiplication 
	 *				of all elements
	 */
	public Integer calcula(){
		int[] posicoes = Parser.parseIntervalo(this.intervalo);
		Intervalo inter = new Intervalo (posicoes,this.matriz);
		
		int resultadoFinal=1;
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
				resultadoFinal=resultadoFinal*conteudoFinal;
			}
		}
		return resultadoFinal;
	}
}
