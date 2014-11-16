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
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.servlet.http.HttpServletResponse;

/**
 * The response returned to the Cloud Controller after a successful bind. Methods annotated with {@code @Bind} must
 * return an instance of this type. This is to be used when a successful binding occurs as the Cloud Controller
 * expects a 201 status code. When the exact same request has already been made previously, one should use
 * {@link BindResponseIdentical} instead, to be able to return a 200 status code to the Cloud Controller
 *
 * @author Mike Heath <elcapo@gmail.com>
 */
public class BindResponse extends JsonObject {

	private final Object credentials;
	private final String syslogDrainUrl;

	/**
	 * Creates a bind response.
	 *
	 * @param credentials credentials sent to the Cloud Controller. This must be a Jackson serializable JSON object.
	 */
	public BindResponse(Object credentials) {
		this(credentials, null);
	}

	/**
	 * Creates a bind response.
	 *
	 * @param credentials credentials sent to the Cloud Controller. This must be a Jackson serializable JSON object.
	 * @param syslogDrainUrl this should be a URL to a syslog endpoint.
	 */
	public BindResponse(Object credentials, String syslogDrainUrl) {
		this.credentials = credentials;
		this.syslogDrainUrl = syslogDrainUrl;
	}

	/**
	 * The credentials for this service binding.
	 */
	public Object getCredentials() {
		return credentials;
	}

	/**
	 * The syslog drain URL that receives all of the application's loggregator logs.
	 */
	@JsonProperty("syslog_drain_url")
	public String getSyslogDrainUrl() {
		return syslogDrainUrl;
	}

	public int getHttpStatusCode() {
		return HttpServletResponse.SC_CREATED;
	}
}
