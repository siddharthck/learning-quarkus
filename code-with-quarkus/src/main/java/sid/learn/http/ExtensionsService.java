package sid.learn.http;

import javax.enterprise.inject.spi.Extension;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Set;

@Path("/extensions")
public interface ExtensionsService {

    @GET
    @Path("/extension")
    Set<Extension> getById(@QueryParam("q") String id);
}
