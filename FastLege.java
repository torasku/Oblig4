
public class FastLege extends Lege implements KommuneAvtale {

	private int avtaleNummer;
	
	public FastLege (String navn, int avtaleNummer){
		super(navn);
		this.avtaleNummer = avtaleNummer;
		
	}
	
	public void settAvtaleNummer(int avtaleNummer){
		this.avtaleNummer = avtaleNummer;
	}
	
	public int hentAvtaleNummer(){
		return avtaleNummer;
	}
	
	public String skrivTilFil(){
		return navn + ", " + avtaleNummer;
	}
}
