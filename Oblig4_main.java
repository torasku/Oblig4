import java.util.*;
import java.io.*;
public class Oblig4_main {
	
	static SortertEnkelListe <Lege> leger = new SortertEnkelListe<Lege>();
	static Tabell<Legemiddel> legemidler = new Tabell<Legemiddel>(100);
	static Tabell<Pasient> pasienter = new Tabell<Pasient>(100);
	static EnkelReseptListe<Resept> reseptListe = new EnkelReseptListe<Resept>();
	
	public static void main(String[] args) throws KastUnntak, FileNotFoundException {
	
		//kjor program
		utfoerKommandoer();	
	}
	
	public static void opprettLege(String navn){
		Lege lege = new Lege(navn);
		leger.settInn(lege);
	}
	
	public static void opprettFastLege(String navn, int avtaleNummer){
		FastLege fastLege = new FastLege(navn, avtaleNummer);
		leger.settInn(fastLege);
	}

	public static void opprettHvitResept(int reseptNummer, Legemiddel legemiddel, String legeNavn, String persID, int reit){
		HvitResept hr = new HvitResept(reseptNummer, legemiddel, legeNavn, persID, reit);
		reseptListe.leggTilResept(hr);
		//innsetting i LIFO
		Pasient p = pasienter.finn(Integer.parseInt(persID));
		p.hentYFReseptListe().leggTilResept(hr);
		//innsetting i FIFO
		/*for(Lege l : leger){
			if(l != null){
				l.hentEFReseptListe().leggTilResept(hr);
			}
		}*/
	}
	
	public static void opprettBlaaResept(int reseptNummer, Legemiddel legemiddel, String legeNavn, String persID, int reit){
		BlaaResept br = new BlaaResept(reseptNummer, legemiddel, legeNavn, persID, reit);
		reseptListe.leggTilResept(br);
		//innsetting i LIFO
		Pasient p = pasienter.finn(Integer.parseInt(persID));
		p.hentYFReseptListe().leggTilResept(br);
		//innsetting i FIFO
		/*for(Lege l : leger){
			if(l != null){
				l.hentEFReseptListe().leggTilResept(br);
			}
		}*/
	}
	
	public static void opprettTypeAPille(String nummer, String navn, double pris, int styrke, int antallPillerIEske, double mengdeVirkestoff){
		TypeAPille tap = new TypeAPille(nummer, navn, pris, styrke, antallPillerIEske, mengdeVirkestoff);
		legemidler.settInn(tap, Integer.parseInt(nummer));
	}
	
	public static void opprettTypeBPille(String nummer, String navn, double pris, int vanedannende, int antallPillerIEske, double mengdeVirkestoff){
		TypeBPille tbp = new TypeBPille(nummer, navn, pris, vanedannende, antallPillerIEske, mengdeVirkestoff);
		legemidler.settInn(tbp, Integer.parseInt(nummer));
	}
	
	public static void opprettTypeCPille(String nummer, String navn, double pris, int antallPillerIEske, double mengdeVirkestoff){
		TypeCPille tcp = new TypeCPille(nummer, navn, pris, antallPillerIEske, mengdeVirkestoff);
		legemidler.settInn(tcp, Integer.parseInt(nummer));
	}
	
	public static void opprettTypeAMikstur(String nummer, String navn, double pris, int styrke, double mengdeIFlaske, double mengdeVirkestoff){
		TypeAMikstur tam = new TypeAMikstur(nummer, navn, pris, styrke, mengdeIFlaske, mengdeVirkestoff);
		legemidler.settInn(tam, Integer.parseInt(nummer));
	}
	
	public static void opprettTypeBMikstur(String nummer, String navn, double pris, int vanedannende, double mengdeIFlaske, double mengdeVirkestoff){
		TypeBMikstur tbm = new TypeBMikstur(nummer, navn, pris, vanedannende, mengdeIFlaske, mengdeVirkestoff);
		legemidler.settInn(tbm, Integer.parseInt(nummer));
	}
	
