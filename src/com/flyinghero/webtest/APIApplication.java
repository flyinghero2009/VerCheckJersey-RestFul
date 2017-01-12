package com.flyinghero.webtest;
import java.util.Map;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;



public class APIApplication extends ResourceConfig {

	public APIApplication() {
        //加载Resource
        register(AppVersionCheck.class);

        //注册数据转换器
        register(JacksonJsonProvider.class);

        // Logging.
        register(LoggingFilter.class);
    }


}
