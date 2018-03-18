import java.util.Iterator;

public class Tabell<E> implements AbstraktTabell<E> {

	private int antallElementer;
	private E [] elementer;
	private int antallObjekter = 0;
	
	public Tabell(int antallElementer){
		this.antallElementer = antallElementer;
		elementer = (E[])new Object[antallElementer];
	}
	
	public boolean settInn(E element, int indeks){
			
		if(element != null && indeks >= 0 && indeks <= antallElementer -1 &&  elementer[indeks] == null ){
				elementer[indeks] = element;
				antallObjekter++;
				return true;
			}
			return false;
	}
	
	public E finn(int indeks){
			if(elementer[indeks] != null){
				return elementer[indeks];
			}
			else{
				System.out.println("Finner ikke data paa angitt indeks.");
			}
			return null;
	}
	
	private class TabellIterator implements Iterator<E>{
		private int teller = 0;
		
		public boolean hasNext(){
			if(teller < antallObjekter){
				teller ++;
				return true;
			}
			teller ++;
			return false;
		}
		
		public E next(){
			return elementer[teller-1];
		}
		
		public void remove(){
			//ikke implementert
		}
		
	}
	
	public Iterator<E> iterator(){
		return new TabellIterator();
	}
	
	public int hentAntallElementer(){
		return elementer.length;
	}

	public int testAntallElementer(){
		int teller = 0;
		for(int i = 0; i < elementer.length; i++){
			if(elementer[i] != null){
				teller++;
			}
		}
		return teller;
	}
	
	public int hentAntallObjekter(){
		return antallObjekter;
	}
}
