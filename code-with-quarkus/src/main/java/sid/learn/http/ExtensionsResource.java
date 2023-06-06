package sid.learn.http;

import javax.enterprise.inject.spi.Extension;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URI;
import java.util.Set;

@Path("/extensions")
public class ExtensionsResource {

    private final ExtensionsService extensionsService;

    public ExtensionsResource() {
        extensionsService = RestClientBuilder.newBuilder()
            .baseUri(URI.create("https://api.tvmaze.com/"))
            .build(ExtensionsService.class);
    }

    @GET
    @Path("/extension")
    public Set<Extension> id(String id) {
        return extensionsService.getById(id);
    }
}
