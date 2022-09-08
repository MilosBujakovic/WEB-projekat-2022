package servisi;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import modeli.Korisnik;
import repozitorijumi.KorisnikRepozitorijum;

// Login
@Path("")
public class LoginServis {
	@Context
	ServletContext ctx;
	
	public LoginServis() {
		
	}
	
	@PostConstruct
	public void init() {
		if (ctx.getAttribute("korisnikRepo") == null) {
	    	String contextPath = ctx.getRealPath("");
			ctx.setAttribute("korisnikRepo", new KorisnikRepozitorijum(contextPath));
		}
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Korisnik korisnik, @Context HttpServletRequest request) {
		KorisnikRepozitorijum korisnikRepo = (KorisnikRepozitorijum) ctx.getAttribute("korisnikRepo");
		Korisnik logovani = korisnikRepo.findByKorisnickoIme(korisnik.getKorisnickoIme());
		if (logovani != null) {
			return Response.status(400).entity("Invalid username and/or password").build();
		}
		request.getSession().setAttribute("korisnik", logovani);
		return Response.status(200).build();
	}
	
	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void logout(@Context HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	@GET
	@Path("/korisnik")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Korisnik login(@Context HttpServletRequest request) {
		return (Korisnik) request.getSession().getAttribute("korisnik");
	}
}
