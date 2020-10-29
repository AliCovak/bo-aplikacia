package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda BankovyUcet</h1>
 * <p>
 *    <!--Popis-->
 * </p>
 * <h2>obsahuje:</h2>  
 * <ul>
 *    <li>ID bankoveho uctu</li>
 *    <li>Aktualny zostatok na bankovom ucte</li>
 *    <li>Bonus, kt. bol pouzity pri zalozeni noveho uctu</li>
 * </ul>
 * <h2>zodpoveda za:</h2>
 * <ul>
 *    <li>Vytvorenie bankoveho uctu</li>
 *    <li>Ziskanie dat ohladom daneho bankoveho uctu, ako:</li>
 *    <ul>
 *       <li>Aktualny zostatok</li>
 *       <li>Vysky bonusu v %, pozitej pri zalozeni uctu</li>
 *       <li>ID/identifikator k uctu</li>
 *    </ul>
 *    <li>Pripisanie bonusu pri zalozeni uctu</li>
 *    <li>Priradenia ID/identifikatoru k bankovemu uctu</li>
 *    <li>Vklad na ucet</li>
 *    <li>Vyber z uctu</li>
 * </ul>
 */
public class BankovyUcet 
{
	/* KONSTANTY ==================================================================================================== */
	private static final String CHYBA_NA_UCTE_NEMATE_DOSTATOK_FIN_PROSTRIEDKOV = ""
			+ "Transakcia nebola zrealizovana - nemate dostatok prostriedkov na ucte.";
	private final double BONUS_2 = 2.0;
	private final double BONUS_5 = 5.0;
	
	private final String TEXT_VKLAD_NA_UCET_OK = "Vklad na ucet bol uspesne zrealizovany. \n"
			+ "Aktualny zostatok na ucte:";
	private final String TEXT_VYBER_Z_UCTU_OK = "Vyber z uctu bol uspesne zrealizovany. \n"
			+ "Aktualny zostatok na ucte:";
	
	private static final String CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU = ""
			+ "Transakcia nebola zrealizovana - transakcie so zaporonou hodnotou nie su povolene.";
	
	/* DATA ==========================================================================================================*/
	private long idUctu;
	private double aktualnyZostatok;
	private double bonus;
	
	/* KONSTRUKTOR ===================================================================================================*/
	/**
	 * Vytvara bankovy ucet vratane pociatocneho zostatku -> podla vysky pociatocneho zostatku pripise k danej sume
	 * aj jednorazovy bonus.
	 * 
	 * @param pociatocnyZostatok vyska pociatocneho zostatku na danom bankovom ucte
	 */
	public BankovyUcet(double pociatocnyZostatok)
	{
		/*
		 * Vypocita vysku bonusu na zaklade pociatocneho zostatku, scita ich a priradi tuto sumu k aktualnemu zostatku.
		 */
		aktualnyZostatok = pripisBonus(pociatocnyZostatok);
	}
	
	/**
	 * Vytvori bankovy ucet ... praca s databazou
	 * 
	 * @param idUctu
	 * @param aktualnyZostatok
	 * @param bonus
	 */
	public BankovyUcet(long idUctu, double aktualnyZostatok, double bonus) 
	{
		this.idUctu = idUctu;
		this.aktualnyZostatok = aktualnyZostatok;
		this.bonus = bonus;
	}
	
	/* METODY ========================================================================================================*/
	/**
	 * Vypocita a pripise bonus k danej sume.
	 * 
	 * @param suma suma penazi, ku ktorej bude pripisany bonus
	 * @return sumu penazi, vratane pripocitaneho bonusu
	 */
	private double pripisBonus(double suma) 
	{
		/* 
		 * Na zaklade vysky sumy rozhodne, ktoru vysku bonusu bude pocitat. 
		 */
		if (suma <= 10_000)
		{
			/* 
			 * Ak suma penazi je <= 10 000, 
			 * priradi velkost bonusu v percentach (napr. 2%) do inst. premennej bonus
			 * a vrati celkovu sumu vratane pripocitaneho bonusu. 
			 */
			bonus = BONUS_2;
			/*
			 * 2% -> 2 / 100 = 0.02 + 1 = 1.02
			 * suma * 1.02
			 */
			return suma * (1 + (bonus / 100));
		}
		else
		{
			/*
			 * inak (suma nad 10 000) 
			 * priradi velkost bonusu v percentach (napr. 5%) do inst. premennej bonus
			 * a vrati celkovu sumu vratane pripocitaneho bonusu. 
			 */
			bonus = BONUS_5;
			/*
			 * 5% -> 2 / 100 = 0.05 + 1 = 1.05
			 * suma * 1.05
			 */
			return suma * (1 + (bonus / 100));
		}
	}

