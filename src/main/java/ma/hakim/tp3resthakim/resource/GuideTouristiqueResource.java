package ma.hakim.tp3resthakim.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Donne les principaux endroits à visiter dans une ville ou un pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return un document JSON avec les endroits à visiter
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return new String[]{villeOuPays};
    }
}
