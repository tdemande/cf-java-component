/*
 *   Copyright (c) 2014 Intellectual Reserve, Inc.  All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package cf.spring.servicebroker;

import cf.common.JsonObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.http.HttpServletResponse;

/**
 * The response returned to the Cloud Controller after a service has been successfully provisioned.
 * This is to be used when a successful provision occurs as the Cloud Controller expects a 201 status code.
 * When the exact same request has already been made previously, one should use
 * {@link cf.spring.servicebroker.ProvisionResponseIdentical} instead, to be able to instead
 * return a 200 status code to the Cloud Controller
 *
 * @author Mike Heath <elcapo@gmail.com>
 */
public class ProvisionResponse extends JsonObject {

	public static final String DASHBOARD_URL_PROPERTY = "dashboard_url";

	private final String dashboardUrl;

	public ProvisionResponse() {
		this(null);
	}

	@JsonCreator
	public ProvisionResponse(
			@JsonProperty(DASHBOARD_URL_PROPERTY) String dashboardUrl
	) {
		this.dashboardUrl = dashboardUrl;
	}

	@JsonProperty(DASHBOARD_URL_PROPERTY)
	public String getDashboardUrl() {
		return dashboardUrl;
	}

	public int getHttpStatusCode() {
		return HttpServletResponse.SC_CREATED;
	}
}
