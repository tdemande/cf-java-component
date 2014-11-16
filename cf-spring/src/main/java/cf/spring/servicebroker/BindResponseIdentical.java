package cf.spring.servicebroker;

import javax.servlet.http.HttpServletResponse;

/**
 * {@link BindResponse} subclass, intended to easily be able to return a 200 status code to the Cloud Controller
 * when the bind request currently processed is the exact same as one before. Response body must of course be the
 * same as the previous one. Although not mandatory, this can help having a more robust service broker,
 * by being able to handle idempotent requests without treating them as conflicts.
 *
 * @author Thomas Demande
 */
public class BindResponseIdentical extends BindResponse {
    public BindResponseIdentical(Object credentials) {
        super(credentials);
    }

    public BindResponseIdentical(Object credentials, String syslogDrainUrl) {
        super(credentials, syslogDrainUrl);
    }

    @Override
    public int getHttpStatusCode() {
        return HttpServletResponse.SC_OK;
    }
}
