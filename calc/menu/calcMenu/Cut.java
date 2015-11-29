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

public class Cut extends Command<Calc>{
	
	public Cut(Calc folha){
		super(MenuEntry.CUT, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString gama = new InputString(f,Message.addressRequest());
		f.parse();
		Conteudo cont;
		int[] posicoes;
		
		try{
			posicoes = Parser.parseTipo(gama.value());
			int tamanho = posicoes.length;
			entity().getFolha().getBuffer().eliminaVetor();
		
			if(tamanho==4){
				Intervalo intervalo = new Intervalo(posicoes,entity().getFolha().getMatriz());
				for(Celula celula : intervalo.getIntervalo()){
					cont = entity().getFolha().getMatriz().copia(celula.getLinha(),celula.getColuna());
					entity().getFolha().getBuffer().insereVetor(cont);
				}
				for(Celula celula : intervalo.getIntervalo())
					entity().getFolha().getMatriz().apagaMatriz(celula.getLinha(),celula.getColuna());
			}
			else{
				cont = entity().getFolha().getMatriz().copia(posicoes[0],posicoes[1]);
				entity().getFolha().getBuffer().insereVetor(cont);
				entity().getFolha().getMatriz().apagaMatriz(posicoes[0],posicoes[1]);
			}
		}
		catch(Exception e){
			throw new InvalidCellRange(gama.value());
		}
	}
}
