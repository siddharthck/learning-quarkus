package sid.learn.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/singlesearch")
public interface TVSeriesRetrivalService {

    @GET
    @Path("/shows")
    TVSeriesResponse query(@QueryParam("q") String query);
}
