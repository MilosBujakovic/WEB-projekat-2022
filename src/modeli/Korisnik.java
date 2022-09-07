package modeli;

import java.util.List;

public class Korisnik
{
	private String korisnickoIme; //TODO: jedinstveno
	private String lozinka;
	private String email;
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String pol;
	private Uloga uloga;
	private List<ProfilnaSlika> profilneSlike;
	private List<Objava> objave;
	private List<ZahtjevZaPrijateljstvo> zahtjeviZaPrijateljstvo;
	private List<String> listaPrijatelja;
	private TipNaloga tipNaloga;
	private List<Sanduce> inbox;
	
	private Status status;
	
	public Korisnik()
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

	public String getKorisnickoIme()
	{
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme)
	{
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka()
	{
		return lozinka;
	}
	public void setLozinka(String lozinka)
	{
		this.lozinka = lozinka;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getIme()
	{
		return ime;
	}
	public void setIme(String ime)
	{
		this.ime = ime;
	}
	public String getPrezime()
	{
		return prezime;
	}
	public void setPrezime(String prezime)
	{
		this.prezime = prezime;
	}
	public String getDatumRodjenja()
	{
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja)
	{
		this.datumRodjenja = datumRodjenja;
	}
	public String getPol()
	{
		return pol;
	}
	public void setPol(String pol)
	{
		this.pol = pol;
	}
	public Uloga getUloga()
	{
		return uloga;
	}
	public void setUloga(Uloga uloga)
	{
		this.uloga = uloga;
	}
	public List<ProfilnaSlika> getProfilneSlike()
	{
		return profilneSlike;
	}
	public void setProfilneSlike(List<ProfilnaSlika> profilnaSlika)
	{
		this.profilneSlike = profilnaSlika;
	}
	public List<Objava> getObjave()
	{
		return objave;
	}
	public void setObjave(List<Objava> objave)
	{
		this.objave = objave;
	}
	public List<ZahtjevZaPrijateljstvo> getZahtjeviZaPrijateljstvo()
	{
		return zahtjeviZaPrijateljstvo;
	}
	public void setZahtjeviZaPrijateljstvo(List<ZahtjevZaPrijateljstvo> zahtjeviZaPrijateljstvo)
	{
		this.zahtjeviZaPrijateljstvo = zahtjeviZaPrijateljstvo;
	}
	public List<String> getListaPrijatelja()
	{
		return listaPrijatelja;
	}
	public void setListaPrijatelja(List<String> listaPrijatelja)
	{
		this.listaPrijatelja = listaPrijatelja;
	}
	public TipNaloga getTipNaloga()
	{
		return tipNaloga;
	}
	public void setTipNaloga(TipNaloga tipNaloga)
	{
		this.tipNaloga = tipNaloga;
	}
	public List<Sanduce> getInbox()
	{
		return inbox;
	}
	public void setInbox(List<Sanduce> inbox)
	{
		this.inbox = inbox;
	}
	
	



	
	
}
