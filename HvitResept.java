
public class HvitResept extends Resept{
	
	public HvitResept(int reseptNummer, Legemiddel legemiddel, String legeNavn, String persID, int reit){
		super(reseptNummer, legemiddel, legeNavn, persID, reit);
		
	}
	
	public String toString(){
		return reseptNummer + ", " + this.getClass().getName() + ", " + legeNavn + ", "  + ", " + reit; 
	}
	
	public String skrivTilFil(){
		return reseptNummer + ", " + "hvit " + ", " + persID + ", " + legeNavn + ", " + legemiddel.hentLegemiddelNummer() + ", " + reit; 
	}
}
