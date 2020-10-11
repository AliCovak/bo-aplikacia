package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda Klient</h1>
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
public class Klient 
{
	/* premenne  */
	private String meno;
	private String priezvisko;
	private String rodneCislo;
	
	private BankovyUcet beznyUcet;
	private BankovyUcet sporiaciUcet;
	
	/**
	 * Vytvara noveho klienta.
	 * 
	 * @param meno meno klienta
	 * @param priezvisko priezvisko klienta
	 * @param rodneCislo rodne cislo klienta
	 */
	public Klient(String meno, String priezvisko, String rodneCislo) 
	{
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.rodneCislo = rodneCislo;
		
		beznyUcet = new BankovyUcet();
		sporiaciUcet = new BankovyUcet();
	}
	

	
	
	
	
	public BankovyUcet getBeznyUcet() {
		return beznyUcet;
	}

	public BankovyUcet getSporiaciUcet() {
		return sporiaciUcet;
	}

	/**
	 * @return the meno
	 */
	public String getMeno() {
		return meno;
	}

	/**
	 * @param meno the meno to set
	 */
	public void setMeno(String meno) {
		this.meno = meno;
	}

	/**
	 * @return the priezvisko
	 */
	public String getPriezvisko() {
		return priezvisko;
	}

	/**
	 * @param priezvisko the priezvisko to set
	 */
	public void setPriezvisko(String priezvisko) {
		this.priezvisko = priezvisko;
	}

	/**
	 * @return the rodneCislo
	 */
	public String getRodneCislo() {
		return rodneCislo;
	}

	/**
	 * @param rodneCislo the rodneCislo to set
	 */
	public void setRodneCislo(String rodneCislo) {
		this.rodneCislo = rodneCislo;
	}
	
}
