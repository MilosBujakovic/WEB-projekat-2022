package modeli;

import java.util.List;

public class ProfilnaSlika
{
	private String linkSlike;
	private String opis;
	private List<Komentar> komentari;
	
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
