package org.springframework.samples.petclinic.system.handler;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RefererRedirectionAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public RefererRedirectionAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }
}
