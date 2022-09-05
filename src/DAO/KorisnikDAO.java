package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import modeli.Korisnik;

public class KorisnikDAO {
	private Map<String, Korisnik> korisnici = new HashMap<>();

	public KorisnikDAO() {

	}

	public KorisnikDAO(String contextPath) {
		ucitajKorisnike(contextPath);
	}

	public Korisnik find(String korisnickoIme, String lozinka) {
		if (!korisnici.containsKey(korisnickoIme)) {
			return null;
		}
		Korisnik korisnik = korisnici.get(korisnickoIme);
		if (!korisnik.getLozinka().equals(lozinka)) {
			return null;
		}
		return korisnik;
	}

	public void dodajKorisnika(Korisnik korisnik) {
		korisnici.put(korisnik.getKorisnickoIme(), korisnik);
	}

	public Collection<Korisnik> nadjiSve() {
		return korisnici.values();
	}

	private void ucitajKorisnike(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/korisnici.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					String ime = st.nextToken().trim();
					String prezime = st.nextToken().trim();
					String email = st.nextToken().trim();
					String korisnickoIme = st.nextToken().trim();
					String lozinka = st.nextToken().trim();
					String uloga = st.nextToken().trim();
					String tipNaloga = st.nextToken().trim();
					// Dodati polja potrebna za korisnike
					// red txt fajla: ime;prezime;email;korisnickoIme;lozinka;uloga;tipNaloga
					korisnici.put(korisnickoIme, new Korisnik());
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
