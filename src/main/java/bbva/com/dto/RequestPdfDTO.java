package bbva.com.dto;

import java.io.Serializable;

public class RequestPdfDTO implements Serializable {
    String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
