import java.util.Iterator;
public interface AbstraktSortertEnkelListe <T extends Comparable<T> & Lik> extends Iterable<T>  {
	
	//metode som setter inn nytt element sortert (minst forst)
	public void settInn(T element);
	
	//metode som finner element
	public T finnElement(String nokkel);
	
	//metode som itererer og skriver ut liste
	public Iterator<T> iterator();
}
