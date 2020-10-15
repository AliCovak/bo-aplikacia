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
	private long idUctu;
	private double aktualnyZostatok;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public BankovyUcet(double pociatocnyZostatok)
	{
		aktualnyZostatok = pociatocnyZostatok;
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
	
	
	
//	public BankovyUcet(String idUctu, double pociatocnyZostatok) 
//	{
//		//TODO: pridelit kazdemu novemu uctu jedinecne ID:
//		this.idUctu = idUctu;
//		this.aktualnyZostatok = pociatocnyZostatok;
//		
		
//		//aktualnyZostatok=pociatocnyZostatok;
//		//TODO: pri zalozeni uctu s pociatocnym zostatkom =< 10 000 EUR -----> pripiseme bonus 2%
//		if(pociatocnyZostatok <= 10000) 
//		{
//			aktualnyZostatok = pociatocnyZostatok*1.02;
//		}
//		//TODO: pri zalozeni uctu s pociatocnym zostatkom > 10 000 EUR -----> pripiseme bonus 5%
//		else 
//		{
//			aktualnyZostatok = pociatocnyZostatok*1.05;
//		}
		
//	}

	public void vloz(double ciastka) 
	{
		aktualnyZostatok += ciastka;
	}
	
	public void vyber(double ciastka) 
	{
		aktualnyZostatok = aktualnyZostatok - ciastka;
		//TODO: po kazdej transakcii zobrazit informaciu o vysledku operacie
		//TODO: NEPOVOLIT transakciu so ZAPORNOU SUMOU
	}
	
}
