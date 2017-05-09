package com.alc.common.util;
/**
 * 
 * @author lsx
 * @Description 返回单个对象
 */
public class SingleResult {
  private Boolean hasError;
  private String error;
  private Object info;
  
public SingleResult(Boolean hasError, String error, Object info) {
	super();
	this.hasError = hasError;
	this.error = error;
	this.info = info;
}
public SingleResult() {
	super();
	// TODO Auto-generated constructor stub
}
public Boolean getHasError() {
	return hasError;
}
public void setHasError(Boolean hasError) {
	this.hasError = hasError;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public Object getInfo() {
	return info;
}
public void setInfo(Object info) {
	this.info = info;
}
  
  
}
