/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micx
 */
import home.work.dto.Prod;
import home.work.dto.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
public class Main {
    
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
    public static void main(String[] args) {
        Main main = new Main();
        List<Prod> resault = main.getAllProd();
        System.out.println("List print");
        
        for(Prod product: resault) {
            System.out.print("Product name: " + product.getProdName() );
            System.out.println("\tPrice" + product.getPrice() );
        }
    }
}
