package sid.learn.http.logingest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import sid.learn.http.TVSeries.TVSeriesRemoteAPIClient;
import org.json.JSONObject;

public class LogIngester {

    public static String id = "mh84cmaf32Mp844zMF8X8=D";
    public static String key = "lma_bX=WsE6D7a(2kz2t73+Siu=N}688~pX-4kyP388-Y5Z9j8Q(I~57LZ_pc^]bLNjNkNTBmOGUtZmQwNC00OGRhLTg5MTUtNTg5OWUzMWU3YWIwL2D3lHY";
    public static String company = "qauat01";


    public static String generateToken(final String payload){

        final Instant timestamp = Instant.now();
        final String body = "POST" + timestamp.toEpochMilli() + payload + "/log/ingest";
        final byte[] digest = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key)
            .hmacHex(body)
            .getBytes();
        return String.format("%s %s:%s:%d", "LMv1", id,
            Base64.getEncoder().encodeToString(digest), timestamp.toEpochMilli());

    }



    public static Response sendEvents(List<LogMsg> list) throws LogIngestException {
        String json;
        try {
        LogIngestionService ingestionClient = RestClientBuilder.newBuilder()

            .baseUri(URI.create("https://" + company + ".logicmonitor.com/rest"))


            .build(LogIngestionService.class);

            Client client = ClientBuilder.newBuilder().build();
            //client.target("https://" + company + ".logicmonitor.com/rest").request().post(String.class);

        ObjectMapper objectMapper = new ObjectMapper();


            json = objectMapper.writeValueAsString(list);

        System.out.println("json\n" +json);
        //String finlMsg = StringUtil.isNullOrEmpty(msg) ? "default msg from quarkus" : msg;
        //final String arrayedMsg = "[{ \"message\" : \"" + finlMsg + "\" }]" ;
        String token  = generateToken(json);

            Map<String,String> map = new HashMap<>();
           // map.put("some",true);Object

        return ingestionClient.sendEvents(generateToken(json) , json);



        } catch (Exception e) {
            json = "null";
            System.out.println("Exception occured bhai");
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("br", "br");
                JSONObject jsonObject1 = new JSONObject();
                jsonObject.put("br1", jsonObject1);
                String s = (String) jsonObject.get("br1").toString();
                System.out.println("cast success " + s);

            }catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return Response.ok(e).build();
        }

    }


}
