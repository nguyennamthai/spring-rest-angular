package thai.gateway.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Configuration
public class GatewayConfig {
    @Bean
    public ZuulFilter zuulFilter() {
        return new ZuulFilter() {
            @Override
            public String filterType() {
                return PRE_TYPE;
            }

            @Override
            public int filterOrder() {
                return 1;
            }

            @Override
            public boolean shouldFilter() {
                return true;
            }

            @Override
            public Object run() {
                HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
                System.out.println(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
                return null;
            }
        };
    }
}
