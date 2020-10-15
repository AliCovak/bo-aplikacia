package sk.ajt.bo_aplikacia;

/**
 * <h1>Trieda BeznyUcet</h1>
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
public class BeznyUcet extends BankovyUcet 
{
	private static int pociatocneIdBeznehoUctu = 100_123_000;
	private int idBeznyUcet;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public BeznyUcet(double pociatocnyZostatok) 
	{
		super(pociatocnyZostatok);
		idBeznyUcet = ++pociatocneIdBeznehoUctu;
		super.setIdUctu(idBeznyUcet);
	}
	
}


