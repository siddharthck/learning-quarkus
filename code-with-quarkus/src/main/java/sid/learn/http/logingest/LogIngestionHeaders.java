package sid.learn.http.logingest;

import javax.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

public class LogIngestionHeaders implements ClientHeadersFactory {

    @Override
    public MultivaluedMap<String,String> update(
        MultivaluedMap<String,String> incoming,
        MultivaluedMap<String,String> outging ) {

        return null;
    }


}
