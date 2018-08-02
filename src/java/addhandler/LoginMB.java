/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.AddDao;
import entity.ShopUser;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author R-34
 */
@ManagedBean
@SessionScoped
public class LoginMB {
   ShopUser shopuser=new ShopUser();

    public ShopUser getShopuser() {
        return shopuser;
    }

    public void setShopuser(ShopUser shopuser) {
        this.shopuser = shopuser;
    }
      public String addLogin(){
     shopuser.setUserName(shopuser.getUserName());
 shopuser.setPassword(shopuser.getPassword());
 boolean status= new AddDao().login(shopuser);
    if(status){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Login Success",""));
    }
    else{  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Oopps!Login failed",""));}
   return null;
   } 
}
