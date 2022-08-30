package modeli;

import java.util.List;

public class Sanduce
{
	private Korisnik primalac;
	private Korisnik posiljalac;
	private List<DirektnaPoruka> poruke;
	public Korisnik getPrimalac()
	{
		return primalac;
	}
	public void setPrimalac(Korisnik primalac)
	{
		this.primalac = primalac;
	}
	public Korisnik getPosiljalac()
	{
		return posiljalac;
	}
	public void setPosiljalac(Korisnik posiljalac)
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