	public static void opprettTypeCMikstur(String nummer, String navn, double pris, double mengdeIFlaske, double mengdeVirkestoff){
		TypeCMikstur tcm = new TypeCMikstur(nummer, navn, pris, mengdeIFlaske, mengdeVirkestoff);
		legemidler.settInn(tcm, Integer.parseInt(nummer));
	}
	
	public static void opprettPasient(String pasientNummer, String navn, String persNummer, String adresse, String postNummer){
		Pasient pasient = new Pasient(pasientNummer, navn, persNummer, adresse, postNummer);
		pasienter.settInn(pasient, Integer.parseInt(pasientNummer));
	}
	
	//metode som leser inn fra fil
	public static void lesInnFil() throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn filnavn:");
		String filNavn = in.nextLine();
		Scanner nyFil = new Scanner(new File(filNavn));
	
		while(nyFil.hasNextLine()){
			String tekst = nyFil.nextLine();
			if(tekst.contains("Personer")){
				tekst = nyFil.nextLine();
				while(! (tekst.equals(""))){
					
					String [] argumenter = tekst.split(", ");
					
					String pasientNummer = argumenter[0];
					String navn = argumenter[1];
					String persNummer = argumenter[2];
					String adresse = argumenter[3];
					String postNummer = argumenter[4];
					opprettPasient(pasientNummer, navn, persNummer, adresse, postNummer);
					tekst = nyFil.nextLine();
				}
				
			}
			else if(tekst.contains("Legemidler")){
				tekst = nyFil.nextLine();
				while(! (tekst.equals(""))){
					
					String [] argumenter = tekst.split(", ");
					String nummer = argumenter[0];
					String navn = argumenter[1];
					String form = argumenter[2];
					String type = argumenter[3];
					double pris = Double.parseDouble(argumenter[4]);
					int mengde = Integer.parseInt(argumenter[5]);
					double virkestoff = Double.parseDouble(argumenter[6]);
					
					if(form.equalsIgnoreCase("pille")){
						if(type.equalsIgnoreCase("a")){
							int styrke = Integer.parseInt(argumenter[7]);
							opprettTypeAPille(nummer, navn, pris, styrke, mengde, virkestoff);
						}
						else if(type.equalsIgnoreCase("b")){
							int vanedannende = Integer.parseInt(argumenter[7]);
							opprettTypeBPille(nummer, navn, pris, vanedannende, mengde, virkestoff);
						}
						else if(type.equalsIgnoreCase("c")){
							opprettTypeCPille(nummer, navn, pris, mengde, virkestoff);
						}
					}
					else if(form.equalsIgnoreCase("mikstur")){
						if(type.equalsIgnoreCase("a")){
							int styrke = Integer.parseInt(argumenter[7]);
							opprettTypeAMikstur(nummer, navn, pris, styrke, mengde, virkestoff);
						}
						else if(type.equalsIgnoreCase("b")){
							int vanedannende = Integer.parseInt(argumenter[7]);
							opprettTypeBMikstur(nummer, navn, pris, vanedannende, mengde, virkestoff);
						}
						else if(type.equalsIgnoreCase("c")){
							opprettTypeCMikstur(nummer, navn, pris, mengde, virkestoff);
						}
					}
					tekst = nyFil.nextLine();
				}
			}
			else if(tekst.contains("Leger")){
				tekst = nyFil.nextLine();
				while(! (tekst.equals(""))){
					String [] argumenter = tekst.split(", ");
					String navn = argumenter[0];
					int avtaleNummer = Integer.parseInt(argumenter[1]);
					if(avtaleNummer == 0){
						opprettLege(navn);
					}
					else{
						opprettFastLege(navn, avtaleNummer);
					}
					tekst = nyFil.nextLine();
				}
			}
			else if(tekst.contains("Resepter")){
				tekst = nyFil.nextLine();
				while(! (tekst.equals(""))){
					String [] argumenter = tekst.split(", ");
					int reseptNummer = Integer.parseInt(argumenter[0]);
					String type = argumenter[1]; // hvit/blaa resept
					String persID = argumenter[2];
					String legeNavn = argumenter[3];
					String legemiddelNummer = argumenter[4];
					int reit = Integer.parseInt(argumenter[5]);
					
					if(type.equalsIgnoreCase("blaa")){
						opprettBlaaResept(reseptNummer,legemidler.finn(Integer.parseInt(legemiddelNummer)), legeNavn, persID, reit);
					}
					else if(type.equalsIgnoreCase("hvit")){
						opprettHvitResept(reseptNummer, legemidler.finn(Integer.parseInt(legemiddelNummer)), legeNavn, persID, reit);
					}
					tekst = nyFil.nextLine();		
				}	
			}	
		}
		nyFil.close();
	}
	// metode som skriver til fil 
	public static void skrivTilFil()throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn filnavn:");
		String nyFil = in.nextLine();
		PrintWriter skriver = new PrintWriter(nyFil);
		
		skriver.println("# Pasienter (nr, navn, fnr, adresse, postnr)");
		for(Pasient p : pasienter){
			skriver.println(p.skrivTilFil());
		}
		skriver.println("");
		skriver.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff, styrke)");
		for(Legemiddel lm : legemidler){
			if(lm instanceof TypeAPille){
				TypeAPille tap = (TypeAPille) lm;
				skriver.println(tap.skrivTilFil());
			}
			else if(lm instanceof TypeBPille){
				TypeBPille tbp = (TypeBPille) lm;
				skriver.println(tbp.skrivTilFil());
			}
			else if(lm instanceof TypeCPille){
				TypeCPille tcp = (TypeCPille) lm;
				skriver.println(tcp.skrivTilFil());
			}
			else if(lm instanceof TypeAMikstur){
				TypeAMikstur tam = (TypeAMikstur) lm;
				skriver.println(tam.skrivTilFil());
			}
			else if(lm instanceof TypeBMikstur){
				TypeBMikstur tbm = (TypeBMikstur) lm;
				skriver.println(tbm.skrivTilFil());
			}
			else if(lm instanceof TypeCMikstur){
				TypeCMikstur tcm = (TypeCMikstur) lm;
				skriver.println(tcm.skrivTilFil());
			}
		}
		skriver.println("");
		skriver.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)");
		for(Lege l : leger){
			skriver.println(l.skrivTilFil());
		}
		skriver.println("");
		skriver.println("# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)");
		for(Object r : reseptListe){ 
			Resept temp = (Resept)r;
			skriver.println(temp.skrivTilFil());
		}
		skriver.println("");
		skriver.println("# Slutt");
		skriver.close();	
	}
	
	public static void skrivUt(){
		//pasienter
		System.out.println("Liste over alle pasienter:");
		System.out.println("--------------------------");
		for(Pasient p : pasienter){
			System.out.println(p);
		}
		System.out.println("");
		//legemidler
		//maa sorge for at denne kun skriver ut != null
		System.out.println("Liste over alle legemidler:");
		System.out.println("----------------------------");
		if(legemidler.iterator().hasNext() != false){
			for(Legemiddel lm : legemidler){
				System.out.println(lm);
			}
		}
		System.out.println("");
		
		//leger
		System.out.println("Liste over alle leger:");
		System.out.println("----------------------------");
		for(Lege l : leger){
			System.out.println(l);
		}
		System.out.println("");
		
		//resepter
		System.out.println("Liste over alle resepter:");
		System.out.println("----------------------------");
		for(Object r : reseptListe){ 
			Resept temp = (Resept)r;
			System.out.println(r);
		}
		System.out.println("");
	}
	
	//metode som oppretter og legger inn nytt legemiddel 
	public static void opprettNyttLegemiddel(){
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn navn paa legemiddel:");
		String navn = in.nextLine();
		System.out.println("Oppgi pris:");
		double pris = Double.parseDouble(in.nextLine());
		System.out.println("Oppgi mengde:");
		int mengde = Integer.parseInt(in.nextLine());
		System.out.println("Oppgi virkestoff:");
		double mengdeVirkestoff = Integer.parseInt(in.nextLine());
		System.out.println("Oppgi form (pille/mikstur):");
		String form = in.nextLine();
		
		if(form.equalsIgnoreCase("pille")){
			System.out.println("Oppgi type(A, B eller C):");
			String type = in.nextLine();
			
			if(type.equalsIgnoreCase("a")){
				System.out.println("Oppgi styrke:");
				int styrke = Integer.parseInt(in.nextLine());
				opprettTypeAPille(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, styrke, mengde, mengdeVirkestoff);
				System.out.println(navn + " er lagt til.");
			}
			else if(type.equalsIgnoreCase("b")){
				System.out.println("Oppgi hvor vanedannende (1-10)");
				int vanedannende = Integer.parseInt(in.nextLine());
				opprettTypeBPille(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, vanedannende, mengde, mengdeVirkestoff);
			}
			else if(type.equalsIgnoreCase("c")){
				opprettTypeCPille(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, mengde, mengdeVirkestoff);
			}
			else{
				System.out.println("Feil, prov paa nytt.");
			}
		}
		else if(form.equalsIgnoreCase("mikstur")){
			System.out.println("Oppgi type (A, B eller C):");
			String type = in.nextLine();
			if(type.equalsIgnoreCase("a")){
				int styrke = Integer.parseInt(in.nextLine());
				opprettTypeAMikstur(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, styrke, mengde, mengdeVirkestoff);
			}
			else if(type.equalsIgnoreCase("b")){
				int vanedannende = Integer.parseInt(in.nextLine());
				opprettTypeBMikstur(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, vanedannende, mengde, mengdeVirkestoff);
			}
			else if(type.equalsIgnoreCase("c")){
				opprettTypeCMikstur(Integer.toString(legemidler.hentAntallObjekter()), navn, pris, mengde, mengdeVirkestoff);
			}
			else{
				System.out.println("Feil, prov paa nytt.");
			}
	
		}
		else{
			System.out.println("Feil, prov paa nytt.");
		}
	}
	
	public static void opprettNyLege(){
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn navnet paa ny lege:");
		String navn = in.nextLine();
		System.out.println("Skriv inn avtalenummer (0 hvis ingen avtale):");
		int avtaleNummer = Integer.parseInt(in.nextLine());
		
		if(avtaleNummer == 0){
			opprettLege(navn);
		}
		else{
			opprettFastLege(navn, avtaleNummer);
		}
	}
	
	public static void opprettNyPasient(){
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn navnet paa ny pasient:");
		String navn = in.nextLine();
		System.out.println("Skriv inn personnummer:");
		String persNummer = in.nextLine();
		System.out.println("Skriv inn adresse:");
		String adresse = in.nextLine();
		System.out.println("Skriv inn postnummer:");
		String postNummer = in.nextLine();
		opprettPasient(Integer.toString(pasienter.hentAntallObjekter()), navn, persNummer, adresse, postNummer);
	}
	
	public static void opprettNyResept(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv nummeret til legemiddelet:");
		int legemiddelNummer = Integer.parseInt(in.nextLine());
		System.out.println("Skriv inn navnet paa legen:");
		String legeNavn = in.nextLine();
		System.out.println("Skriv inn personlig ID:");
		String persID = in.nextLine();
		System.out.println("Skriv inn antall reit:");
		int reit = Integer.parseInt(in.nextLine());
		System.out.println("Skriv inn pris:");
		int pris = Integer.parseInt(in.nextLine());
		System.out.println("Hvit/blaa resept:");
		String typeResept = in.nextLine();
		
		if(typeResept.equalsIgnoreCase("hvit")){
			opprettHvitResept(reseptListe.hentReseptNummer(), legemidler.finn(legemiddelNummer), legeNavn, persID, reit); 
		}
		else if(typeResept.equalsIgnoreCase("blaa")){
			opprettBlaaResept(reseptListe.hentReseptNummer(), legemidler.finn(legemiddelNummer), legeNavn, persID, reit);
		}
		else{
			System.out.println("Feil, prov paa nytt.");
		}
	}
	
	// metode som skriver ut legemiddel paa resept
	public static void hentLegemiddel() throws KastUnntak{
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn personnummer:");
		String pnummer = in.nextLine();
		for(Pasient pasient : pasienter){
			if(pasient.hentPersonNummer().equals(pnummer)){
				if(pasient != null){
					int pasientIndex = Integer.parseInt(pasient.hentPersId());
					for(Object r : reseptListe){ 
						Resept temp = (Resept)r;
						if(temp.hentPersID().equals(pasient.hentPersId())){
							System.out.println("*** KVITTERING ***");
							System.out.println("Lege:" + temp.hentLegeNavn());
							System.out.println("Personens navn: " + pasient.hentPasientNavn());
							System.out.println("Info (Legemiddelnummer, navn, type, pris, virkestoff):");
							System.out.println(temp.hentLegemiddel().toString());
							System.out.println("Reit: " + temp.hentReit());
							System.out.println("-------------------------");
						}
					}
				}
				else{
					System.out.println("Finner ikke pasienten i systemet.");
				}	
			}
		}
	}

	
	// STATISTIKKER:
	//Testet: OK!
	//metode som skriver ut antall vanedannende resepter + i Oslo.
	public static void hentAntallVanedannendeResepter(){
		int totaltVaneResepter = 0;
		int totaltVaneResIOslo = 0;
		
		for(Object r : reseptListe){ 
			Resept temp = (Resept)r;
			// type B er eneste som inneholder vanedannende
			if(temp.hentLegemiddel() instanceof TypeBMikstur || temp.hentLegemiddel() instanceof TypeBPille){
				totaltVaneResepter++;	
			}
		}
		System.out.println("Totalt vanedannende resepter er: " + totaltVaneResepter);
		System.out.println("---------------------------------------");
		
		for(Pasient p : pasienter){
			if(p.bostedOslo() == true){
				totaltVaneResIOslo++;
			}
		}
		System.out.println("Vanedannende resepter skrevet ut til pasienter i Oslo er: " + totaltVaneResIOslo);
		System.out.println("");
	}
	//Testet: OK!
	//metode som printer ut blaa resepter for gitt pasient.
	public static void hentBlaaResept(){
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn pasientes personlige ID:");
		int idNummer = Integer.parseInt(in.nextLine());
		Pasient pasient = pasienter.finn(idNummer); 
		System.out.println("Oppgitt pasient har folgende blaa resepter:");
		if(pasient != null){
			for(Object r : pasient.hentYFReseptListe()){ 
				Resept temp = (Resept)r;
				if(r instanceof BlaaResept){
					System.out.println(r);
				}
				else{
					System.out.println("Kunne ikke finne pasienten i systemet.");
				}
			}
		}
	}
	
	
	public static void hentReseptPerLege(){
		//kun mikstur, skal ogsaa skrive ut total mengde virkestoff fordelt
		//paa pille og mikstur
		Scanner in = new Scanner(System.in);
		System.out.println("Skriv inn navnet paa legen: ");
		String lnavn = in.nextLine();
		Lege lege = leger.finnElement(lnavn);
		if(lege != null){
			for (Object r : lege.hentEFReseptListe()){
				Resept temp = (Resept)r; 
				if (temp.hentLegemiddel() instanceof Mikstur){
					System.out.println(r);
				}
				else{
					System.out.println("Kunne ikke finne legen i systemet.");
				}
		
			}
		}	
	}
	
	//Testet - ikke OK!
	public static void antallNarkotiskeResepterPerLege(){
		//skal skrive ut leger med narkotisk resept og antallet resepter
		int antallNarkotiskeResepter = 0;
		System.out.println("Liste over leger som har skrevet ut narkotiske legemidler:");
		for(Object r : reseptListe){ 
			Resept temp = (Resept)r;
			if(temp.hentLegemiddel().equals("TypeAPille") || temp.hentLegemiddel().equals("TypeAMikstur")){
				antallNarkotiskeResepter++;
			}
		}
		System.out.println(antallNarkotiskeResepter);
	}
	
	//Testet:
	public static void hentPasienterMedNarkotiskResept(){
		int antallNarkotiskeResepterPerPasient = 0;
		System.out.println("Liste over pasienter som har gyldig resept paa narkotisk legemiddel:");
		for(Pasient pasient : pasienter){
			for(Object r : reseptListe){
				Resept temp = (Resept)r;
				if(temp.hentLegemiddel() instanceof TypeAPille || temp.hentLegemiddel() instanceof TypeAMikstur){
					if(temp.hentReit() > 0){
						antallNarkotiskeResepterPerPasient++;
					}
				}
			}
			if(antallNarkotiskeResepterPerPasient > 0){
				System.out.println(pasient.hentPasientNavn() + " har " + antallNarkotiskeResepterPerPasient + " narkotisk(e) legemidler.");
			}
		}
	}
	
	public static void skrivMeny(){
		System.out.println("****** MENY ******");
		System.out.println("-------------------");
		System.out.println("1. Les inn fil.");
		System.out.println("2. Skriv til fil.");
		System.out.println("3. Opprett nytt legemiddel.");
		System.out.println("4. Opprett ny lege.");
		System.out.println("5. Opprett ny pasient.");
		System.out.println("6. Opprett ny resept.");
		System.out.println("7. Hent legemiddel (skriver ut kvittering)");
		System.out.println("8. Skriv ut all informasjon.");
		System.out.println("9. Skriv ut statistikk.");
		System.out.println("10. Avslutt.");
	}
	
	public static void statistikkMeny(){
		System.out.println("**** MENY FOR STATISTIKKER ****");
		System.out.println("--------------------------------");
		System.out.println("1. Hent antall vanedannende resepter.");
		System.out.println("2. Hent blaa resepter for gitt pasient.");
		System.out.println("3. Hent resepter per lege.");
		System.out.println("4. Hent antall resepter per lege.");
		System.out.println("5. Vis oversikt over pasienter med narkotiske resepter.");
		System.out.println("6. Tilbake til hovedmeny.");
	}
	
	public static void utfoerKommandoer() throws FileNotFoundException, KastUnntak{
		Scanner in = new Scanner(System.in);
		skrivMeny();
		int valg = Integer.parseInt(in.nextLine());
		while(valg != 10){
			if(valg == 1){
				lesInnFil();
			}
			else if(valg == 2){
				skrivTilFil();
			}
			else if(valg == 3){
				opprettNyttLegemiddel();
			}
			else if(valg == 4){
				opprettNyLege();
			}
			else if(valg == 5){
				opprettNyPasient();
			}
			else if(valg == 6){
				opprettNyResept();
			}
			else if(valg == 7){
				hentLegemiddel();
			}
			else if(valg == 8){
				skrivUt();
			}
			if(valg == 9){
				statistikkMeny();
				valg = Integer.parseInt(in.nextLine());
				if(valg == 1){
					hentAntallVanedannendeResepter();
				}
				else if(valg == 2){
					hentBlaaResept();
				}
				else if(valg == 3){
					hentReseptPerLege();
				}
				else if(valg == 4){
					antallNarkotiskeResepterPerLege();
				}
				else if(valg == 5){
					hentPasienterMedNarkotiskResept();
				}
				else if(valg < 1 || valg > 9){
					System.out.println("Ugyldig valg.");
				}
				else if(valg == 6){
					skrivMeny();
				}
			}
			else if(valg < 1 || valg > 10){
				System.out.println("Ugyldig valg.");
			}
			skrivMeny();
			valg = Integer.parseInt(in.nextLine());	
		}
	
		if (valg == 10) {
			System.out.println("Program avsluttes.");
		}
	}

	
	
}
