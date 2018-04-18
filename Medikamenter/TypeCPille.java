
public class TypeCPille extends TypeC implements Pille{

	protected int antallPillerIEske;
	
	public TypeCPille (String nummer, String navn, double pris, int antallPillerIEske, double mengdeVirkestoff){
		super(nummer, navn, pris, mengdeVirkestoff);
		this.antallPillerIEske = antallPillerIEske;
	}
	
	public int hentAntallPiller(){
		return antallPillerIEske;
	}
	
	public double hentMengdeVirkestoff(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "pille" + ", " + "c" + ", " + pris + ", " + antallPillerIEske + ", " + mengdeVirkestoff;   
	}
}
