package sample.oauth2.config;

import sample.oauth2.controller.UserApprovalHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

//@Configuration
public class OAuth2ServerConfig {

    //@Autowired
    private ClientDetailsService clientDetailsService;

    //@Autowired
    private TokenStore tokenStore;


    //@Configuration
    //@Order(10)
    protected static class UiResourceConfiguration
            extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.requestMatchers().antMatchers("/rest/**")
            .and().authorizeRequests()
                .antMatchers("/rest/speakers").access("hasRole('ROLE_USER')")
                .antMatchers("/rest/test").access("hasRole('ROLE_USER')")
                .antMatchers("/rest/trusted/**").access("hasRole('ROLE_USER')");
        }
    }


    //@Bean
    public ApprovalStore approvalStore() throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }

    //@Bean
    //@Lazy
    //@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserApprovalHandler userApprovalHandler() throws Exception {
        UserApprovalHandler handler = new UserApprovalHandler();
        handler.setApprovalStore(approvalStore());
        handler.setRequestFactory(
                new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        handler.setUseApprovalStore(true);
        return handler;
    }

}
