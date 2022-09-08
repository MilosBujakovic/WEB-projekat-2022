package repozitorijumi;

import java.util.List;

import modeli.Komentar;
import modeli.Korisnik;
import modeli.Objava;
import modeli.ProfilnaSlika;
import modeli.Sanduce;
import modeli.ZahtjevZaPrijateljstvo;

public class IspisServis
{
	String[] delimiteri = {"|", ",", "#", "@"};
	
	public String korisnikZaUpis(Korisnik k, int nivoDelimitera)
	{
			return k.getKorisnickoIme()+ delimiteri[nivoDelimitera] + k.getStatus().toString() + delimiteri[nivoDelimitera] + k.getUloga() + delimiteri[nivoDelimitera] + k.getTipNaloga() + delimiteri[nivoDelimitera] + k.getLozinka()
			+ delimiteri[nivoDelimitera] + k.getEmail() + delimiteri[nivoDelimitera] + k.getIme()	+ delimiteri[nivoDelimitera] + k.getPrezime() + delimiteri[nivoDelimitera] + k.getDatumRodjenja()
			+ delimiteri[nivoDelimitera] + k.getPol()	+ delimiteri[nivoDelimitera] + profilneUstring(k.getProfilneSlike(), nivoDelimitera+1) + delimiteri[nivoDelimitera] + objaveUstring(k.getObjave(), nivoDelimitera+1)
			+ delimiteri[nivoDelimitera] + zahtjeviUstring(k.getZahtjeviZaPrijateljstvo(), nivoDelimitera+1) + delimiteri[nivoDelimitera] + listaUstring(k.getListaPrijatelja(), nivoDelimitera+1)
			+ delimiteri[nivoDelimitera] + sanducadUstring(k.getInbox(), nivoDelimitera+1);
	}
	
	
	public String zahtjeviUstring(List<ZahtjevZaPrijateljstvo> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(ZahtjevZaPrijateljstvo k : lista)
		{
			izlaz.concat(zahtjevUstring(k, nivoDelimitera+1) + delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	public String zahtjevUstring(ZahtjevZaPrijateljstvo zahtjev, int nivoDelimitera)
	{
		return zahtjev.getId()+delimiteri[nivoDelimitera]+zahtjev.getPosiljalac()+
		delimiteri[nivoDelimitera]+zahtjev.getPrimalac()+delimiteri[nivoDelimitera]+
		zahtjev.getDatum()+delimiteri[nivoDelimitera]+zahtjev.getStatus().toString();
	}
	
	public String sanducadUstring(List<Sanduce> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(Sanduce k : lista)
		{
			izlaz.concat(sanduceUstring(k, nivoDelimitera+1)+delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	
	public String sanduceUstring(Sanduce sanduce, int nivoDelimitera) //TODO: dodati status
	{
		return sanduce.getId()+ delimiteri[nivoDelimitera] + sanduce.getStatus().toString()
		+delimiteri[nivoDelimitera]+sanduce.getPosiljalac()+
		delimiteri[nivoDelimitera]+sanduce.getPrimalac()+delimiteri[nivoDelimitera]+
		sanduce.getPoruke();
	}
	
	public String profilneUstring(List<ProfilnaSlika> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(ProfilnaSlika k : lista)
		{
			izlaz.concat(profilnaSlikaUstring(k, nivoDelimitera+1)+delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	
	public String profilnaSlikaUstring(ProfilnaSlika profilna, int nivoDelimitera)
	{
		return profilna.getId()+delimiteri[nivoDelimitera]+
		profilna.getKorisnickoIme()+ delimiteri[nivoDelimitera] + profilna.getStatus().toString()+
		delimiteri[nivoDelimitera]+profilna.getLinkSlike()+
		delimiteri[nivoDelimitera]+profilna.getOpis()+delimiteri[nivoDelimitera]+
		komentariUstring(profilna.getKomentari(), nivoDelimitera+1);
	}
	
	public String objaveUstring(List<Objava> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(Objava k : lista)
		{
			izlaz.concat(objavaUstring(k, nivoDelimitera+1)+delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	
	public String objavaUstring(Objava objava, int nivoDelimitera)
	{
		return objava.getId()+delimiteri[nivoDelimitera]+
				objava.getKorisnickoIme()+ delimiteri[nivoDelimitera] + objava.getStatus().toString()
				+delimiteri[nivoDelimitera]+objava.getSlika()+
				delimiteri[nivoDelimitera]+objava.getTekst()+delimiteri[nivoDelimitera]+
				komentariUstring(objava.getKomentari(), nivoDelimitera+1);
	}
	
	public String prijateljiUstring(List<Korisnik> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(Korisnik k : lista)
		{
			izlaz.concat(k.getKorisnickoIme()+delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	
	
	public String komentariUstring(List<Komentar> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(Komentar k : lista)
		{
			izlaz.concat(k.getId()+delimiteri[nivoDelimitera]);
		}
		return izlaz;
		
	}
	
	public String komentarUstring(Komentar komentar, int nivoDelimitera)
	{
		return komentar.getId()+delimiteri[nivoDelimitera]+
				komentar.getKorisnickoIme()+ delimiteri[nivoDelimitera] + komentar.getStatus().toString()
				+delimiteri[nivoDelimitera]+komentar.getTekst()+
				delimiteri[nivoDelimitera]+komentar.getDatumKomentara()+delimiteri[nivoDelimitera]+
				komentar.getDatumIzmjene();
	}
	
	public String listaUstring(List<String> lista, int nivoDelimitera)
	{
		String izlaz="";
		for(String elem : lista)
		{
			izlaz.concat(elem+delimiteri[nivoDelimitera]);
		}
		return izlaz;
	}
}
