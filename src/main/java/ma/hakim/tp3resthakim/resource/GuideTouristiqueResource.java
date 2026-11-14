package ma.hakim.tp3resthakim.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import ma.hakim.tp3resthakim.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Donne les principaux endroits à visiter dans une ville ou un pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return un document JSON avec les endroits à visiter
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return llmClient.envoyerRequete(villeOuPays);
    }
}
