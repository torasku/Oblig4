
public abstract class Legemiddel {

	protected String navn;
	protected String nummer;
	protected double pris;
	protected double mengdeVirkestoff;
	
	public Legemiddel (String nummer, String navn, double pris, double mengdeVirkestoff){
		this.nummer = nummer;
		this.navn = navn;
		this.pris = pris;
		this.mengdeVirkestoff = mengdeVirkestoff;
	}

	
	public String toString(){
		return nummer + ", " + navn + ", " + this.getClass().getName() + ", " + pris + ", " + mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + pris + ", " + mengdeVirkestoff;
	}
	
	public String hentLegemiddelNummer(){
		return nummer;
	}
}
