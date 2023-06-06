package sid.learn.http.logingest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sendlog")
public interface MockLogIngestionService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendLog(@QueryParam("msg") String msg) throws LogIngestException;

}
