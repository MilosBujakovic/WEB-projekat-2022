package servisi;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DAO.KorisnikDAO;
import modeli.Korisnik;

@Path("")
public class RegistracijaServis {
	@Context
	ServletContext ctx;

	public RegistracijaServis() {

	}

	@PostConstruct
	public void init() {
		if (ctx.getAttribute("korisnikDAO") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("korisnikDAO", new KorisnikDAO(contextPath));
		}
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Korisnik korisnik, @Context HttpServletRequest request) {
		KorisnikDAO korisnikDao = (KorisnikDAO) ctx.getAttribute("korisnikDAO");
		Korisnik novi = korisnikDao.find(korisnik.getKorisnickoIme(), korisnik.getLozinka());
		if (novi != null) {
			return Response.status(0).entity("Vec postojeci korisnik").build();
		}
		korisnikDao.dodajKorisnika(korisnik);
		ctx.setAttribute("korisnikDAO", korisnikDao);
		return Response.status(200).build();
	}

}
