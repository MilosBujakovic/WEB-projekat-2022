package modeli;

import java.util.List;

public class ProfilnaSlika
{
	private long id;
	private String linkSlike;
	private String opis;
	private List<Komentar> komentari;
	
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
	public String getLinkSlike()
	{
		return linkSlike;
	}
	public void setLinkSlike(String linkSlike)
	{
		this.linkSlike = linkSlike;
	}
	public String getOpis()
	{
		return opis;
	}
	public void setOpis(String opis)
	{
		this.opis = opis;
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
