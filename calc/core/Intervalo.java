package calc.core;

import java.io.Serializable;

import java.util.ArrayList;

public class Intervalo implements Serializable{

	private static final long serial=38183123183812L;
	
	private ArrayList<Celula> intervalo = new ArrayList<Celula>();
	private Matriz matriz;
	
	public Intervalo(int[] posicoes, Matriz matriz){
		String direcao="linha igual"; 
		int comeco = 1; 
		int acaba = 1; 
		int igual=-1;
		int l1 = posicoes[0];
		int c1 = posicoes[1];
		int l2 = posicoes[2];
		int c2 = posicoes[3];
		this.matriz = matriz;
		
		if(l1 == l2){
			if(c1 < c2){
				comeco=c1;
				acaba=c2;
			}
			else{
				comeco=c2;
				acaba=c1;
			}
			igual=l1;
		}
		else{
			if(c1==c2){
				if(l1<l2){
					comeco=l1;
					acaba=l2;
				}
				else{
					comeco=l2;
					acaba=l1;
				}
				direcao="coluna igual";
				igual=c1;
			}
			
		}
		if(direcao=="coluna igual"){
			for(int i=comeco; i<=acaba;i++)
				this.intervalo.add(getMatriz().getCelula(i,igual));
		}
		if(direcao=="linha igual"){
			for(int i=comeco; i<=acaba; i++)
				this.intervalo.add(getMatriz().getCelula(igual,i));
		}	
	}
	
	public ArrayList<Celula> getIntervalo(){
		return this.intervalo;
	}
	
	public Matriz getMatriz(){
		return this.matriz;
	}
}
