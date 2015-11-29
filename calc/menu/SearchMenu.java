package calc.menu;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import calc.textui.search.MenuEntry;
import calc.textui.Calc;

import calc.menu.searchMenu.*;

public class SearchMenu extends Menu{
	
	public SearchMenu(Calc f){
		super(MenuEntry.TITLE, new Command<?>[] {
			new SearchValue(f),
			new SearchFunction(f)
		});
	}
}
