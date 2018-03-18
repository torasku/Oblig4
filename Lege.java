
public class Lege implements Lik, Comparable<Lege>{

	protected String navn;
	protected int avtaleNummer = 0;
	private int antallNarkotiskeResepter = 0;
	private EldsteForstReseptListe eForstReseptListe;
	
	public Lege (String navn){
		this.navn = navn;
	}
	
	// metode som sjekker om et oppgitt navn er det samme som i parameter
	public boolean samme (String navn){
		if(this.navn.compareTo(navn) == 0){
			return true;
		}
		return false;
	}
	
	public String toString(){
		return navn + ", " + avtaleNummer;
	}

	public int compareTo(Lege l) {
		return this.navn.compareTo(l.hentNavn());
	}
	
	public String hentNavn(){
		return this.navn;
	}
	
	public String skrivTilFil(){
		return navn + ", " + avtaleNummer;
	}
	
	public void settAntallNarkotiskeResepter(){
		antallNarkotiskeResepter++;
	}
	
	public int hentAntallNarkotiskeResepter(){
		return antallNarkotiskeResepter;
	}
	
	public EldsteForstReseptListe hentEFReseptListe(){
		return eForstReseptListe;
	}
	
}
