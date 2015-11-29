package calc.core;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Parser {
    

    public static FolhaCalculo parseFile(String nomeFicheiro) throws IOException, FileNotFoundException {
	BufferedReader reader = null;

	try {
	    reader = new BufferedReader(new FileReader(nomeFicheiro));
	    String linha;
	    int linhas, colunas;
	    String[] args;
	    
	    linha = reader.readLine();
	    args = linha.split("=");
	    linhas = Integer.parseInt(args[1]);
	    
	    linha = reader.readLine();
	    args = linha.split("=");
	    colunas = Integer.parseInt(args[1]);
	    
	    FolhaCalculo folha = new FolhaCalculo(linhas,colunas);
	    
	    while ((linha = reader.readLine()) != null) {
		parseExpressao(folha, linha);
	    }
	    
	    return folha;
	} finally {
	    if (reader != null)
		reader.close();
		}
    }

    public static void parseExpressao(FolhaCalculo folha, String expressao) {
	String[] args = expressao.split("\\|");
	int[] endereco = parseEndereco(args[0]);
	Conteudo cont = null;

	if (args.length > 1)
	    cont = parseConteudo(folha, args[1]);
	
	folha.getMatriz().insereConteudo(endereco[0], endereco[1], cont);
    }

    public static int[] parseEndereco(String endereco) {
		String[] args = endereco.split(";");
		int[] vec = {Integer.parseInt(args[0]), Integer.parseInt(args[1])};
		return vec;
    }

    public static Conteudo parseConteudo(FolhaCalculo folha, String conteudo) {
		if (conteudo.contains("(")) { // é uma função
	    	String funcao = conteudo.substring(1);
	    	String nomeFuncao = parseNomeFuncao(funcao);
	    	String argumento = parseArgumentoFuncao(funcao);

	    if (conteudo.contains(","))
			return parseFuncaoBinaria(folha, nomeFuncao, argumento);
	    else
			return parseFuncaoIntervalo(folha, nomeFuncao, argumento); /* e funcao intervalo*/
		} 
		
		else if (conteudo.contains("=")) {
	    	return parseReferencia(folha, conteudo.substring(1));
		}
	
		else
	    	return parseLiteral(conteudo);
    }

    private static String parseNomeFuncao(String funcao) {
		return funcao.substring(0, funcao.indexOf("("));
    }

    private static String parseArgumentoFuncao(String funcao) {
		return funcao.substring(funcao.indexOf("(") + 1, funcao.indexOf(")"));
    }

    public static FuncaoBinaria parseFuncaoBinaria(FolhaCalculo folha, String nomeFuncao, String argumento) {
		String[] argumentos = argumento.split(",");

		Argumento arg1 = parseArgumento(folha, argumentos[0]);
		Argumento arg2 = parseArgumento(folha, argumentos[1]);
		

		switch(nomeFuncao) {
		case "MUL":
	    	return new Mul(nomeFuncao,arg1,arg2);
		case "DIV":
	    	return new Div(nomeFuncao,arg1,arg2);
		case "SUB":
	    	return new Sub(nomeFuncao,arg1,arg2);
		case "ADD":
	    	return new Add(nomeFuncao,arg1, arg2);
		}
	
		return null;
    }
    
    public static FuncaoIntervalo parseFuncaoIntervalo(FolhaCalculo folha, String funcao, String intervalo){
    	switch(funcao){
    		case "PRD":
    			return new Prd(funcao,intervalo,folha.getMatriz());
    		case "AVG":
    			return new Avg(funcao,intervalo,folha.getMatriz());
    	}
   		return null;
    }
    		
    
    public static Referencia parseReferencia(FolhaCalculo folha, String ref){
    	int[] posicao = parseEndereco(ref);
    	return new Referencia(folha,posicao);
    }
    
    public static String parseValor(String conteudo){
    	if(conteudo.contains("=")){
    		String[] cont = conteudo.split("=");
    		String resposta = cont[0];
    		return resposta;
    	}
    	else	
    		return conteudo;
    }
    
    public static String parseValorFuncao(String conteudo){
    	if (conteudo.contains("=")){
    		String[] cont = conteudo.split("=");
    		String resposta = cont[1];
    		if(resposta.contains("(")){
    			String[] respostaAux = resposta.split("\\(");
    			String respostaFinal = respostaAux[0];
    			return respostaFinal;
    		}
    		else
    			return resposta;
    	}
    	else
    		return conteudo;
    }
    
    public static ValorLiteral parseLiteral(String literal){
    	return new ValorLiteral(literal);
    }
    
    public static Argumento parseArgumento(FolhaCalculo folha, String argumento){
    	if(argumento.contains(";"))
    		return parseReferencia(folha,argumento);
    	return parseLiteral(argumento);
    }
    
    public static int[] parseTipo(String posicao){
    	int[] resultado;
    	if(posicao.contains(":")){
    		resultado=parseIntervalo(posicao);
    		return resultado;
    	}
    	else{
    		resultado=parseEndereco(posicao);
    		return resultado;
    	}
    }
    
    public static int[] parseIntervalo(String posicao){
    	String[] posicoes = posicao.split(":");
    	int[] posicoesA = parseEndereco(posicoes[0]);
    	int[] posicoesB = parseEndereco(posicoes[1]);
    	int[] resultado = {posicoesA[0],posicoesA[1],posicoesB[0],posicoesB[1]};
    	return resultado;
    }
}
