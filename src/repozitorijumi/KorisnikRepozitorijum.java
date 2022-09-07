package repozitorijumi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import modeli.Korisnik;

public class KorisnikRepozitorijum
{
	
	IspisServis ispisServis;
	UnosServis unosServis;
	
	public Korisnik save(Korisnik korisnik)
	{
	  try {
	      File fajl = new File("filename.txt");
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
	
	public List<Korisnik> saveAll(List<Korisnik> korisnici)
	{
		try 
		{
		      File fajl = new File("korisnici.txt");
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
			      
			      save(korisnik);
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
	
	public Korisnik findByKorisnickoIme(String korisnickoIme)
	{
		List<Korisnik> korisnici = this.findAll();
			
		for(Korisnik k : korisnici)
		{
			if(k.getKorisnickoIme().equals(korisnickoIme)) return k;
			else continue;
		}
		return null;
	}
	
	public List<Korisnik> findAll()
	{
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		prviProlaz(korisnici);
		drugiProlaz(korisnici);
		return korisnici;
		
	}
	
	public List<Korisnik> prviProlaz(List<Korisnik> korisnici)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
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
	
	public List<Korisnik> drugiProlaz(List<Korisnik> korisnici)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("korisnici.txt"));
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
