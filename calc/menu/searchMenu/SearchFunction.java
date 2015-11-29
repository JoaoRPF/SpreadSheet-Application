package calc.menu.searchMenu;

import calc.core.FolhaCalculo;
import calc.core.Parser;

import calc.textui.search.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;


public class SearchFunction extends Command<Calc>{
	
	public SearchFunction(Calc folha){
		super(MenuEntry.SEARCH_FUNCTIONS, folha);
	}
	
	public final void execute(){
		Display d= new Display(title());
		Form f = new Form(title());
		InputString s = new InputString(f, Message.searchFunction());
		f.parse();
		int limiteLinha = entity().getFolha().getMatriz().maxLinhas();
		int limiteColuna = entity().getFolha().getMatriz().maxColunas();
		
		for (int i=1; i<=limiteLinha; i++){
			for(int p=1; p<=limiteColuna; p++){
				if(entity().getFolha().getMatriz().getCelula(i,p).getConteudo()!=null){
					String cont=entity().getFolha().getMatriz().getCelula(i,p).getConteudo().toString();
					String contFinal=Parser.parseValorFuncao(cont);
					if(contFinal.equals(s.value()))
							d.addNewLine(i+";"+p+"|"+cont);
				}
			}
		}
		d.display();
	}	
}
