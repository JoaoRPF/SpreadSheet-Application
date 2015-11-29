package calc.menu.mainMenu;

import calc.core.FolhaCalculo;

import calc.textui.main.*;
import calc.textui.Calc;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class SaveAs extends Command<Calc>{
	
	public SaveAs(Calc folha){
		super(MenuEntry.SAVE_AS, folha);
	}
	
	public final void execute() throws InvalidOperation{
	Form f = new Form(title());
	InputString ficheiro = new InputString (f,Message.saveAs());
	f.parse();
	String novoFicheiro = ficheiro.value();
	entity().getFolha().setNomeFolha(novoFicheiro);
	if (novoFicheiro!=null)
		try{
			entity().getFolha().save(novoFicheiro);
		}
		catch(IOException exc){
			throw new InvalidOperation(exc.toString());
		}
	}	
}
