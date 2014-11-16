package cf.spring.servicebroker;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.http.HttpServletResponse;

/**
 * {@link ProvisionResponse} subclass, intended to easily be able to return a 200 status code to the Cloud Controller
 * when the provision request currently processed is the exact same as one before. Response body must of course be the
 * same as the previous one. Although not mandatory, this can help having a more robust service broker,
 * by being able to handle idempotent requests without treating them as conflicts.
 *
 * @author Thomas Demande
 */
public class ProvisionResponseIdentical extends ProvisionResponse {
    public ProvisionResponseIdentical() {
    }

    public ProvisionResponseIdentical(@JsonProperty(DASHBOARD_URL_PROPERTY) String dashboardUrl) {
        super(dashboardUrl);
    }

    @Override
    public int getHttpStatusCode() {
        return HttpServletResponse.SC_OK;
    }
}
