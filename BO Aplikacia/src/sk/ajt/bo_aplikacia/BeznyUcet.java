package sk.ajt.bo_aplikacia;

import java.util.ArrayList;
import java.util.Scanner;

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
	private int pociatocneIdBeznehoUctu = 100_123_000;
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
	
//	//TODO: doplnit podmienku ---- > min. vklad musi byt 50 EUR
//	public BeznyUcet(double pociatocnyZostatok)
//	{
//		super(pociatocnyZostatok);
//	}
	
//	@Override
//	public void vloz(double ciastka) 
//	{
//		super.vloz(ciastka);
//	}
//	
//	@Override
//	public void vyber(double ciastka) 
//	{
//		super.vyber(ciastka);
//	}
	
}


