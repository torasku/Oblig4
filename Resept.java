
public class Resept {

	protected int reseptNummer;
	protected int reit;
	protected Legemiddel legemiddel;
	protected String legeNavn;
	protected String persID;
	
	// oppretter pekere i konstruktor til Resept for legemiddel, legenavn og pasientnavn
	public Resept (int reseptNummer, Legemiddel legemiddel, String legeNavn, String persID, int reit){
		this.reseptNummer = reseptNummer;
		this.legemiddel = legemiddel;
		this.legeNavn = legeNavn;
		this.persID = persID;
		this.reit = reit;
	}
	
	public boolean brukResept(){
		if(reit >= 1){
			reit--;
			System.out.println("Det er " + reit + " reit igjen på resepten.");
			return true;
		}
		return false;
	}
	
	public String toString(){
		return "Reseptnummer: " + reseptNummer + " Type: " + this.getClass();
	}
	
	public String skrivTilFil(){
		return reseptNummer + ", " + legeNavn + ", " + persID + ", " + reit;
	}
	
	public int hentReseptNummer(){
		return reseptNummer;
	}
	
	public String hentLegeNavn(){
		return legeNavn;
	}
	
	public int hentReit(){
		return reit;
	}
	
	public Legemiddel hentLegemiddel(){
		return legemiddel;
	}
	
	public String hentPersID(){
		return persID;
	}
	

	
}
