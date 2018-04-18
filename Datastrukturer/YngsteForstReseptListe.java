
public class YngsteForstReseptListe<Resept> extends EnkelReseptListe<Resept> {
	
	//LIFO liste
	public boolean leggTilResept(Resept resepten){
		Node nyNode = new Node(resepten);
	
		if(foran == null){
			foran = nyNode;
		}
		else{
			nyNode.neste = foran;
			foran = nyNode;
		}
		return true;
	}
}
