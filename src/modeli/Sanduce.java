package modeli;

import java.util.List;

public class Sanduce
{
	private long id;
	private String primalac;
	private String posiljalac;
	private List<DirektnaPoruka> poruke;
	
	
	
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getPrimalac()
	{
		return primalac;
	}
	public void setPrimalac(String primalac)
	{
		this.primalac = primalac;
	}
	public String getPosiljalac()
	{
		return posiljalac;
	}
	public void setPosiljalac(String posiljalac)
	{
		this.posiljalac = posiljalac;
	}
	public List<DirektnaPoruka> getPoruke()
	{
		return poruke;
	}
	public void setPoruke(List<DirektnaPoruka> poruke)
	{
		this.poruke = poruke;
	}
	

	
}
