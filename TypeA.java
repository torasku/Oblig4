
public class TypeA extends Legemiddel{

	protected int styrke;
	
	public TypeA (String nummer, String navn, double pris, int styrke, double mengdeVirkestoff){
		super(nummer, navn, pris, mengdeVirkestoff);
		this.styrke = styrke;
	}
}
