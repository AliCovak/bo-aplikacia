package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda Menu</h1>
 * <p>
 *    Popis
 * </p>
 * <h2>obsahuje:</h2>  
 *    <ul>
 *       <li></li>
 *       <li></li>
 *    </ul>
 * <h2>zodpoveda za:</h2>
 * <ul>
 *       <li></li>
 *       <li></li>
 * </ul>
 */
public class Menu 
{
	/* konstanty */
	public static final byte DOMOV = 1;
	
	/* premenne */
	private Banka banka;
	private byte stav;
	
	/**
	 * Vytvori "Menu" danej banky.
	 * 
	 * @param banka konkretna banka
	 */
	public Menu(Banka banka) 
	{
		this.banka = banka;
		stav = DOMOV;
	}
	
	/**
	 * Vracia celociselnu hodnotu, v akom stave sa "Menu" aplikacie nachadza.
	 * 
	 * @return celociselnu hodnotu, v akom stave sa "Menu" aplikacie nachadza
	 */
	public byte getStav() 
	{
		return stav;
	}
	
}
