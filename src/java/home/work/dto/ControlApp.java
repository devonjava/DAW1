/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.work.dto;
import java.sql.Connection;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public  class ControlApp {
    private Session session = null;
      
    public ControlApp() throws HibernateException{
        
        try {
            System.out.println();
            System.out.println("ControlApp openSession");
           //System.out.println("Session isOpen: " + this.session.isOpen());
            //System.err.println("Session isConnected: " + this.session.isConnected());
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
            //System.out.println("Session isOpen: " + this.session.isOpen());
            //System.err.println("Session isConnected: " + this.session.isConnected());
            
        } catch (Exception ex) {
           System.err.println("Get current:" + ex);
        } finally {         
            this.session.disconnect();
        }
    }
    
    public List getAllProducts() {
        List <Prod> resault = null;
        try {
                System.out.println("getAllProducts:");
            
                Transaction tx = session.beginTransaction();
            
                System.out.println("Session was started");
            String hql = "from Prod";
            Query q = session.createQuery(hql);
                System.out.println("Query was created");
            resault = (List<Prod>) q.list();
          System.err.println("Resault contains: " + resault.size() + " rows");
        } catch (Exception ex) {
            System.err.println("Get all prod:" + ex);
        } 
         return resault;
    }
    public List getProductByPrice(Integer price) throws HibernateException{
        List<Prod> resault = null;      
        try {
            
                Transaction tx = session.beginTransaction();
            
            String hql = "from Prod as p WHERE p.price = " + price ;
                System.out.println("HQL: " + hql);
            Query q = session.createQuery(hql);
                System.out.println("Query was sent ");
            resault = (List<Prod>) q.list();
                System.err.println("Resault contains: " + resault.size() + " rows");           
        } catch (NullPointerException ex) {
           System.err.println("Get all prod:" + ex);
        } finally {
            if (resault.isEmpty() ) {
                return resault=null;
            } else return resault;
        }
    }
    
    public List getProductByQuery(String hql) throws HibernateException{
        List<Prod> resault = null;
        try {
            System.err.println("Session isOpen: " + session.isOpen());
           // System.err.println("Session isConnected: " + session.isConnected());
           
                Transaction tx = session.beginTransaction();
            
            System.out.println("HQL: " + hql);
            Query q = session.createQuery(hql);
            resault = (List<Prod>) q.list();
            System.err.println("Resault contains: " + resault.size() + " rows"); 
        } catch (NullPointerException ex) {
            System.err.println("NPE in getProductByQuery section: " + ex);
        } finally {
            if (resault.isEmpty() ) {
                return resault=null;
            } else return resault;
        }
    }
    public List getCatalog() {
        List<Cat> resault = null;
        try {
            System.err.println("Session isOpen: " + session.isOpen());
            System.err.println("Session isConnected: " + session.isConnected());
            if( session.isOpen() ) { 
               session.disconnect();
            }
            //Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cat");
            resault = (List<Cat>) q.list();
            System.err.println("Resault contains: " + resault.size() + " rows"); 
        } catch (NullPointerException ex) {
            System.err.println("NPE in getCatalog section: " + ex);
        }
        return resault;
    }
    public static void main(String[] args) throws NullPointerException{
       /*
        ControlApp app = new ControlApp();
        List<Prod> resaultProduct = null;
        try {
            System.out.println("getAllProducts");
            resaultProduct = app.getAllProducts();
            for(Prod product: resaultProduct) {
                 System.out.print("Product name: " + product.getProdName() );
                 System.out.print("\tPrice: " + product.getPrice() );
                 System.out.println("\tCat: " + product.getCatName() );       
            }          
        } catch (NullPointerException ex){
            System.err.println("Exception in main 1 block: " + ex);
        } finally {
            if ( !(resaultProduct.isEmpty()) ) resaultProduct.clear();
            if ( app.session.isConnected() ) app.session.close();
        }
        
        
        ControlApp app2 = new ControlApp();
        List<Prod> resaultProduct2 = null;
        try {
            System.out.println("getProductsByPrice");      
            resaultProduct2  = app2.getProductByPrice(1000);
            for(Prod product: resaultProduct2) {
                System.out.print("Product name: " + product.getProdName() );
                System.out.print("\tPrice: " + product.getPrice() );
                System.out.println("\tCat: " + product.getCatName() ); 
            } 
        } catch(NullPointerException ex) {
            System.err.println("Exception in main 2 block: " + ex);
        }
        */
        ControlApp app = new ControlApp();
        ControlApp app2 = new ControlApp();
        List<Prod> resault = null;
        List<Cat> resault2 = null;
        try {
            /*
            "select p from com.yourpackage.ChannelsPrograms cp "
                    + "left join cp.programs p where cp.channel ="
                    + " :channel"
            
            from Computers computer join fetch computer.categories
            */        
            //List<Cat> resault = null;
            resault = app.getProductByQuery("from Prod ");
           
           // for(Cat cat: resault) {
            for (Prod product: resault) {
                System.out.println("Product id: " + product.getProdId());
                System.out.println("Product name: " + product.getProdName());
                System.out.println("Product price: " + product.getPrice());
                System.out.println("Catalog name: " + product.getCat().getCatName());
                System.out.println();   
            }
        } catch (NullPointerException ex) {
            System.err.println("Null pointer in main section: " + ex);
        }
        
    }
    
}
//from Category as category where category.categoryId in (select filmCat.category.categoryId from FilmCategory as filmCat where filmCat.film.filmId='" + filmId + "')");
//resault = app.getProductByQuery("from Prod as prod where prod.price between 1000 and 5000");
//Query q = session.createQuery ("from Film as film where film.filmId between '"+startID+"' and '"+endID+"'");