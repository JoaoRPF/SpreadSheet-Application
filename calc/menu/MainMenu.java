package calc.menu;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import calc.textui.main.MenuEntry;
import calc.textui.Calc;

import calc.menu.mainMenu.*;

public class MainMenu extends Menu{
	
	public MainMenu(Calc f){
		super(MenuEntry.TITLE, new Command<?>[] {
			new New(f),
			new Open(f),
			new Save(f),
			new SaveAs(f),
			new OpenCalcMenu(f),
			new OpenSearchMenu(f)
		});
	}
}
