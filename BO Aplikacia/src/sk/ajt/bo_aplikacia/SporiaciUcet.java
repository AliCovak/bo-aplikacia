package sk.ajt.bo_aplikacia;

import java.util.ArrayList;

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
	
	private long idSporiaciUcet;
	
	/**
	 * 
	 * @param pociatocnyZostatok
	 */
	public SporiaciUcet(double pociatocnyZostatok, ArrayList<Long> zoznamIdUctov) 
	{
		super(pociatocnyZostatok);
		idSporiaciUcet = generujIdSporiacehoUctu(zoznamIdUctov);
		super.setIdUctu(idSporiaciUcet);
	}

	private long generujIdSporiacehoUctu(ArrayList<Long> zoznamIdUctov) {
		
		long noveIdUctu = 500_456_000;
		
		if (zoznamIdUctov.size() > 0)
		{
			for (Long idUctu : zoznamIdUctov) {
				if (idUctu > 500_000_000 && idUctu > noveIdUctu)
				{
					noveIdUctu = idUctu;
				}
			}
		}
		
		return noveIdUctu + 1;
	}
	
}
