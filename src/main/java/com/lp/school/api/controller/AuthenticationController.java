package com.lp.school.api.controller;

import com.lp.school.api.domain.ApiResponse;
import com.lp.school.api.domain.AuthToken;
import com.lp.school.api.jwt.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @Value("#{'${studentapp.valid.admin.emails}'.split(',')}")
    private List<String> validAdminEmails;

    @Value("${studentapp.redirect.url}")
    private String redirectURL;

    @GetMapping("/generate-token")
    public ApiResponse<AuthToken> getLoginInfo(HttpServletResponse req,HttpServletResponse res, Model model,
                                               OAuth2AuthenticationToken authentication, @CookieValue(value = "token", required = false) Cookie cookieToken) {

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        if (client == null) {
            return new ApiResponse<AuthToken>(HttpStatus.UNAUTHORIZED.value(), "unauthorized", new AuthToken());
        }

        String userInfoEndpointUri = client.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUri();
        Map userAttributes=null;
        String userName=null;
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken()
                    .getTokenValue());

            HttpEntity<String> entity = new HttpEntity<String>("", headers);

            ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            userAttributes = response.getBody();
            userName=(String) userAttributes.get("name");
            String email=(String) userAttributes.get("email");

           if(!validAdminEmails.contains(email)){
               return new ApiResponse<>(401, "success",new AuthToken(null, userName));
           }
           model.addAttribute("name",userName );
        }
        String token = null;
        if (cookieToken != null) {
            token = cookieToken.getValue();
        }
        if (StringUtils.isEmpty(token)) {
            token = jwtTokenUtil.generateToken(userAttributes);
            cookieToken = new Cookie("token", token);
            cookieToken.setPath("/");
            res.addCookie(cookieToken);
        }
        try {
            res.sendRedirect(redirectURL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ApiResponse<>(200, "success",new AuthToken(token, userName));
    }
    public List<String> getValidAdminEmails() {
        return validAdminEmails;
    }

    public void setValidAdminEmails(List<String> validAdminEmails) {
        this.validAdminEmails = validAdminEmails;
    }
}
