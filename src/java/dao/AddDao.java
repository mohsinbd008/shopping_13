/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Product;
import entity.ShopUser;
import entity.SubCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Mohsin
 */
public class AddDao {

    public boolean addCategory(Category cat) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            session.beginTransaction();
            session.save(cat);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public boolean login(ShopUser shopuser) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            session.beginTransaction();
         Query query=session.createQuery("SELECT u FROM shopuer u where u.name=:uname AND u.password=:upassword ");
       
         List<ShopUser>cList=query.list();
         cList.toString();
         
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public boolean addShopuser(ShopUser shopuser) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            session.beginTransaction();
            session.save(shopuser);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public boolean addSubCategory(SubCategory subcat) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            session.beginTransaction();
            session.save(subcat);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
      public boolean addProduct(Product product) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();

            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
