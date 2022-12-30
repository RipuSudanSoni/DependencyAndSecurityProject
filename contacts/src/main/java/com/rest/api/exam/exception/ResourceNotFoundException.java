package com.rest.api.exam.exception;


public class ResourceNotFoundException extends RuntimeException{
	
	String resourceName;
	String fieldName;
	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	 
	public ResourceNotFoundException(String resourceName, String fieldName) {
		super(String.format("%s is not found with %s", resourceName, fieldName));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
	}
		
	
}
