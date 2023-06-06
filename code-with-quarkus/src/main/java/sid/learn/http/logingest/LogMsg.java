package sid.learn.http.logingest;

import io.netty.util.internal.StringUtil;
import java.util.List;


public class LogMsg {



    public String getMessage() {
        return message;
    }

    public LogMsg(String message) {
        this.message = StringUtil.isNullOrEmpty(message) ? "default quarkus msg" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message  ;


}
