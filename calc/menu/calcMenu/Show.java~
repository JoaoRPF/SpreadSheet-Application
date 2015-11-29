package calc.menu.calcMenu;

import calc.core.FolhaCalculo;
import calc.core.Parser;
import calc.core.Intervalo;
import calc.core.Celula;

import calc.textui.edit.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class Show extends Command<Calc>{
	
	public Show(Calc folha){
		super(MenuEntry.SHOW, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString s = new InputString(f,Message.addressRequest());
		f.parse();
		int[] posicoes;
		try{
			posicoes=Parser.parseTipo(s.value());
			if(posicoes.length==4){
				Intervalo intervalo = new Intervalo(posicoes,entity().getFolha().getMatriz());
				for(Celula celula : intervalo.getIntervalo()){
					Display d = new Display(title());
					d.add(celula.getLinha()+";"+celula.getColuna()+"|");
					if(entity().getFolha().getMatriz().getCelula(celula.getLinha(),celula.getColuna()).getConteudo()!=null)
						d.add(entity().getFolha().getMatriz().getCelula(celula.getLinha(),celula.getColuna()).getConteudo().toString());
				
					d.display();
				}
			}
			else{
				Display d = new Display(title());
				d.add(posicoes[0]+";"+posicoes[1]+"|");
				if(entity().getFolha().getMatriz().getCelula(posicoes[0],posicoes[1]).getConteudo() != null)
					d.add(entity().getFolha().getMatriz().getCelula(posicoes[0],posicoes[1]).getConteudo().toString());
			
				d.display();
			}
		}
		catch(Exception e){
			throw new InvalidCellRange(s.value());
		}
	}
}
