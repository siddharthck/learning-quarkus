package sid.learn.http.logingest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

public class LogIngestExceptionMapper implements ResponseExceptionMapper<LogIngestException> {

    @Override
    public LogIngestException toThrowable(Response response) {
        return new LogIngestException("please try again bro error code : " + response.getStatus());
    }
}
