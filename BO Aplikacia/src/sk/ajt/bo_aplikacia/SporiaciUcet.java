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
	
private double urokovaSadzba;
	
	public SporiaciUcet(double urokovaSadzba)
	{
		super();	
		this.urokovaSadzba = urokovaSadzba;
	}
	//TODO: doplnit podmienku ---- > min. vklad musi byt 100 EUR
	public SporiaciUcet(double urokovaSadzba, double pociatocnyZostatok)
	{
		
		super(pociatocnyZostatok);
		this.urokovaSadzba = urokovaSadzba;
		
	}
	
	public void pripisUrok()
	{
		double urok = (getAktualnyZostatok() * urokovaSadzba) / 100;
		//vloz(urok);
		super.vloz(urok);
	}

}
