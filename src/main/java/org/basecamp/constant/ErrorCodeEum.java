package org.basecamp.constant;

import java.util.HashMap;
import java.util.Map;


public enum ErrorCodeEum 
{
	ACCOUNT_NOT_FOUND("The account could not be found"),
	SUCCESS("Success"),
	USER_ALREADY_EXISTS(""),
	USER_NOT_FOUND(""),
	MAX_USERS_REACHED(""),
	UNAUTHORIZED(""),
	OPERATION_CANCELED(""),
	CONFIGURATION_ERROR(""),
	INVALID_RESPONSE(""),
	PENDING(""),
	FORBIDDEN(""),
	BINDING_NOT_FOUND(""),
	TRANSPORT_ERROR(""),
	UNKNOWN_ERROR(""),
	
	;
	
	private final String name;

    private static final Map<String, ErrorCodeEum> stringToEnum = new HashMap<String, ErrorCodeEum>();
    
    ErrorCodeEum(String name)
    {
        this.name = name;
    }
    
    static
    {
    	for(ErrorCodeEum op: values())
    	{
    		stringToEnum.put(op.getName(), op);
    	}
    }
   
    public String getName()
    {
        return name;
    }
    
    public static ErrorCodeEum fromType(String type)
    {
        if (type == null)
            return ErrorCodeEum.UNKNOWN_ERROR;

        ErrorCodeEum ruleEnum = stringToEnum.get(type);
        return ruleEnum == null ? ErrorCodeEum.UNKNOWN_ERROR : ruleEnum;
    }
}
