package modeli;

import java.util.List;

public class ZahtjevZaPrijateljstvo
{
	private String posiljalac;
	private String primalac;
	private StatusZahtjeva status;
	private String datum;
	
	private long id;
	
	public long getId()
	{
		return id;
	}
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getPosiljalac()
	{
		return posiljalac;
	}
	public void setPosiljalac(String posiljalac)
	{
		this.posiljalac = posiljalac;
	}
	public String getPrimalac()
	{
		return primalac;
	}
	public void setPrimalac(String primalac)
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
