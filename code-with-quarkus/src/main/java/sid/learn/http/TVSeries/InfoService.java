package sid.learn.http.TVSeries;

import io.netty.util.internal.StringUtil;
import java.net.URI;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

public class InfoService {
    public static TVSeriesPOJO getInfoFromAPI(final URI apiUri, final String query) {
        TVSeriesRemoteAPIClient remoteApi = RestClientBuilder.newBuilder()
            .baseUri(apiUri)
            .build(TVSeriesRemoteAPIClient.class);
        if (StringUtil.isNullOrEmpty(query) ) {
            System.out.println("empty query");
        }
        return remoteApi.getInfo(StringUtil.isNullOrEmpty(query) ? "suits" : query);
    }
}
