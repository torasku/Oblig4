
public class TypeBMikstur extends TypeB implements Mikstur{

	protected double mengdeIFlaske;
	
	public TypeBMikstur (String nummer, String navn, double pris, int vanedannende, double mengdeIFlaske, double mengdeVirkestoff){
		super(nummer, navn, pris, vanedannende, mengdeVirkestoff);
		this.mengdeIFlaske = mengdeIFlaske;
	}
	
	public double hentMengdeIFlaske(){
		return mengdeIFlaske;
	}
	
	public double hentVirkestoffPerCm3(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "mikstur" + ", " + "b" + ", " + pris + ", " + mengdeIFlaske + ", " + mengdeVirkestoff;   
	}
}
