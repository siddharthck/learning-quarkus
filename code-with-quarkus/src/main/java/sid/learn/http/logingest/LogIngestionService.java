package sid.learn.http.logingest;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;

@Path("/log/ingest")
@RegisterProvider(LogIngestExceptionMapper.class)
public interface LogIngestionService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "accept",
        value = "application/json")
    public Response sendEvents(@HeaderParam("Authorization") String auth, String events) throws LogIngestException;





}
