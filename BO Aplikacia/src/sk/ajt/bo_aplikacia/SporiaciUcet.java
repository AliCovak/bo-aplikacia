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
	
	private static int pociatocneIdSporiacehoUctu = 500_456_000;
	private int idSporiaciUcet;
	
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
	
}
