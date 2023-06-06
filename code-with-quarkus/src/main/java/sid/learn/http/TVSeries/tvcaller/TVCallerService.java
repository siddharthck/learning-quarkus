package sid.learn.http.TVSeries.tvcaller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/content")
@RegisterRestClient
public interface TVCallerService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Response get(@QueryParam("q") String q);

}
