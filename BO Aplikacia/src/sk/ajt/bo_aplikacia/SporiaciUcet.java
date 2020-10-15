package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda SporiaciUcet</h1>
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
public class SporiaciUcet extends BankovyUcet {
	
	private int pociatocneIdSporiacehoUctu = 200_456_000;
	private int idSporiaciUcet;
	private double urokovaSadzba;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public SporiaciUcet(double pociatocnyZostatok) 
	{
		super(pociatocnyZostatok);
		idSporiaciUcet = ++pociatocneIdSporiacehoUctu;
		super.setIdUctu(idSporiaciUcet);
	}
	
	public void pripisUrok()
	{
		double urok = (getAktualnyZostatok() * urokovaSadzba) / 100;
		//vloz(urok);
		super.vloz(urok);
	}
	
//	public SporiaciUcet(double urokovaSadzba)
//	{
//		super();	
//		this.urokovaSadzba = urokovaSadzba;
//	}
	
}
