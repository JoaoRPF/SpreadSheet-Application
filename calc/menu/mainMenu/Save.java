package calc.menu.mainMenu;

import calc.core.FolhaCalculo;

import calc.textui.main.*;
import calc.textui.Calc;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class Save extends Command<Calc>{
	
	public Save(Calc folha){
		super(MenuEntry.SAVE, folha);
	}
	
	public final void execute() throws InvalidOperation{
		String nomeFolha;
		if (entity().getFolha().getNomeFolha() == null){
			Form f = new Form(title());
			InputString ficheiro = new InputString (f,Message.newSaveAs());
			f.parse();
			nomeFolha = ficheiro.value();
			entity().getFolha().setNomeFolha(nomeFolha);
		}
		else
			nomeFolha = entity().getFolha().getNomeFolha();
	
		try{
			entity().getFolha().save(nomeFolha);
		}
		catch(IOException exc){
			throw new InvalidOperation(exc.toString());
		}
	}	
}
