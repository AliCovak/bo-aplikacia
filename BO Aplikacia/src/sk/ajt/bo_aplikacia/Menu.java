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
public class Menu 
{
	private final double MIN_CIASTKA_BEZNY_UCET = 100.00;
	private final double MIN_CIASTKA_SPORIACI_UCET = 50.00;
	
	private final String TEXT_NAZOV_BANKY = "ZUNO Bank AG";
	private final String TEXT_UKONCENIE = "Dakujeme vam, ze pouzivate";
	private final String TEXT_SPUSTENIE = ""
			+ "+------------------------------------------------------------------+\n"
			+ "|                       Vitajte v BO Aplikacii                     |\n"
			+ "|                                                                  |\n"
			+ "|                            ZUNO Bank AG                          |\n"
			+ "|                                                                  |\n"
			+ "+------------------------------------------------------------------+\n";
	private final String[] TEXT_MENU_DOMOV = { "Prosim vyberte jednu z nizsie uvedenych moznosti:", 
													  "1) Zalozenie noveho uctu",
													  "2) Vytvor vklad",
													  "3) Vytvor vyber",
													  "4) Vypis info o ucte",
													  "0) Koniec"
													};
	private final String TEXT_VOLBA = "Vasa volba:";
	private final String TEXT_ODDELOVAC = "======================================================================";
	private final String TEXT_ZIADNE_UCTY = "Nie su dostupne ziadne ucty";
	private final String TEXT_MENU_ZALOZENIE_NOVEHO_UCTU = "Menu - Zalozenie noveho uctu";
	private final String TEXT_MENU_VOLBA_UCTU = "Menu - Volba uctu";
	private final String TEXT_KRSTNE_MENO = "Krstne meno:";
	private final String TEXT_PRIEZVISKO = "Priezvisko:";
	private final String TEXT_RODNE_CISLO = "Rodne cislo:";
	private final String TEXT_TYP_UCTU = "O aky ucet mate zaujem (bezny alebo sporiaci)?";
	private final String TEXT_BEZNY_UCET = "bezny";
	private final String TEXT_SPORIACI_UCET = "sporiaci";
	private final String TEXT_POCIATOCNY_VKLAD = "Pociatocny vklad:";
	private final String TEXT_VKLAD_NA_UCET_OK = "Vklad na ucet bol uspesne zrealizovany. Aktualny zostatok na ucte:";
	private final String TEXT_VOLBA_2 = "Prosim vyber ucet:";
	private final String TEXT_NEDOSTATOCNY_POCIATOCNY_VKLAD = "Nedostatocny pociatocny vklad. "
																	+ "Pociatocny vklad musi byt minimalne";
	
	private final String CHYBA_NEEXISTUJUCA_VOLBA = "NEEXISTUJUCA VOLBA!";

	private Scanner scanner;
	private String vstup;
	

	public Menu() 
	{
		Banka banka = new Banka(TEXT_NAZOV_BANKY);
		scanner = new Scanner(System.in);
		int pocetUctov;
		
		System.out.print(TEXT_SPUSTENIE);
		
		do 
		{
			pocetUctov = banka.getZoznamKlientov().size();
			
			vypisVolbyMenu(TEXT_MENU_DOMOV);
			vstup = scanner.next();
			
			if (vstup.equals("1")) 
			{
				obalAVypis(TEXT_MENU_ZALOZENIE_NOVEHO_UCTU);
				
				Klient klient = novyKlient();
				banka.pridajKlienta(klient);
				
				obalAVypis(TEXT_VKLAD_NA_UCET_OK + "\n" + klient.getUcet().getAktualnyZostatok());
			}
			else if (vstup.equals("2")) 
			{
				obalAVypis(TEXT_MENU_VOLBA_UCTU);
				
				if (pocetUctov == 0) {
					obalAVypis(TEXT_ZIADNE_UCTY);
				}
			}
			else if (vstup.equals("4")) 
			{
				obalAVypis(TEXT_MENU_VOLBA_UCTU);
				System.out.print(banka.zobrazZoznamUctov());
				
				System.out.print(TEXT_VOLBA_2 + " ");
				vstup = scanner.next();
				int poradoveCislo = Integer.parseInt(vstup) - 1;
				
				obalAVypis(banka.zobrazInformacieOUcte(poradoveCislo));
				
			}
			else if (!vstup.equals("0"))
			{
				/* ak na vstupe pride hocico ine ako 0 - 4, vypise na standardny vystup chybovu hlasku */
				obalAVypis(CHYBA_NEEXISTUJUCA_VOLBA);
			}
			
		}
		while(!vstup.equals("0"));
		/* na vstupe bola zadana nula, cyklus sa prerusi a vypise na standardny vystup podakovanie a program skonci */
		System.out.println("\n" + TEXT_UKONCENIE + " " + TEXT_NAZOV_BANKY);
	}
	
	private Klient novyKlient() 
	{
		System.out.print(TEXT_KRSTNE_MENO + " ");
		String meno = scanner.next();
		
		System.out.print(TEXT_PRIEZVISKO + " ");
		String priezvisko = scanner.next();
		
		System.out.print(TEXT_RODNE_CISLO + " ");
		String rodneCislo = scanner.next();
		
		System.out.print(TEXT_TYP_UCTU + " ");
		String typUctu = scanner.next();
		
		BankovyUcet ucet = zalozUcet(typUctu);
		
		return new Klient(meno, priezvisko, rodneCislo, ucet);
	}

	private BankovyUcet zalozUcet(String typUctu) 
	{
		while(true)
		{
			System.out.print(TEXT_POCIATOCNY_VKLAD + " ");
			Double suma = scanner.nextDouble();
			
			if (typUctu.equalsIgnoreCase(TEXT_BEZNY_UCET))
			{
				if (suma >= MIN_CIASTKA_BEZNY_UCET)
				{
					return new BeznyUcet(suma);
				}
				else
				{
					System.out.println(TEXT_NEDOSTATOCNY_POCIATOCNY_VKLAD + " " + MIN_CIASTKA_BEZNY_UCET + " Eur.");
				}
			}
			else if (typUctu.equalsIgnoreCase(TEXT_SPORIACI_UCET))
			{
				if (suma >= MIN_CIASTKA_SPORIACI_UCET) 
				{
					return new SporiaciUcet(suma);
				}
				else 
				{
					System.out.println(TEXT_NEDOSTATOCNY_POCIATOCNY_VKLAD + " " + MIN_CIASTKA_SPORIACI_UCET + " Eur.");
				}
			}
		}
	}

	private void vypisVolbyMenu(String[] textMenuDomov) 
	{
		for (String riadok : textMenuDomov) 
		{
			System.out.print(riadok + "\n");
		}
		System.out.print(TEXT_VOLBA + " ");
	}
	
	private void obalAVypis(String sprava) {
		System.out.println("\n" + TEXT_ODDELOVAC + "\n" + sprava + "\n" + TEXT_ODDELOVAC + "\n");
	}
	
}
