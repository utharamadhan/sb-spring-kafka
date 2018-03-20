package com.rpramadhan.sb.springkafka.consumer.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6143474484193228992L;
	
	public static final String RC_SUCCESS 	= "00";
	public static final String RC_NOT_FOUND = "04";
	public static final String RC_ERROR		= "10";
	
	public static final String RD_SUCCESS 	= "success";
	public static final String RD_NOT_FOUND	= "not found";

	@JsonProperty("responseCode")
	private String responseCode;
	
	@JsonProperty("responseDesc")
	private String responseDesc;
	
	@JsonProperty("result")
	private transient Object result;
	
	public static Response createInstance(Object result) {
		Response resp = new Response();
			resp.setResponseCode(RC_SUCCESS);
			resp.setResponseDesc(RD_SUCCESS);
			resp.setResult(result);
		return resp;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseDesc() {
		return responseDesc;
	}

	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
