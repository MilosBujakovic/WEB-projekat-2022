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

import DAO.KorisnikDAO;
import modeli.Korisnik;
import repozitorijumi.KorisnikRepozitorijum;

@Path("/post")
public class ObjavaServis
{
	@Context
	ServletContext ctx;
	
	
	KorisnikRepozitorijum korisnikRepozitorijum;
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Korisnik korisnik, @Context HttpServletRequest request) {
		KorisnikDAO korisnikDao = (KorisnikDAO) ctx.getAttribute("korisnikDAO");
		
		
		
		ctx.setAttribute("korisnikDAO", korisnikDao);
		return Response.status(200).build();
	}
	
	
}
