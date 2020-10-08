package sk.ajt.bo_aplikacia;

import java.util.ArrayList;
//ak by sme implementovali ulohu c. 5, 
//tak sem by mohlo prist ukladanie a vyberanie klientov z databazy

public class Banka {
	
	private ArrayList<Klient> zoznamKlientov;
	
	private void pridajKlienta(Klient klient) {
		zoznamKlientov.add(klient);
	}
	
	public void zobrazInformacieOUcte () {
		//TODO: je potrebne vypisat tieto informacie: cislo bankoveho uctu, aktualny zostatok 
		//a v pripade sporiaceho uctu aj aktualnu vysku urokovej sadzby
		
	}
	
	public void vypisHistoriuZostatkovNaUcte() {
		//TODO:
		
		
	}
	
	

}
