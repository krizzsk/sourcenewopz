package com.didichuxing.swarm.toolkit;

public interface AuthenticationService {
    void addAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener);

    String getToken();

    boolean isAuthenticated();

    void removeAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener);
}
