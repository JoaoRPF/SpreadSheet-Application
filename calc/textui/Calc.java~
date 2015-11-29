package calc.textui;

import calc.core.FolhaCalculo;
import calc.core.Parser;

import calc.menu.MainMenu;

import java.io.IOException;

import pt.utl.ist.po.ui.Menu;

public class Calc {

	private FolhaCalculo fc;
	
	public Calc(){
		this.fc = new FolhaCalculo();
	}
	
	public FolhaCalculo getFolha(){
		return this.fc;
	}
	
	public void setFolha(FolhaCalculo fc){
		this.fc = fc;
	}
	
	public static void main(String args[]) throws IOException {
		Calc aplicacao = new Calc();
		
		
		String filename = System.getProperty("import"); 
		if (filename != null){
			aplicacao.setFolha(Parser.parseFile(filename));
		}
		Menu menu = new MainMenu(aplicacao);
		
		if (filename == null){
			int i;
			for(i=2;i<=5;i++){
				menu.entry(i).invisible();
			}
		}
		
		menu.open();
	}
}
