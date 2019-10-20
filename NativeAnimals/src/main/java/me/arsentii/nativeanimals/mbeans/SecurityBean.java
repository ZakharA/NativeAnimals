/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.arsentii.nativeanimals.mbeans;

import java.io.Serializable;
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
public class SecurityBean implements Serializable {

    private static final String CONTRIBUTOR_ROLE = "contirbutor";
    private static final String ADMIN_ROLE = "admin";

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
    
    public String getUsername(){
        return (this.getHttpServletRequest().getUserPrincipal().getName());
    }

    public String logout() {
        try {
            this.getHttpServletRequest().logout();
            this.getHttpServletRequest().getSession().invalidate();
            return "/index.xhtml";
        } catch (ServletException e) {
            throw new FacesException("Failure on logout", e);
        }
    }
}
