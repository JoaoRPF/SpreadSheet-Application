package calc.menu.calcMenu;

import calc.core.FolhaCalculo;
import calc.core.Parser;
import calc.core.Intervalo;
import calc.core.Celula;

import calc.textui.edit.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class Delete extends Command<Calc>{
	
	public Delete(Calc folha){
		super(MenuEntry.DELETE, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString s = new InputString(f,Message.addressRequest());
		f.parse();
		int[] posicoes;
		
		try{
			posicoes=Parser.parseTipo(s.value());
		
			if (posicoes.length == 4){
				Intervalo intervalo = new Intervalo (posicoes,entity().getFolha().getMatriz());
				for(Celula celula : intervalo.getIntervalo())
					entity().getFolha().getMatriz().apagaMatriz(celula.getLinha(),celula.getColuna());
			}
			else
				entity().getFolha().getMatriz().apagaMatriz(posicoes[0],posicoes[1]);
		}
		catch(Exception e){
			throw new InvalidCellRange(s.value());		
		}
	}
}
