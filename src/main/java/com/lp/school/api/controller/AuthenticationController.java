package com.lp.school.api.controller;

import com.lp.school.api.domain.ApiResponse;
import com.lp.school.api.domain.AuthToken;
import com.lp.school.api.jwt.config.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/token")
public class AuthenticationController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/generate-token")
    public ApiResponse<AuthToken> getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {

        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(authentication.getAuthorizedClientRegistrationId(), authentication.getName());

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
            model.addAttribute("name",userName );
        }
        final String token = jwtTokenUtil.generateToken((String)userAttributes.get("name"));
        return new ApiResponse<>(200, "success",new AuthToken(token, userName));
    }

}
