package sk.ajt.bo_aplikacia;

public class BeznyUcet extends BankovyUcet {
	

	public BeznyUcet()
	{
		
	}
	
	//TODO: doplnit podmienku ---- > min. vklad musi byt 50 EUR
	public BeznyUcet(double pociatocnyZostatok)
	{
		super(pociatocnyZostatok);
	}
	
	@Override
	public void vloz(double ciastka) {
		
		super.vloz(ciastka);
	}
	
	@Override
	public void vyber(double ciastka) {
		
		super.vyber(ciastka);
	}
	
	
	}


