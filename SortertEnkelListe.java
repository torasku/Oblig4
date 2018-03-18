import java.util.Iterator;
public class SortertEnkelListe<T extends Comparable<T> & Lik> implements AbstraktSortertEnkelListe <T>{

	private Node foran;
	private Node siste;
	
	private class Node{
		Node neste;
		T element;
		
		Node(T t){
			element = t;
		}
	}
	// indre klasse iterator
	private class ListeIterator implements Iterator<T>{ //her stod det kun ListeIterator
		Node denne = foran;
		Node forrige = null;
		
		public boolean hasNext(){
			return denne != null;
		}
		public T next(){ 
			forrige = denne;
			denne = denne.neste;
			return forrige.element;
		}
		
		public void remove(){
			//brukes ikke
		}
	}
	
	public Iterator<T> iterator() {
		return new ListeIterator();
	}
	
	//setter inn objekter sortert (minste forst)
	public void settInn(T element){
		Node nyNode = new Node(element);
		
		if(foran == null){
			foran = nyNode;
			siste = nyNode;
			return;
		}
		
		Node forrige = foran;
		Node temp = foran.neste;
		
		if(forrige.element.compareTo(element) > 0){
			nyNode.neste = forrige;
			foran = nyNode;
			return;
		}
		
		while(temp != null){
			if(temp.element.compareTo(element) > 0){
				nyNode.neste = temp;
				forrige.neste = nyNode;
				return;
			}
			temp = temp.neste;
			forrige = forrige.neste;
		}
		forrige.neste = nyNode;
		siste = nyNode;
	}
	
	public T finnElement(String nokkel){
		ListeIterator it = new ListeIterator();
		while(it.hasNext()){
			if(it.next().equals(nokkel)){
				System.out.println("Systemet fant " + nokkel + " i listen.");
				return it.next();
			}	
		}
		System.out.println("Systemet fant ikke " + nokkel + " i systemet.");
		return null;
	}

	
}
