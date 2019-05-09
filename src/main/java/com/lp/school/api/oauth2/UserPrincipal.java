package com.lp.school.api.oauth2;

import com.lp.school.api.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserPrincipal implements OAuth2User, UserDetails, OidcUser {

  private Long id;
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;
  private Map<String, Object> attributes;

  private String jwt;

  public UserPrincipal(Long id, String email, String password,
                       Collection<? extends GrantedAuthority> authorities) {

    this.id = id;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserPrincipal create(User user) {
    List<GrantedAuthority> authorities =
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));

    return new UserPrincipal(user.getId(), user.getEmail(), user.getPassword(), authorities);
  }

  public static UserPrincipal create(User user, Map<String, Object> attributes) {
    UserPrincipal userPrincipal = UserPrincipal.create(user);
    userPrincipal.setAttributes(attributes);
    return userPrincipal;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return attributes;
  }

  public void setAttributes(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getName() {
    return String.valueOf(id);
  }

  @Override
  public Map<String, Object> getClaims() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OidcUserInfo getUserInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public OidcIdToken getIdToken() {
    // TODO Auto-generated method stub
    return null;
  }

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }
}
