package sid.learn.http.TVSeries;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/singlesearch")
public interface TVSeriesRemoteAPIClient {

    @GET
    @Path("/shows")
    @Produces(MediaType.APPLICATION_JSON)
    TVSeriesPOJO getInfo(@QueryParam("q") String query);


}
