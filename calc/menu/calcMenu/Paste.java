package calc.menu.calcMenu;

import calc.textui.edit.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.InputString;

public class Paste extends Command<Calc>{
	
	public Paste(Calc folha){
		super(MenuEntry.PASTE, folha);
	}
	
	public final void execute() throws InvalidOperation{
		Form f = new Form(title());
		InputString gama = new InputString(f,Message.addressRequest());
		f.parse();
	}
}
