
public class TypeB extends Legemiddel{

	protected int vanedannende;
	
	public TypeB (String nummer, String navn, double pris, int vanedannende, double mengdeVirkestoff){
		super(nummer, navn, pris, mengdeVirkestoff);
		this.vanedannende = vanedannende;
	}
}
