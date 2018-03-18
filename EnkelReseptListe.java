import java.util.Iterator;

public class EnkelReseptListe<Resept> implements Iterable{

	protected Node foran;
	protected Node siste;
	protected int antallNoder = 0;
	
	protected class Node{
		Node neste;
		Resept resepten;
		
		Node(Resept resepten){
			this.resepten = resepten;
		}
	}
	//metode som legger inn resepter i FIFO-liste
	public boolean leggTilResept(Resept resepten){
		Node nyNode = new Node(resepten);
		antallNoder++;
		if(foran == null){
			foran = nyNode;
			siste = foran;
		}
		else{
			siste.neste = nyNode;
			siste = nyNode;
		}
		return true;
	}
	
	public int hentReseptNummer(){
		return antallNoder;
	}
	//metode som soker opp reseptnummer. Hvis ikke ikke funnet, skal det kastes unntak 
	//som returnerer feilmelding. 
	public Resept finnResept(int reseptNummer) throws KastUnntak{
		boolean fantElement = false;
		try {
			
			ListeIterator it = new ListeIterator();
			while(it.hasNext()){
				if(it.next().equals(reseptNummer)){
					System.out.println("Systemet fant "+ reseptNummer +" i listen.");
					fantElement = true;
				}			
			}
				if(!fantElement){
					throw new KastUnntak();
				}
		}
		catch (KastUnntak e){
			System.out.println(e.unntakMelding());
		}
		return null;
	}

	private class ListeIterator implements Iterator{
		Node denne = foran;
		Node forrige = null;
		
		public boolean hasNext(){
			return denne != null;
		}
		public Resept next(){
			forrige = denne;
			denne = denne.neste;
			return forrige.resepten;
		}
		public void remove(){
			//brukes ikke
		}
	}
	
	public Iterator iterator(){
		return new ListeIterator();
	}
	
}
