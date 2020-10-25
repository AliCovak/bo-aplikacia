package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda Klient</h1>
 * <p>
 * Popis
 * </p>
 * <h2>obsahuje:</h2>
 * <ul>
 * <li></li>
 * <li></li>
 * </ul>
 * <h2>zodpoveda za:</h2>
 * <ul>
 * <li></li>
 * <li></li>
 * </ul>
 */
public class Klient {
	/* premenne */
	private String meno;
	private String priezvisko;
	private String rodneCislo;
	private BankovyUcet ucet;
	private double aktualnyZostatok;
	private long cisloUctu;

	/**
	 * Vytvara noveho klienta.
	 * 
	 * @param meno       meno klienta
	 * @param priezvisko priezvisko klienta
	 * @param rodneCislo rodne cislo klienta
	 */
	public Klient(String meno, String priezvisko, String rodneCislo, BankovyUcet ucet) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.rodneCislo = rodneCislo;
		this.ucet = ucet;
	}

	public Klient(String meno, String priezvisko, String rodneCislo, double aktualnyZostatok, long cisloUctu) {
		this.meno = meno;
		this.priezvisko = priezvisko;
		this.rodneCislo = rodneCislo;
		this.aktualnyZostatok = aktualnyZostatok;
		this.cisloUctu = cisloUctu;
	}

	public Klient() {

	}

	public long getCisloUctu() {
		return cisloUctu;
	}

	public double getAktualnyZostatok() {
		return aktualnyZostatok;
	}

	/**
	 * 
	 * @return
	 */
	public String getMeno() {
		return meno;
	}

	/**
	 * 
	 * @return
	 */
	public String getPriezvisko() {
		return priezvisko;
	}

	/**
	 * 
	 * @return
	 */
	public String getRodneCislo() {
		return rodneCislo;
	}

	/**
	 * 
	 * @return
	 */
	public BankovyUcet getUcet() {
		return ucet;
	}

}
