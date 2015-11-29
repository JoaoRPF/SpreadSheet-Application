package calc.menu.calcMenu;

import calc.core.FolhaCalculo;
import calc.core.Parser;
import calc.core.Intervalo;
import calc.core.Celula;
import calc.core.Conteudo;

import calc.textui.edit.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class Insert extends Command<Calc>{
	
	
	public Insert(Calc folha){
		super(MenuEntry.INSERT, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString s = new InputString(f,Message.addressRequest());
		InputString cont = new InputString(f,Message.contentsRequest());
		f.parse();
		Conteudo cont2;
		int[] posicoes;
		try{
			posicoes = Parser.parseTipo(s.value());
			if(posicoes.length==4){
				if(posicoes[0] == posicoes[2] || posicoes[1] == posicoes[3]){
					Intervalo intervalo = new Intervalo(posicoes,entity().getFolha().getMatriz());
					for(Celula celula : intervalo.getIntervalo()){
						cont2 = Parser.parseConteudo(entity().getFolha(), cont.value());
						entity().getFolha().getMatriz().insereMatriz(celula.getLinha(),celula.getColuna(),cont2);
					}
				}
			}	 

			else{
				cont2=Parser.parseConteudo(entity().getFolha(),cont.value());
				entity().getFolha().getMatriz().insereMatriz(posicoes[0],posicoes[1],cont2);
			}
		}
		catch(Exception e){
			throw new InvalidCellRange(s.value());
		}
	}
}
