package shortcutmanager;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Shortcut {

	private static Robot typer;

	static {
		try {
			typer = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Performs given shortcut on Windows platform
	 * @param shortcut Shortcut to be performed 
	 */
	public static void windowsShortcut(WindowsShortcuts shortcut) {
		switch (shortcut) {
		case SWITCH_WINDOWS:
			pressRelease(KeyEvent.VK_ALT, KeyEvent.VK_TAB);
			break;
		case MAXIMIZE_WINDOW:
			pressRelease(KeyEvent.VK_WINDOWS, KeyEvent.VK_UP);
			break;
		case MINIMIZE_WINDOW:
			pressRelease(KeyEvent.VK_WINDOWS, KeyEvent.VK_DOWN);
			break;
		case CLOSE_WINDOW:
			pressRelease(KeyEvent.VK_ALT, KeyEvent.VK_F4);
			break;
		case RUN_MENU:
			pressRelease(KeyEvent.VK_WINDOWS, KeyEvent.VK_R);
			break;
		case FILE_EXPLORER:
			pressRelease(KeyEvent.VK_WINDOWS, KeyEvent.VK_E);
			break;
		case TASK_MANAGER:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_ESCAPE);
			break;
		case TASK_VIEW:
			pressRelease(KeyEvent.VK_WINDOWS, KeyEvent.VK_TAB);
		}
	}

	/**
	 * Performs the given Google Chrome shortcut
	 * 
	 * @param shortcut Shortcut to be performed
	 */
	public static void chromeShortcut(ChromeShortcuts shortcut) {
		switch (shortcut) {
		case NEW_TAB:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_T);
			break;
		case CLOSE_TAB:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_W);
			break;
		case NEW_WINDOW:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_N);
			break;
		case CLOSE_WINDOW:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_W);
			break;
		case REOPEN_TAB:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_T);
			break;
		case REFRESH:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_R);
			break;
		case HISTORY:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_H);
			break;
		case DOWNLOADS:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_J);
			break;
		case SELECT_ALL:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
			break;
		case FIND:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_F);
			break;
		case TOGGLE_BOOKMARKS:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case SAVE_PAGE:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_S);
			break;
		case PRINT_PAGE:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_P);
			break;
		case SOURCE_CODE:
			pressRelease(KeyEvent.VK_CONTROL, KeyEvent.VK_U);
			break;
		case PAGE_FORWARD:
			pressRelease(KeyEvent.VK_ALT, KeyEvent.VK_RIGHT);
			break;
		case PAGE_BACKWARD:
			pressRelease(KeyEvent.VK_ALT, KeyEvent.VK_LEFT);
			break;
		}

	}

	/**
	 * Types the given string
	 * 
	 * @param stringToType String to be typed
	 */
	public static void type(String stringToType) {
		for (int i = 0; i < stringToType.length(); i++) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(stringToType.charAt(i));
			pressRelease(keyCode);
		}
	}

	/**
	 * Sequentially presses all given keys and then sequentially releases them
	 * 
	 * @param keyCodes KeyCodes of the keys to be pressed and released
	 */
	public static void pressRelease(int... keyCodes) {
		for (int i = 0; i < keyCodes.length; i++) {
			typer.keyPress(keyCodes[i]);
		}
		for (int i = 0; i < keyCodes.length; i++) {
			typer.keyRelease(keyCodes[i]);
		}
	}
	
	/**
	 * Launches the given application
	 * @param application Application to be launched
	 */
	public static void launchApplication(Applications application) {
		ProcessBuilder processBuilder = null;
		switch(application) {
		case CHROME:
			processBuilder = new ProcessBuilder("\"/Program Files (x86)/Google/Chrome/Application/chrome.exe\"");
			break;
		case MICROSOFT_EDGE:
			break;
		case ECLIPSE:
			break;
		case FILE_EXPLORER:
			break;
		case CALCULATOR:
			break;
		case NOTEPAD:
			break;
		}
		try {
			processBuilder.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static enum WindowsShortcuts {
		SWITCH_WINDOWS, MAXIMIZE_WINDOW, MINIMIZE_WINDOW, CLOSE_WINDOW, RUN_MENU, FILE_EXPLORER, TASK_MANAGER, TASK_VIEW
	}

	public static enum ChromeShortcuts {
		NEW_TAB, CLOSE_TAB, NEW_WINDOW, CLOSE_WINDOW, REOPEN_TAB, REFRESH, HISTORY, DOWNLOADS, SELECT_ALL, FIND,
		TOGGLE_BOOKMARKS, SAVE_PAGE, PRINT_PAGE, SOURCE_CODE, PAGE_FORWARD, PAGE_BACKWARD
	}

	public static enum Applications {
		CHROME, MICROSOFT_EDGE, ECLIPSE, FILE_EXPLORER, CALCULATOR, NOTEPAD
	}

}
