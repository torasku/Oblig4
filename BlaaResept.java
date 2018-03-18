
public class BlaaResept extends Resept{
	
	public BlaaResept(int reseptNummer, Legemiddel legemiddel, String legeNavn, String persID, int reit){
		super(reseptNummer, legemiddel, legeNavn, persID, reit);
	}
	
	public String toString(){
		return reseptNummer + ", " + this.getClass().getName() + ", " + legeNavn + ", " + reit;
	}
	
	public String skrivTilFil(){
		return reseptNummer + ", " + "blaa " + ", " + persID + ", " + legeNavn + ", " + legemiddel.hentLegemiddelNummer() + ", " + reit; 
	}
}
