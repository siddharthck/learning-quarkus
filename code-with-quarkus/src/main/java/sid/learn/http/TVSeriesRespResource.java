package sid.learn.http;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@Path("/singlesearch")
public class TVSeriesRespResource {

    private final TVSeriesRetrivalService tvSeriesRetrivalService;
    //private final String company;
    private final TVSeriesResponse response;


    public TVSeriesRespResource() {
        //company = "api.tvmaze.com";

        tvSeriesRetrivalService = RestClientBuilder.newBuilder()
            .baseUri(URI.create("https://api.tvmaze.com"))
            .build(TVSeriesRetrivalService.class);
        response = tvSeriesRetrivalService.query("girls");

    }

    @Path("/shows")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response query(String query) {
        return Response.ok(response).build();
    }



}
