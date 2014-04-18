package com.ls.drupal;

import java.util.Map;

import com.google.gson.Gson;
import com.ls.http.base.BaseRequest.RequestMethod;
/**
 * Class, used in order to post data to server only. Fetch/remove operations aren't supported.
 * @author lemberg
 *
 */
public class  DrupalEntityContainer extends DrupalEntity
{		
	private final Object data;
	private final String path;
	private Map<String, String> getParameters;

	public DrupalEntityContainer(DrupalClient client,Object theData, String thePath)
	{
		super(client);		
		this.path = thePath;
		this.data = theData;
	}

	public void setGetParameters(Map<String, String> getParameters)
	{
		this.getParameters = getParameters;
	}

	@Override
	public String toJsonString()
	{
		Gson gson = new Gson();
		return gson.toJson(this.data);
	}

	@Override
	public String toXMLString()
	{		
		return null;
	}

	@Override
	protected String getPath()
	{		
		return path;
	}

	@Override
	protected Map<String, String> getItemRequestPostParameters()
	{		
		return null;
	}

	@Override
	protected Map<String, String> getItemRequestGetParameters(RequestMethod method)
	{		
		if(method == RequestMethod.POST||method == RequestMethod.PATCH)
		{
			return getParameters;
		}else{
			return null;
		}
	}
	
}
