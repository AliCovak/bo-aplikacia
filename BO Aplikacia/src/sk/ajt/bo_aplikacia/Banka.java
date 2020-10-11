package sk.ajt.bo_aplikacia;

import java.util.ArrayList;

// Julka:
// ak by sme implementovali ulohu c. 5, 
// tak sem by mohlo prist ukladanie a vyberanie klientov z databazy

/**
 * <h1>Trieda Banka</h1>
 * <p>
 *    Popis
 * </p>
 * <h2>obsahuje:</h2>  
 *    <ul>
 *       <li>nazov/meno banky</li>
 *       <li>zoznam klientov</li>
 *    </ul>
 * <h2>zodpoveda za:</h2>
 *    <ul>
 *       <li>vytvorenie objektu Banka</li>
 *       <li></li>
 *    </ul>
 */
public class Banka 
{
	/* premenne */
	private String nazovBanky;
	private ArrayList<Klient> zoznamKlientov;
	
	/**
	 * Vytvara objekt Banka.
	 * 
	 * @param nazovBanky nazov/meno banky
	 */
	public Banka(String nazovBanky) 
	{
		this.nazovBanky = nazovBanky;
	}
	
	
	
	
	
	
	
	
	private void pridajKlienta(Klient klient) {
		zoznamKlientov.add(klient);
	}
	
	public void zobrazInformacieOUcte () {
		//TODO: je potrebne vypisat tieto informacie: cislo bankoveho uctu, aktualny zostatok 
		//a v pripade sporiaceho uctu aj aktualnu vysku urokovej sadzby
		
	}
	
	public void vypisHistoriuZostatkovNaUcte() {
		//TODO:
		
		
	}

}
