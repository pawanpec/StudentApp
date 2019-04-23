package com.lp.school.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;



@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private static final long DEFAULT_TOKEN_EXPIRATION = TimeUnit.HOURS.toMillis(6);

    private final Auth auth = new Auth();
    private final OAuth2 oauth2 = new OAuth2();

    public static class Auth {
        private String tokenSecret;
        private long tokenExpiration;
        private long tokenExpirationMsec;

       /* public Auth() {
            if (tokenExpiration > 0L && tokenExpirationMsec == DEFAULT_TOKEN_EXPIRATION) {
                tokenExpirationMsec = TimeUnit.MINUTES.toMillis(tokenExpiration);
            }
        }
       @PostConstruct
       private void init(){
           System.out.println("post construct " + tokenExpiration);

       }
       */

        public String getTokenSecret() {
            return tokenSecret;
        }

        public void setTokenSecret(String tokenSecret) {
            this.tokenSecret = tokenSecret;
        }

        public long getTokenExpirationMsec() {
            if (tokenExpirationMsec > 0L ) {
                return tokenExpirationMsec;
            } else if ( tokenExpiration > 0L) {
                tokenExpirationMsec = TimeUnit.MINUTES.toMillis(tokenExpiration);
            } else {
                tokenExpirationMsec = DEFAULT_TOKEN_EXPIRATION;
            }
            return tokenExpirationMsec;
        }

        /*public void setTokenExpirationMsec(long tokenExpirationMsec) {
            this.tokenExpirationMsec = tokenExpirationMsec;
        }*/

        public void setTokenExpiration(long tokenExpiration) {
            this.tokenExpiration = tokenExpiration;
        }
    }

    public static final class OAuth2 {
        private List<String> authorizedRedirectUris = new ArrayList<>();

        public List<String> getAuthorizedRedirectUris() {
            return authorizedRedirectUris;
        }

        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
            this.authorizedRedirectUris = authorizedRedirectUris;
            return this;
        }
    }

    public Auth getAuth() {
        return auth;
    }

    public OAuth2 getOauth2() {
        return oauth2;
    }
}
