/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.work.dto;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ControlApp {
    Session session = null;
    
    public ControlApp() {
        try {
            System.out.println();
            System.out.print("ControlApp openSession");
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            
        } catch (Exception ex) {
           System.err.println("Get current:" + ex);
        }
    }
    
    /*
       private List<Prod> getAllProd() {
        List<Prod> resault = null;
        try {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        resault = session.createQuery("from Prod").list();
        session.getTransaction().commit();               
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return resault;
        }
    }
    */
    
    public List getAllProducts() {
        List <Prod> resault = null;
        try {
                System.out.println("getAllProducts:");
            Transaction tx = session.beginTransaction();
                System.out.println("Session was started");
            Query q = session.createQuery("from Prod");
                System.out.println("Query was created");
            resault = (List<Prod>) q.list();
         
        } catch (Exception ex) {
            System.err.println("Get all prod:" + ex);
        } finally{
            return resault;
        }
    }
    
    public static void main(String[] args){
       
        ControlApp app = new ControlApp();
        System.out.println("ControlApp main start");
        
        List<Prod> resault = app.getAllProducts();
        System.out.println("List print");
        
        for(Prod product: resault) {
            System.out.print("Product name: " + product.getProdName() );
            System.out.println("\tPrice: " + product.getPrice() );
        }
    }
    
}
