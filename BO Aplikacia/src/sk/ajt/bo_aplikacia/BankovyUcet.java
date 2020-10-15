package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda BankovyUcet</h1>
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
public class BankovyUcet 
{
	private static final String CHYBA_NA_UCTE_NEMATE_DOSTATOK = ""
			+ "Transakcia nebola zrealizovana - nemate dostatok prostriedkov na ucte.";
	private final double BONUS_2 = 2.0;
	private final double BONUS_5 = 5.0;
	
	private final String TEXT_VKLAD_NA_UCET_OK = "Vklad na ucet bol uspesne zrealizovany. \n"
			+ "Aktualny zostatok na ucte:";
	private final String TEXT_VYBER_Z_UCTU_OK = "Vyber z uctu bol uspesne zrealizovany. \n"
			+ "Aktualny zostatok na ucte:";
	
	private static final String CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU = ""
			+ "Transakcia nebola zrealizovana - transakcie so zaporonou hodnotou nie su povolene.";
	
	private long idUctu;
	private double aktualnyZostatok;
	private double bonus;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public BankovyUcet(double pociatocnyZostatok)
	{
		aktualnyZostatok = pripisBonus(pociatocnyZostatok);
	}
	
	/**
	 * 
	 * @param suma
	 * @return
	 */
	private double pripisBonus(double suma) 
	{
		if (suma <= 10_000)
		{
			bonus = BONUS_2;
			return suma * (1 + (bonus / 100));
		}
		else
		{
			bonus = BONUS_5;
			return suma * (1 + (bonus / 100));
		}
	}

	/**
	 * 
	 * @param idUctu
	 */
	protected void setIdUctu(int idUctu)
	{
		this.idUctu = idUctu;
	}
	
	/**
	 * 
	 * @return
	 */
	public long getIdUctu() 
	{
		return idUctu;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getAktualnyZostatok () 
	{
		return aktualnyZostatok;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getBonus() 
	{
		return bonus;
	}
	
	/**
	 * 
	 * @param ciastka
	 */
	public String vloz(double ciastka) 
	{
		String zaznam = "";
		
		if (ciastka < 0)
		{
			zaznam = CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU;
		}
		else
		{
			aktualnyZostatok += ciastka;
			zaznam = TEXT_VKLAD_NA_UCET_OK + " " + aktualnyZostatok + " Eur";
		}
		
		return zaznam;
	}
	
	/**
	 * 
	 * @param ciastka
	 */
	public String vyber(double ciastka) 
	{
		String zaznam = "";
		
		if (ciastka < 0)
		{
			zaznam = CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU;
		}
		else if (aktualnyZostatok < ciastka)
		{
			zaznam = CHYBA_NA_UCTE_NEMATE_DOSTATOK;
		}
		{
			aktualnyZostatok -= ciastka;
			zaznam = TEXT_VYBER_Z_UCTU_OK + " " + aktualnyZostatok + " Eur";
		}
		
		return zaznam;
	}
	
}
