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


public class Copy extends Command<Calc>{
	
	public Copy(Calc folha){
		super(MenuEntry.COPY, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString gama = new InputString(f,Message.addressRequest());
		f.parse();
		Conteudo cont;
		int[] posicoes;
		
		try{
			posicoes=Parser.parseTipo(gama.value());
			int tamanho = posicoes.length;
			entity().getFolha().getBuffer().eliminaVetor();
		
			if(tamanho==4){
				Intervalo intervalo = new Intervalo(posicoes,entity().getFolha().getMatriz());
				for(Celula celula : intervalo.getIntervalo()){
					cont = entity().getFolha().getMatriz().copia(celula.getLinha(),celula.getColuna());
					entity().getFolha().getBuffer().insereVetor(cont);
				}
			}
			else{
				cont = entity().getFolha().getMatriz().copia(posicoes[0],posicoes[1]);
				entity().getFolha().getBuffer().insereVetor(cont);	
			}
		}
		catch(Exception e){
			throw new InvalidCellRange(gama.value());
		}
	}
}
