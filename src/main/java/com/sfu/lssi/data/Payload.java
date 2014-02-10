package com.sfu.lssi.data;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Payload {

	// Range [200000, 299999]
	public static final String OK = "200000";
	public static final String CREATED = "201000";
	public static final String COUNTRY_LIST_EMPTY = "204001";
	public static final String COUNTRY_STATE_LIST_EMPTY = "204002";
	
	// 
	public static final String AGGREGATOR_DOES_NOT_EXIST = "310";
	public static final String AGGREGATOR_MAC_DOES_NOT_EXIST = "315";
	public static final String AGGREGATOR_OPER_PORT_NOT_DEFINED = "320";
	public static final String AGGREGATOR_INTERNET_GATEWAY_NOT_DEFINED = "330";
	public static final String NULLPAYLOAD = "350";
	
	// Range [400000, 499999]
	
	public static final String USER_NOT_AUTHORIZED = "401010";
	
	public static final String DUPLICATED_CLIENT_EMAIL = "409003";

	public static final String CLIENT_NOT_FOUND = "404001";
	public static final String COUNTRY_NOT_FOUND = "404002";
	public static final String COUNTRY_STATE_NOT_FOUND = "404003";
	public static final String CLIENT_TYPE_NOT_FOUND = "404004";
	public static final String CLIENT_STATUS_NOT_FOUND = "404005";
	public static final String USER_NOT_FOUND = "404020";
	public static final String USER_STATUS_NOT_FOUND = "404021";
	public static final String ROLE_NOT_FOUND = "404022";
	public static final String FACILITY_NOT_FOUND = "404030";
	public static final String FACILITY_LOCATION_NOT_FOUND = "404032";
	public static final String FACILITY_STATUS_NOT_FOUND = "404034";
	public static final String ENTITY_STATUS_NOT_FOUND = "404036";
	public static final String FLOOR_PLAN_NOT_FOUND = "404038";

	public static final String PRODUCT_NOT_FOUND = "404050";
	public static final String PRODUCT_TYPE_NOT_FOUND = "404052";
	public static final String NODE_NOT_FOUND = "404060";
	public static final String INVALID_COMPONENT_NUMBER = "404090";
	public static final String PRODUCT_FIRMWARE_NOT_FOUND = "404100";
	public static final String PRODUCT_FIRMWARE_VERSION_NOT_FOUND = "404120";

	
	public static final String INVALID_INPUT_PARAMETER = "406020";
	
	
	public static final String AGGREGATOR_NOT_CONFIGURED = "412040";
	
	
	public static final String FK_VIOLATION = "400";
	public static final String DUPLICATE_ENTRY = "409000";
	public static final String DUPLICATED_CLIENT = "409001";
	public static final String DUPLICATED_USER = "409002";
	public static final String DUPLICATED_FACILITY = "409016";
	public static final String DUPLICATED_FACILITY_LOCATION_CODE = "409020";
	public static final String DUPLICATED_PRODUCT_FIRMWARE = "409060";
	public static final String DUPLICATED_PRODUCT_FIRMWARE_VERSION = "409070";
	public static final String DUPLICATED_PRODUCT_FIRMWARE_VERSION_FILE_NAME = "409080";

	
	
	
	// Range [500000, 599999]
	public static final String GENERIC_DB_ERROR = "500001";
	public static final String GENERIC_COMMUNICATION_ERROR = "500100";
	public static final String DUPLICATED_CLIENT_NUMBER = "500002";
	public static final String DUPLICATED_USER_NUMBER = "500006";
	public static final String DUPLICATED_FACILITY_NUMBER = "500010";
	public static final String DUPLICATED_FACILITY_LOCATION_NUMBER = "500012";
	
	public static final String AGGREGATOR_UNAVAIABLE = "503010";
	
	
	public static final String JSON_ERROR = "500";
	public static final String ERROR = "600";
	public static final String NODATA = "300";
	public static final String TIMEOUT = "timeout";
	public static final String ACTIVE = "active";
	public static final String INACTIVE = "inactive";
	public static Payload ERROR_PAYLOAD;
	
	static {
		ERROR_PAYLOAD = new Payload();
		ERROR_PAYLOAD.setRequestStatus(ERROR);
		ERROR_PAYLOAD.setErrorMessage("An unspecified error occured in DAS");
	}

	@JsonProperty("request_status")
	protected String requestStatus = null;
	
	@JsonProperty("error_message")
	protected String error_message = null;

	
	// ------------------------------------------------------------------------
	//  Getters
	// ------------------------------------------------------------------------
	
	@JsonProperty("request_status")
	public String getRequestStatus() {
		return requestStatus;
	}

	@JsonProperty("error_message")
	public String getErrorMessage() {
		return error_message;
	}

	
	
	// ------------------------------------------------------------------------
	//  Setters
	// ------------------------------------------------------------------------

	@JsonProperty("request_status")
	public void setRequestStatus(String pRequestStatus) {
		this.requestStatus = pRequestStatus;
	}

	@JsonProperty("error_message")
	public void setErrorMessage(String error_message) {
		this.error_message = error_message;
	}

}