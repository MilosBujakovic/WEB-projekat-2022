package modeli;

import java.util.List;

public class Komentar 
{

	private String korisnickoIme;
	private String tekst;
	private String datumKomentara;
	private String datumIzmjene;
	private Status status;
	
	public Komentar()
	{
		status = Status.AKTIVAN;
	}
	
	public void obrisi()
	{
		this.status = Status.OBRISAN;
	}
	
	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}
	
	private long id;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	

	public String getKorisnickoIme()
	{
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme)
	{
		this.korisnickoIme = korisnickoIme;
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
