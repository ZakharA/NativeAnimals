/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.mbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author zakhar
 */
@Named(value = "securityBean")
@RequestScoped
public class SecurityBean {

    private static String CONTRIBUTOR_ROLE = "Contirbutor";
    private static String ADMIN_ROLE = "Admin";

    private HttpServletRequest getHttpServletRequest() {
        FacesContext context = FacesContext.getCurrentInstance();
        return (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public boolean isLoggedIn() {
        return (this.getHttpServletRequest().getUserPrincipal() != null);
    }

    public boolean isAdmin() {
        return (this.getHttpServletRequest().isUserInRole(ADMIN_ROLE));
    }

    public boolean isContributor() {
        return (this.getHttpServletRequest().isUserInRole(CONTRIBUTOR_ROLE));
    }

    public void logout() {
        try {
            this.getHttpServletRequest().logout();
            this.getHttpServletRequest().getSession().invalidate();
        } catch (ServletException e) {
            throw new FacesException("Failure on logout", e);
        }
    }
}