	/**
	 * Nastavi/priradi identifikator uctu do inst. premennej idUctu
	 * 
	 * @param idUctu identifikator uctu, kt. ma by pouzitity ako identifikator uctu
	 */
	protected void setIdUctu(long idUctu)
	{
		this.idUctu = idUctu;
	}
	
	/**
	 * Vracia identifikator uctu.
	 * 
	 * @return identifikator uctu
	 */
	public long getIdUctu() 
	{
		return idUctu;
	}
	
	/**
	 * Vracia aktualny zostatok na ucte.
	 * 
	 * @return aktualny zostatok na ucte
	 */
	public double getAktualnyZostatok () 
	{
		return aktualnyZostatok;
	}
	
	/**
	 * Vracia percetna bonusu. 
	 * 
	 * @return percetna bonusu
	 */
	public double getBonus() 
	{
		return bonus;
	}
	
	/**
	 * Vlozi ciastku na bankovy ucet a vracia retazcovu reperezentaciu informacie o stave transakcie.
	 * 
	 * @param ciastka suma penazi vkladana na bankovy ucet
	 * @return retazcovu reperezentaciu informacie o stave transakcie
	 */
	public String vloz(double ciastka) 
	{
		String zaznam = "";
		
		/* 
		 * Na zaklade vysky ciastky rozhodne, ci pripise prostriedky na bankovy ucet.
		 */
		if (ciastka < 0)
		{
			/*
			 * Ak sa pri pokuse o vklad pouzije zaporna hodnota, 
			 * posle retazcovu reprezentaciu o chybe.
			 */
			zaznam = CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU;
		}
		else
		{
			/*
			 * Inak danu ciastku pripocita k aktulanemu zostatku na danom bankovom ucte a posle retazcovu reprezentaciu
			 * potvrdenia o uspesnom pripisani prostriedkov na dany bankovy ucet, vratane informacie o vyske aktualneho 
			 * zostatku.
			 */
			aktualnyZostatok += ciastka;
			zaznam = TEXT_VKLAD_NA_UCET_OK + " " + aktualnyZostatok + " Eur";
		}
		
		return zaznam;
	}
	
	/**
	 * Vybera ciastku z bankoveho uctu a vracia retazcovu reperezentaciu informacie o stave transakcie.
	 * 
	 * @param ciastka suma penazi vyberana z bankoveho uctu
	 * @return retazcovu reperezentaciu informacie o stave transakcie
	 */
	public String vyber(double ciastka) 
	{
		String zaznam = "";
		
		/* 
		 * Na zaklade vysky ciastky rozhodne, ci odpise prostriedky z bankoveho uctu.
		 */
		if (ciastka < 0)
		{
			/*
			 * Ak sa pri pokuse o vyber pouzije zaporna hodnota,
			 * posle retazcovu reprezentaciu o chybe.
			 */
			zaznam = CHYBA_NEPOVOLENA_AKCIA_TRANSAKCIE_SO_ZAPORONOU_HODNOTOU;
		}
		else if (aktualnyZostatok < ciastka)
		{
			/*
			 * Inak ak sa pri pokuse o vyber ciastky vyssej ako je aktualny zostatok, 
			 * posle retazcovu reprezentaciu o chybe nedostatku fin. prostriedkov na ucte.
			 */
			zaznam = CHYBA_NA_UCTE_NEMATE_DOSTATOK_FIN_PROSTRIEDKOV;
		}
		else
		{
			/*
			 * Inak danu ciastku odpocita z aktulaneho zostatku na danom bankovom ucte a posle retazcovu reprezentaciu
			 * potvrdenia o uspesnom odpisani prostriedkov z daneho bankoveho uctu, vratane informacie o vyske aktualneho 
			 * zostatku.
			 */
			aktualnyZostatok -= ciastka;
			zaznam = TEXT_VYBER_Z_UCTU_OK + " " + aktualnyZostatok + " Eur";
		}
		
		return zaznam;
	}
	
}
