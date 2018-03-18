
public class TypeAPille extends TypeA implements Pille{

	protected int antallPillerIEske;
	
	public TypeAPille (String nummer, String navn, double pris, int styrke, int antallPillerIEske, double mengdeVirkestoff){
		super(nummer, navn, pris, styrke, mengdeVirkestoff);
		this.antallPillerIEske = antallPillerIEske;
	}
	
	public int hentAntallPiller(){
		return antallPillerIEske;
	}
	
	public double hentMengdeVirkestoff(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "pille" + ", " + "a" + ", " + pris + ", " + antallPillerIEske + ", " + mengdeVirkestoff + ", " + styrke;   
	}
}
