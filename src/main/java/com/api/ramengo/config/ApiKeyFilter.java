package com.api.ramengo.config;

import com.api.ramengo.service.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class ApiKeyFilter extends OncePerRequestFilter {

    private final ApiKeyService apiKeyService;

    public ApiKeyFilter(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterchain)
        throws ServletException, IOException {
        String apiKey = request.getHeader("x-api-key");
        if (apiKey != null && apiKey.equals(apiKeyService.getApiKey())){
            Authentication authentication = new PreAuthenticatedAuthenticationToken(apiKey, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterchain.doFilter(request, response);
    }
}
