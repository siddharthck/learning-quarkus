package sid.learn.http.TVSeries.tvcaller;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sid.learn.http.TVSeries.InfoService;
import sid.learn.http.TVSeries.TVSeriesPOJO;

@Path("/content")
public class TVCallerResource {

   private TVSeriesPOJO tvSeriesPOJO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("q") String q) {

        System.out.println("query = " + q);
        //return Response.ok("hello").build();
        System.out.println("pojo way : query = " + q);

        tvSeriesPOJO = InfoService.getInfoFromAPI(URI.create("https://api.tvmaze.com/"),q);
        return Response.ok(tvSeriesPOJO).build();
    }

}
