package com.shotaroi.multitenantsaastaskmanager.security;

import com.shotaroi.multitenantsaastaskmanager.repository.OrganizationMemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class OrgAuthorizationFilter extends OncePerRequestFilter {

    private final OrganizationMemberRepository repo;

    public OrgAuthorizationFilter(OrganizationMemberRepository repo) {
        this.repo = repo;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String path = request.getRequestURI();

        // Only protect org-scoped endpoints
        if (!path.startsWith("/orgs/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String orgIdStr = path.split("/")[2];
        UUID orgId = UUID.fromString(orgIdStr);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UUID userId = UUID.fromString(auth.getName());

        boolean allowed = repo.existsByUserIdAndOrgId(userId, orgId);

        if (!allowed) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        request.setAttribute("orgId", orgId);
        filterChain.doFilter(request, response);
    }
}
