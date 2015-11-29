package calc.menu.mainMenu;

import calc.menu.SearchMenu;

import calc.textui.main.*;
import calc.textui.Calc;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;

public class OpenSearchMenu extends Command<Calc>{
	
	public OpenSearchMenu(Calc folha){
		super(MenuEntry.MENU_SEARCH, folha);
	}
	
	public final void execute(){
		Menu menu=new SearchMenu(entity());
		menu.open();
	}	
}
