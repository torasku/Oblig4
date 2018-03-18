
public class Pasient {

	private String pasientNummer;
	private String navn;
	private String persNummer;
	private String adresse;
	private String postNummer;
	private YngsteForstReseptListe yForstReseptListe;
	
	
	public Pasient (String pasientNummer, String navn, String persNummer, String adresse, String postNummer){
		this.pasientNummer = pasientNummer;
		this.navn = navn;
		this.persNummer = persNummer;
		this.adresse = adresse;
		this.postNummer = postNummer;
		yForstReseptListe = new YngsteForstReseptListe();
	}
	
	public String toString(){
		return pasientNummer + ", " + navn + ", " + persNummer + ", " + adresse + ", " + postNummer;
	}
	
	public String skrivTilFil(){
		return pasientNummer + ", " + navn + ", " + persNummer + ", " + adresse + ", " + postNummer;
	}
	
	public String hentPasientNavn(){
		return navn;
	}
	
	public String hentPersonNummer(){
		return persNummer;
	}
	
	public YngsteForstReseptListe hentYFReseptListe(){
		return yForstReseptListe;
	}
	//metode som sjekker hvilke personer som bor i Oslo.
	public boolean bostedOslo(){
		int antallIOslo = 0;
		if(Integer.parseInt(postNummer) <= 1299){
			antallIOslo++;
		}
		return true;
	}
	
	public String hentPersId(){
		return pasientNummer;
	}
}
