package org.basecamp.core;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	
	public static <T> T getJSONtoObject(String json, Class<T> clazz)
    {
        return getJSONtoObject(json, clazz, true);
    }
    
    private static <T> T getJSONtoObject(String json, Class<T> clazz, boolean b)
    {
        ObjectMapper om = new ObjectMapper();
        
        T map = null;
        try
        {
            map = om.readValue(json, clazz);
        }
        catch (JsonParseException e)
        {
            //TODO: need to create custom Exception to throw
        }
        catch (JsonMappingException e)
        {
        	//TODO: need to create custom Exception to throw
        }
        catch (IOException e)
        {
        	//TODO: need to create custom Exception to throw
        }

        return map;
    }

}
