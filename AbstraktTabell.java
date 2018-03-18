import java.util.Iterator;
public interface AbstraktTabell<E> extends Iterable<E>{
	
	/**metode som setter objekt inn i tabell, og skal returnerer true hvis
	   operasjon er vellykket, ellers false. 
	*/
	public boolean settInn(E element, int indeks);
	
	//metode som finner objekt basert paa indeks
	public E finn(int indeks);
	
	//metode som iterere gjennom liste og skriver ut
	//public void skrivUtAlle();
	public Iterator<E> iterator(); 

}
