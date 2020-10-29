package sk.ajt.bo_aplikacia;

import java.util.ArrayList;

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
	private long idBeznyUcet;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public BeznyUcet(double pociatocnyZostatok, ArrayList<Long> zoznamIdUctov) 
	{
		super(pociatocnyZostatok);
		idBeznyUcet = generujIdBeznehoUctu(zoznamIdUctov);
		super.setIdUctu(idBeznyUcet);
	}

	private long generujIdBeznehoUctu(ArrayList<Long> zoznamIdUctov) {
		
		long noveIdUctu = 100_123_000;
		
		if (zoznamIdUctov.size() > 0)
		{
			for (Long idUctu : zoznamIdUctov) {
				if (idUctu < 500_000_000 && idUctu > noveIdUctu)
				{
					noveIdUctu = idUctu;
				}
			}
		}
		
		return noveIdUctu + 1;
	}
	
}


