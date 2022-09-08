package DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import modeli.StatusZahtjeva;
import modeli.ZahtjevZaPrijateljstvo;

public class ZahtevDAO {
	private List<ZahtjevZaPrijateljstvo> zahtevi = new ArrayList<ZahtjevZaPrijateljstvo>();

	public ZahtevDAO() {

	}

	public ZahtevDAO(String contextPath) {
		ucitajZahteve(contextPath);
	}

	public List<ZahtjevZaPrijateljstvo> ucitajZahteveKorisnika(String korisnickoIme) {
		List<ZahtjevZaPrijateljstvo> zahteviKorisnika = new ArrayList<ZahtjevZaPrijateljstvo>();
		for (ZahtjevZaPrijateljstvo zahtjevZaPrijateljstvo : zahtevi) {
			if (zahtjevZaPrijateljstvo.getStatus().equals(StatusZahtjeva.CEKANJE))
				if (zahtjevZaPrijateljstvo.getPrimalac().equals(korisnickoIme))
					zahteviKorisnika.add(zahtjevZaPrijateljstvo);
		}
		return zahteviKorisnika;
	}

	public Collection<ZahtjevZaPrijateljstvo> findAll() {
		return zahtevi;
	}

	private void ucitajZahteve(String contextPath) {
		BufferedReader in = null;
		try {
			File file = new File(contextPath + "/zahtevi.txt");
			in = new BufferedReader(new FileReader(file));
			String line;
			StringTokenizer st;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				if (line.equals("") || line.indexOf('#') == 0)
					continue;
				st = new StringTokenizer(line, ";");
				while (st.hasMoreTokens()) {
					String posiljalac = st.nextToken().trim();
					String primalac = st.nextToken().trim();
					String status = st.nextToken().trim();
					String datum = st.nextToken().trim();
					// red txt fajla: posiljalacKI;primalacKI;status;datum
					zahtevi.add(new ZahtjevZaPrijateljstvo());
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
