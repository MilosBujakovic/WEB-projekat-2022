package modeli;

public class Komentar 
{

	private Korisnik korisnik;
	private String tekst;
	private String datumKomentara;
	private String datumIzmjene;
	
	public Komentar() {}

	public Korisnik getKorisnik()
	{
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik)
	{
		this.korisnik = korisnik;
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
