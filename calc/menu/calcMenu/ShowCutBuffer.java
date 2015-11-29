package calc.menu.calcMenu;

import calc.core.FolhaCalculo;
import calc.core.Parser;
import calc.core.Intervalo;
import calc.core.Celula;
import calc.core.Conteudo;

import calc.textui.edit.*;
import calc.textui.Calc;

import java.util.ArrayList;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class ShowCutBuffer extends Command<Calc>{
	
	public ShowCutBuffer(Calc folha){
		super(MenuEntry.SHOW_CUT_BUFFER, folha);
	}
	
	public final void execute(){
		
		int inicioLinha=1;
		int inicioColuna=1;
		int posicao=0;
		int passa=0;
		
		Display d = new Display(title());
		Display disp = new Display(title());
		
		ArrayList <Conteudo> vetor = new ArrayList<Conteudo>();
		
		vetor = entity().getFolha().getBuffer().getBuffer();
		
		
		if(vetor.isEmpty()){
			d.display();
		}
		else{

			int tamanho = vetor.size();
			if (tamanho>1){
				if (vetor.get(0).getCelula().getLinha() == vetor.get(1).getCelula().getLinha()){
					while(inicioColuna<=tamanho){
						d.add(inicioLinha+";"+inicioColuna+"|");
						if (entity().getFolha().getBuffer().getVetor(posicao)!=null){
							d.add(entity().getFolha().getBuffer().getVetor(posicao).toString());
							passa++;
						}
						if(inicioColuna!=tamanho)
							d.addNewLine("");
						inicioColuna++;
						posicao++;
					}
				}
				else{
					while(inicioLinha<=tamanho){
						d.add(inicioLinha+";"+inicioColuna+"|");
						if (entity().getFolha().getBuffer().getVetor(posicao)!=null){
							d.add(entity().getFolha().getBuffer().getVetor(posicao).toString());
							passa++;
						}
						if(inicioLinha!=tamanho)
							d.addNewLine("");
						inicioLinha++;
						posicao++;
					}
				}
			}
			else{
				d.add(inicioLinha+";"+inicioColuna+"|");
				if (entity().getFolha().getBuffer().getVetor(posicao)!=null){
					d.add(entity().getFolha().getBuffer().getVetor(0).toString());
					passa++;
				}
			}
			if (passa==0)
				disp.display();
				
			if (passa>0)
				d.display();
		}
	}	
}
