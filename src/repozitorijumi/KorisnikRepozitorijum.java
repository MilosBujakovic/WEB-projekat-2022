package repozitorijumi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;

import modeli.Korisnik;
import modeli.Status;

public class KorisnikRepozitorijum
{
	
	public KorisnikRepozitorijum() {
	}
	
	IspisServis ispisServis;
	UnosServis unosServis;
	
	public Korisnik save(Korisnik korisnik, String contextPath)
	{
	  try {
	      File fajl = new File(contextPath + "/korisnici.txt");
	      if (fajl.createNewFile()) 
	      {
	        System.out.println("File created: " + fajl.getName());
	      } 
	      else 
	      {
	        System.out.println("File already exists.");
	      }
	      
	      PrintWriter pw = new PrintWriter(new FileWriter(fajl.getName(), true));
	      pw.println(ispisServis.korisnikZaUpis(korisnik, 0));//NIVO DELIMITERA
	      System.out.println("Korisnik upisan!");
	      pw.flush();
	      pw.close();
	    }
		catch (IOException e) 
		{
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	  	
		return korisnik;
	}
	
	public List<Korisnik> saveAll(List<Korisnik> korisnici, String contextPath)
	{
		try 
		{
		      File fajl = new File(contextPath + "/korisnici.txt");
		      if (fajl.createNewFile()) 
		      {
		        System.out.println("File created: " + fajl.getName());
		      } 
		      else 
		      {
		        System.out.println("File already exists.");
		      }
		      for(Korisnik korisnik : korisnici)
		      {
			      
			      save(korisnik, contextPath);
			      System.out.println("Korisnik upisan!");
		      }
	    }
		catch (IOException e) 
		{
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    } 
		return korisnici;
	}
	
	public Korisnik findByKorisnickoIme(String korisnickoIme, String contextPath)
	{
		Korisnik kor = null;	
		List<Korisnik> korisnici = this.findAll(contextPath);
			
		for(Korisnik k : korisnici)
		{
			if(k.getKorisnickoIme().equals(korisnickoIme)) kor = k;
			else continue;
		}
		if(kor==null) throw new WebApplicationException("Korisnik ne postoji!", 404);
		return kor;
	}
	
	public List<Korisnik> findAll(String contextPath)
	{
		System.out.println(contextPath);
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		prviProlaz(korisnici, contextPath);
		drugiProlaz(korisnici, contextPath);
		korisnici.removeIf(korisnik -> korisnik.getStatus()==Status.OBRISAN);
		System.out.println(korisnici);
		return korisnici;
		
	}
	
	public List<Korisnik> prviProlaz(List<Korisnik> korisnici, String contextPath)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(contextPath + "/korisnici.txt"));
			String linija;
			while((linija = br.readLine()) !=null)
			{
				System.out.println(linija);
				korisnici.add(unosServis.stringUkorisnikOsnovni(linija));
			}
			br.close();
		}
		catch(IOException e)
		{
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		return korisnici;
	}
	
	public List<Korisnik> drugiProlaz(List<Korisnik> korisnici, String contextPath)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(contextPath + "/korisnici.txt"));
			String linija;
			while((linija = br.readLine()) !=null)
			{
				System.out.println(linija);
				unosServis.stringUkorisnikVeze(linija, korisnici);
				
			}
			br.close();
		}
		catch(IOException e)
		{
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
		return korisnici;
	}
	
	public void delete(String korisnickoIme)
	{
		//TODO: EDIT FLAG-A ZA LOGICKO BRISANJE???
	}
	
	
}
