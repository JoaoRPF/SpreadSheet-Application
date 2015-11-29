package calc.menu.mainMenu;

import calc.menu.CalcMenu;

import calc.textui.main.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

public class OpenCalcMenu extends Command<Calc>{
	
	public OpenCalcMenu(Calc folha){
		super(MenuEntry.MENU_CALC, folha);
	}
	
	public final void execute(){
		Menu menu=new CalcMenu(entity());
		menu.open();
	}	
}
