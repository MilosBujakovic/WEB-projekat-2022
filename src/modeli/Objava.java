package modeli;

import java.util.List;

public class Objava
{
	
	private String slika;
	private String tekst;
	private List<Komentar> komentari;
	
	private long id;
	private String korisnickoIme;
	
	
	
	public String getKorisnickoIme()
	{
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme)
	{
		this.korisnickoIme = korisnickoIme;
	}

	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getSlika()
	{
		return slika;
	}
	public void setSlika(String slika)
	{
		this.slika = slika;
	}
	public String getTekst()
	{
		return tekst;
	}
	public void setTekst(String tekst)
	{
		this.tekst = tekst;
	}
	public List<Komentar> getKomentari()
	{
		return komentari;
	}
	public void setKomentari(List<Komentar> komentari)
	{
		this.komentari = komentari;
	}
	

	
}
