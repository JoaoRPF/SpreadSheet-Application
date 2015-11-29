package calc.menu.mainMenu;

import calc.core.FolhaCalculo;

import calc.textui.main.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

public class New extends Command<Calc>{
	
	public New(Calc folha){
		super(MenuEntry.NEW, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f1 = new Form(title());
		InputString salva = new InputString(f1, Message.saveBeforeExit());
		f1.parse();
		if (salva.value().contains("s")){
			try{
				if(entity().getFolha().getNomeFolha() == null)
					menu().entry(2).execute();
			}
			catch (InvalidOperation io){
				io.printStackTrace();
			}
		}
		
		Form f2 = new Form(title());
		InputInteger numLinhas = new InputInteger(f2,Message.linesRequest());
		InputInteger numColunas = new InputInteger(f2,Message.columnsRequest());
		f2.parse();
		int linhas = numLinhas.value();
		int colunas = numColunas.value();
		entity().setFolha(new FolhaCalculo(linhas,colunas));
		
		int i;
		for(i=2;i<=5;i++){
			menu().entry(i).visible();
		}
	}	
}
