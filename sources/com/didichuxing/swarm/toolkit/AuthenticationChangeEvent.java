package com.didichuxing.swarm.toolkit;

import java.util.EventObject;

public class AuthenticationChangeEvent extends EventObject {
    private final boolean mAuthenticated;

    public AuthenticationChangeEvent(AuthenticationService authenticationService, boolean z) {
        super(authenticationService);
        this.mAuthenticated = z;
    }

    public AuthenticationService getSource() {
        return (AuthenticationService) super.getSource();
    }

    public boolean isAuthenticated() {
        return this.mAuthenticated;
    }
}
