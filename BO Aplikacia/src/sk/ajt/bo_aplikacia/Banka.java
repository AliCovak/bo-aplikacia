package sk.ajt.bo_aplikacia;

import java.util.ArrayList;

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
	private static final String TEXT_CELE_MENO = "Meno:";
	private static final String TEXT_RODNE_CISLO = "Rodne cislo:";
	private static final String TEXT_CISLO_UCTU = "Cislo uctu #:";
	private static final String TEXT_BEZNY_UCET = "Bezny Ucet:";
	private static final String TEXT_SPORIACI_UCET = "Sporiaci Ucet:";
	private static final String TEXT_AKTUALNY_ZOSTATOK = "Aktualny zostatok:";
	private static final String TEXT_UROKOVA_SADZBA = "Urokova sadzba:";
	
	private String nazovBanky;
	private ArrayList<Klient> zoznamKlientov = new ArrayList<Klient>();
	private DataBase dataBase;
	
	
	/**
	 * Vytvara objekt Banka.
	 * 
	 * @param nazovBanky nazov/meno banky
	 */
	public Banka(String nazovBanky, DataBase dataBase) 
	{
		this.nazovBanky = nazovBanky;
		this.dataBase = dataBase;
	}
	
	/**
	 * 
	 * @param klient
	 */
	public void pridajKlienta(Klient klient) 
	{
//		zoznamKlientov.add(klient);
		dataBase.addNewKlient(klient);
	}
	
	/**
	 * 
	 * @param poradoveCislo
	 * @return
	 */
	public String zobrazInformacieOUcte(int poradoveCislo)
	{
		Klient klient = dataBase.getAllKlients().get(poradoveCislo);
		String typUctu;
//		String urok = "";
		
//		if (klient.getUcet() instanceof BeznyUcet) 
//		{
//			typUctu = TEXT_BEZNY_UCET;
//		}
//		else
//		{
//			typUctu = TEXT_SPORIACI_UCET;
//			/* urok pravdepodobne nebudeme pocitat, nakolko sa v poziadavkach, nenachadza iba bonus pri zalozeni uctu */
////			urok = "\n" + TEXT_UROKOVA_SADZBA + " " + "x" + "%";
//			
//		}
		
		Long idUctu = klient.getUcet().getIdUctu();
		
		if (idUctu.toString().charAt(0) == '1')
		{
			typUctu = TEXT_BEZNY_UCET;
		}
		else
		{
			typUctu = TEXT_SPORIACI_UCET;
		}
		
		return TEXT_CELE_MENO + " " + klient.getMeno() + " " + klient.getPriezvisko() + " "
			 + TEXT_RODNE_CISLO + klient.getRodneCislo() + " "
			 + TEXT_CISLO_UCTU + " " + klient.getUcet().getIdUctu() + "\n"
			 + typUctu + " " + klient.getUcet().getIdUctu() + "\n"
			 + TEXT_AKTUALNY_ZOSTATOK + " " + klient.getUcet().getAktualnyZostatok();
//			 + urok;
	}
	
	/**
	 * 
	 * @return
	 */
	public String zobrazZoznamUctov() 
	{
		String zoznam = "";
		
		for (int i = 0; i < dataBase.getAllKlients().size(); i++) 
		{
			Klient klient = dataBase.getAllKlients().get(i);
			
			zoznam += (i + 1) + ") " + TEXT_CELE_MENO + " " + klient.getMeno() + " " + klient.getPriezvisko() + " "
			+ TEXT_RODNE_CISLO + " " + klient.getRodneCislo() + " "
			+ TEXT_CISLO_UCTU + " " + klient.getUcet().getIdUctu() + "\n";
		}
		return zoznam;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Klient> getZoznamKlientov() {
		return dataBase.getAllKlients();
	} 

}
