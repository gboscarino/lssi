package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Payload {

	public static final String OK = "ok";
	public static final String FAIL = "fail";
	public static final String ERROR = "error";
	public static final String NODATA = "nodata";
	public static final String TIMEOUT = "timeout";
	public static final String ACTIVE = "active";
	public static final String INACTIVE = "inactive";
	public static Payload ERROR_PAYLOAD;
	
	static {
		ERROR_PAYLOAD = new Payload();
		ERROR_PAYLOAD.setStatus(ERROR);
		ERROR_PAYLOAD.setErrorMessage("An unspecified error occured in LIIS");
	}

	@JsonProperty("status")
	protected String status = null;
	
	@JsonProperty("error_message")
	protected String error_message = null;
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("error_message")
	public String getErrorMessage() {
		return error_message;
	}

	@JsonProperty("error_message")
	public void setErrorMessage(String error_message) {
		this.error_message = error_message;
	}

}
