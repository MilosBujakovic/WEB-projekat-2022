package modeli;

import java.util.List;

public class Komentar 
{

	private String korisnikckoIme;
	private String tekst;
	private String datumKomentara;
	private String datumIzmjene;
	
	private long id;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public Komentar() {}

	public String getKorisnickoIme()
	{
		return korisnikckoIme;
	}

	public void setKorisnickoIme(String korisnikckoIme)
	{
		this.korisnikckoIme = korisnikckoIme;
	}

	public String getTekst()
	{
		return tekst;
	}

	public void setTekst(String tekst)
	{
		this.tekst = tekst;
	}

	public String getDatumKomentara()
	{
		return datumKomentara;
	}

	public void setDatumKomentara(String datumKomentara)
	{
		this.datumKomentara = datumKomentara;
	}

	public String getDatumIzmjene()
	{
		return datumIzmjene;
	}

	public void setDatumIzmjene(String datumIzmjene)
	{
		this.datumIzmjene = datumIzmjene;
	}
	

	
}
