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
public class BankovyUcet {
	private double aktualnyZostatok;
	
	public BankovyUcet () {
		aktualnyZostatok = 0;
	}
//
	public BankovyUcet(double pociatocnyZostatok) {
		//TODO: pridelit kazdemu novemu uctu jedinecne ID:
		
		
		
		//aktualnyZostatok=pociatocnyZostatok;
		//TODO: pri zalozeni uctu s pociatocnym zostatkom =< 10 000 EUR -----> pripiseme bonus 2%
		if(pociatocnyZostatok <= 10000) {
			aktualnyZostatok = pociatocnyZostatok*1.02;
		}
		//TODO: pri zalozeni uctu s pociatocnym zostatkom > 10 000 EUR -----> pripiseme bonus 5%
		else {
			aktualnyZostatok = pociatocnyZostatok*1.05;
		}
		
		}
		
	
	public void vloz(double ciastka) {
		aktualnyZostatok = aktualnyZostatok + ciastka;
		//TODO: po kazdej transakcii zobrazitinformaciu o vysledku operacie
	}
	
	public void vyber(double ciastka) {
		aktualnyZostatok = aktualnyZostatok - ciastka;
		//TODO: po kazdej transakcii zobrazit informaciu o vysledku operacie
		//TODO: NEPOVOLIT transakciu so ZAPORNOU SUMOU
		
	}
	
	public double getAktualnyZostatok () {
		return aktualnyZostatok;
	}
}
