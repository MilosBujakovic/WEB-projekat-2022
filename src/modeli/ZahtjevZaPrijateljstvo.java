package modeli;

public class ZahtjevZaPrijateljstvo
{
	private Korisnik posiljalac;
	private Korisnik primalac;
	private StatusZahtjeva status;
	private String datum;
	
	
	public Korisnik getPosiljalac()
	{
		return posiljalac;
	}
	public void setPosiljalac(Korisnik posiljalac)
	{
		this.posiljalac = posiljalac;
	}
	public Korisnik getPrimalac()
	{
		return primalac;
	}
	public void setPrimalac(Korisnik primalac)
	{
		this.primalac = primalac;
	}
	public StatusZahtjeva getStatus()
	{
		return status;
	}
	public void setStatus(StatusZahtjeva status)
	{
		this.status = status;
	}
	public String getDatum()
	{
		return datum;
	}
	public void setDatum(String datum)
	{
		this.datum = datum;
	}
	
	
}
