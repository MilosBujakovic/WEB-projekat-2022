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
import repozitorijumi.KorisnikRepozitorijum;

@Path("")
public class RegistracijaServis {
	@Context
	ServletContext ctx;

	public RegistracijaServis() {

	}

	@PostConstruct
	public void init() {
		if (ctx.getAttribute("korisnikRepo") == null) {
			String contextPath = ctx.getRealPath("");
			ctx.setAttribute("korisnikRepo", new KorisnikRepozitorijum(contextPath));
		}
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Korisnik korisnik, @Context HttpServletRequest request) {
		KorisnikRepozitorijum korisnikRepo = (KorisnikRepozitorijum) ctx.getAttribute("korisnikRepo");
		Korisnik novi = korisnikRepo.findByKorisnickoIme(korisnik.getKorisnickoIme());
		if (novi != null) {
			return Response.status(0).entity("Vec postojeci korisnik").build();
		}
		korisnikRepo.save(korisnik);
		String contextPath = ctx.getRealPath("");
		ctx.setAttribute("korisnikRepo", new KorisnikRepozitorijum(contextPath));
		return Response.status(200).build();
	}

}
