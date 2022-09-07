package repozitorijumi;

import java.util.ArrayList;
import java.util.List;

import modeli.Komentar;
import modeli.Korisnik;
import modeli.Objava;
import modeli.ProfilnaSlika;
import modeli.Sanduce;
import modeli.Status;
import modeli.StatusZahtjeva;
import modeli.TipNaloga;
import modeli.Uloga;
import modeli.ZahtjevZaPrijateljstvo;

public class UnosServis
{
	String[] delimiteri = {"|", ",", "#", "@"};
	
	public Korisnik stringUkorisnikOsnovni(String linija)
	{
		String[] podaci = linija.split("\\|");
		Korisnik kor = new Korisnik();
		kor.setKorisnickoIme(podaci[0]);
		kor.setStatus(Status.valueOf(podaci[1]));
		kor.setUloga(Uloga.valueOf(podaci[2]));
		kor.setTipNaloga(TipNaloga.valueOf(podaci[3]));
		kor.setLozinka(podaci[4]);
		kor.setEmail(podaci[5]);
		kor.setIme(podaci[6]);
		kor.setPrezime(podaci[7]);
		kor.setDatumRodjenja(podaci[8]);
		kor.setPol(podaci[9]);
		
		//+ "|" + profilneUstring(k.getProfilneSlike()) + "|" + objaveUstring(k.getObjave())
		//+ "|" + zahtjeviUstring(k.getZahtjeviZaPrijateljstvo()) + "|" + korisniciUstring(k.getListaPrijatelja())
		//+ "|" + sanducadUstring(k.getInbox());
		return kor;
	}
	
	public List<Korisnik> stringUkorisnikVeze(String linija, List<Korisnik> korisnici)
	{
		String[] podaci = linija.split("\\|");
		
		for(Korisnik kor : korisnici) if(kor.getStatus() == Status.AKTIVAN)
		{			
			kor.setProfilneSlike(stringUprofilne(podaci[10], 1));
			kor.setObjave(stringUobjave(podaci[11], 1));
			kor.setZahtjeviZaPrijateljstvo(stringUzahtjeve(podaci[12], 1));
			kor.setInbox(stringUsanducad(podaci[13], 1));
		}
		
		//+ "|" + profilneUstring(k.getProfilneSlike()) + "|" + objaveUstring(k.getObjave())
		//+ "|" + zahtjeviUstring(k.getZahtjeviZaPrijateljstvo()) + "|" + korisniciUstring(k.getListaPrijatelja())
		//+ "|" + sanducadUstring(k.getInbox());
		return korisnici;
	}
	


	private List<Objava> stringUobjave(String str, int nivoDelimitera)
	{
		List<Objava> objaveKorisnika = new ArrayList<Objava>();
		String podaci[] = str.split(delimiteri[nivoDelimitera]);
		for(String profilna : podaci)
		{
			objaveKorisnika.add(stringUobjavu(profilna, nivoDelimitera+1));
		}
		return objaveKorisnika;
	}

	private Objava stringUobjavu(String str, int nivoDelimitera)
	{
		String podaci[] = str.split(delimiteri[nivoDelimitera]);
		if(Status.valueOf(podaci[2])==Status.AKTIVAN)
		{
			Objava objava = new Objava();
			objava.setId(Integer.parseInt(podaci[0]));
			objava.setKorisnickoIme(podaci[1]);
			objava.setStatus(Status.valueOf(podaci[2]));
			objava.setSlika(podaci[3]);
			objava.setTekst(podaci[4]);
			objava.setKomentari(stringUkomentare(podaci[5], nivoDelimitera+1));
			return objava;
		}
		else return null;
	}
	
	private List<ProfilnaSlika> stringUprofilne(String str, int nivoDelimitera)
	{
		List<ProfilnaSlika> profilneKorisnika = new ArrayList<ProfilnaSlika>();
		String podaci[] = str.split(delimiteri[nivoDelimitera]);
		for(String profilna : podaci)
		{
			profilneKorisnika.add(stringUprofilnu(profilna, nivoDelimitera+1));
		}
		return profilneKorisnika;
	}
	
	public ProfilnaSlika stringUprofilnu(String str, int nivoDelimitera)
	{
		String podaci[] = str.split(delimiteri[nivoDelimitera]);
		if(Status.valueOf(podaci[2])==Status.AKTIVAN)
		{
			ProfilnaSlika profilna = new ProfilnaSlika();
			profilna.setId(Integer.parseInt(podaci[0]));
			profilna.setKorisnickoIme(podaci[1]);
			profilna.setStatus(Status.valueOf(podaci[2]));
			profilna.setLinkSlike(podaci[2]);
			profilna.setOpis(podaci[3]);
			profilna.setKomentari(stringUkomentare(podaci[4], nivoDelimitera+1));
			return profilna;
		}
		return null;
	}

	private List<Komentar> stringUkomentare(String str, int nivoDelimitera)
	{
		String podaci[] = str.split(delimiteri[nivoDelimitera]);
		List<Komentar> komentari = new ArrayList<Komentar>();
		for(String podatak : podaci)
		{
			String opaska[] = podatak.split(delimiteri[nivoDelimitera+1]);
			if(Status.valueOf(podaci[2])==Status.AKTIVAN)
			{
				Komentar komentar = new Komentar();
				komentar.setId(Integer.parseInt(opaska[0]));
				komentar.setKorisnickoIme(opaska[1]);
				komentar.setStatus(Status.valueOf(podaci[2]));
				komentar.setTekst(opaska[3]);
				komentar.setDatumKomentara(opaska[4]);
				komentar.setDatumIzmjene(opaska[5]);
				komentari.add(komentar);
			}
		}
		return komentari;
	}

	public List<ZahtjevZaPrijateljstvo> stringUzahtjeve(String str, int nivoDelimitera)
	{
		List<ZahtjevZaPrijateljstvo> listaZahtjeva= new ArrayList<ZahtjevZaPrijateljstvo>();
		String zahtjevi[] = str.split(delimiteri[nivoDelimitera]);
		for(String podaci : zahtjevi)
		{
			String podatak[] = podaci.split(delimiteri[nivoDelimitera+1]);
			ZahtjevZaPrijateljstvo zahtjev = new ZahtjevZaPrijateljstvo();
			zahtjev.setId(Integer.parseInt(podatak[0]));
			zahtjev.setPosiljalac(podatak[1]);
			zahtjev.setPrimalac(podatak[2]);
			zahtjev.setDatum(podatak[3]);
			zahtjev.setStatus(StatusZahtjeva.valueOf(podatak[4]));
			listaZahtjeva.add(zahtjev);
		}
		return listaZahtjeva;
		
	}
	
	private List<Sanduce> stringUsanducad(String string, int i)
	{
		// TODO Auto-generated method stub
		return null;
	}
}

