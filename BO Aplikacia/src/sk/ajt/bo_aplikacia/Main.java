package sk.ajt.bo_aplikacia;

import java.util.Scanner;

/**
 * <h1>Trieda Main</h1>
 * <p>
 *    Hlavna trieda aplikacie.
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
public class Main 
{
	/* konstanty */
	private static final String TEXT_NAZOV_BANKY = "ZUNO Bank AG";
	private static final String TEXT_VSTUP_OD_POUZIVATELA = "Vasa volba: ";
	private static final String TEXT_NEEXISTUJUCA_VOLBA = "NEEXISTUJUCA VOLBA!\n";
	private static final String TEXT_OBRAZOVKA_DOMOV =
			  "+------------------------------------------------------------------+\n"
			+ "|                       Vitajte v BO Aplikacii                     |\n"
			+ "|                                                                  |\n"
			+ "|                            ZUNO Bank AG                          |\n"
			+ "|                                                                  |\n"
			+ "+------------------------------------------------------------------+\n"
			+ "Prosim vyberte jednu z nizsie uvedenych moznosti:                   \n"
			+ "1) Zalozenie noveho uctu                                            \n"
			+ "2) Vytvor vklad                                                     \n"
			+ "3) Vytvor vyber                                                     \n"
			+ "4) Vypis info o ucte                                                \n"
			+ "0) Koniec                                                           \n";

	public static void main(String[] args) 
	{
		/* lokalne premenne */
		Banka banka = new Banka(TEXT_NAZOV_BANKY);
		Menu menu = new Menu(banka);
		byte stav;
		Scanner vstup;
		byte volba;
		
		/* cyklus zabezpecujuci chod menu */
		while(true) 
		{
			stav = menu.getStav();
			
			/* na zaklade stavu, v akom sa menu nachadza, zobrazi jeho dostupne volby */
			if (stav == Menu.DOMOV) 
			{
				System.out.print(TEXT_OBRAZOVKA_DOMOV);
				System.out.print(TEXT_VSTUP_OD_POUZIVATELA);
				vstup = new Scanner(System.in);
				
				/* kontroluje, ci zadana volba na vstupe je cele cislo */
				if (vstup.hasNextByte()) 
				{
					volba = vstup.nextByte();
					
					/* kontroluje, ci zadana volba na vstupe sa zhoduje s moznostami v menu */
					if (volba == 1) 
					{
						// TODO: pokracovat/doprogramovat
						System.out.println("ok");
						break;
					}
					else 
					{
						System.out.println(TEXT_NEEXISTUJUCA_VOLBA);
					}
				}
				else 
				{
					System.out.println(TEXT_NEEXISTUJUCA_VOLBA);
				}
			}
		}
		
		vstup.close();
		System.out.println("Koniec programu");
	}

}
