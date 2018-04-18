
public class TypeAMikstur extends TypeA implements Mikstur {

	protected double mengdeIFlaske;
	
	public TypeAMikstur (String nummer, String navn, double pris, int styrke, double mengdeIFlaske, double mengdeVirkestoff){
		super(nummer, navn, pris, styrke, mengdeVirkestoff);
		this.mengdeIFlaske = mengdeIFlaske;
	}
	
	public double hentMengdeIFlaske(){
		return mengdeIFlaske;
	}
	
	public double hentVirkestoffPerCm3(){
		return mengdeVirkestoff;
	}
	
	public String skrivTilFil(){
		return nummer + ", " + navn + ", " + "mikstur" + ", " + "a" + ", " + pris + ", " + mengdeIFlaske + ", " + mengdeVirkestoff + ", " + styrke;   
	}
}
