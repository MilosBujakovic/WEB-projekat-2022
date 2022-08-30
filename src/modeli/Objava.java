package modeli;

import java.util.List;

public class Objava
{
	private String slika;
	private String tekst;
	private List<Komentar> komentari;
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
