
public class TypeCMikstur extends TypeC implements Mikstur {

	protected double mengdeIFlaske;

	
	public TypeCMikstur (String nummer, String navn, double pris, double mengdeIFlaske, double mengdeVirkestoff){
		super(nummer, navn, pris, mengdeVirkestoff);
		this.mengdeIFlaske = mengdeIFlaske;
	}
	
	public double hentMengdeIFlaske(){
		return mengdeIFlaske;
	}
	
	public double hentVirkestoffPerCm3(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "mikstur" + ", " + "c" + ", " + pris + ", " + mengdeIFlaske + ", " + mengdeVirkestoff;   
	}
}
