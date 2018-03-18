
public class TypeBPille extends TypeB implements Pille{

	protected int antallPillerIEske;
	
	public TypeBPille (String nummer, String navn, double pris, int vanedannende, int antallPillerIEske, double mengdeVirkestoff){
		super(nummer, navn, pris, vanedannende, mengdeVirkestoff);
		this.antallPillerIEske = antallPillerIEske;
	}
	
	public int hentAntallPiller(){
		return antallPillerIEske;
	}
	
	public double hentMengdeVirkestoff(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "pille" + ", " + "b" + ", " + pris + ", " + antallPillerIEske + ", " + mengdeVirkestoff;   
	}
}
