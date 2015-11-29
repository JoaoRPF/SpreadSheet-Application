package calc.menu;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import calc.textui.edit.MenuEntry;
import calc.textui.Calc;

import calc.menu.calcMenu.*;

public class CalcMenu extends Menu{
	
	public CalcMenu(Calc f){
		super(MenuEntry.TITLE, new Command<?>[] {
			new Show(f),
			new Insert(f),
			new Copy(f),
			new Delete(f),
			new Cut(f),
			new Paste(f),
			new ShowCutBuffer(f)
		});
	}
}
