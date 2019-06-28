package shortcutmanager;

import shortcutmanager.Shortcut.Applications;
import shortcutmanager.Shortcut.ChromeShortcuts;

public class Tester {
	
	public static void main(String[] args) {
		Shortcut.launchApplication(Applications.CHROME);
		try {
			Thread.sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		Shortcut.chromeShortcut(ChromeShortcuts.CLOSE_TAB);
	}

}
