/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

/**
 *
 * @author LEMUEL
 */
public class HB {
    public static final int AGREGAR=1;
    public static final int ACTUALIZAR=2;
    public static final int ELIMINAR=3;
    public static final int AGREGAR_ACTUALIZAR=4;
    public static final int CONSULTAR=5;
    private SessionFactory sf = HibernateUtil.getSessionFactory();
    
      public HB(){
       
    }
    
    public Object consultaRegisro (Class clase,int id){
        SessionFactory sf = null;
        Session session= null;
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Object objetoDB = session.get(clase,id);
        session.close();
        return objetoDB;
    }
    
    public Object consultaRegisro (Class clase,String id){
        SessionFactory sf = null;
        Session session= null;
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        Object objetoDB = session.get(clase,id);
        session.close();
        return objetoDB;
    }
    
    public List consultaObjetos(String query){
        List lista=null;
        SessionFactory sf=null;
        Session session=null;
        try{
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            Query qry = session.createQuery(query);
            lista = qry.list();
            session.close();
        }catch(HibernateException e){
            System.out.println("Ocurrio un error : " + query);
        }
        return lista;
    
    }
    
    public int maxElementos (Class c, String campo){
       
        Session session = sf.openSession();
        Criteria criteria = session.createCriteria(c).setProjection(Projections.max(campo));
        int  max = (Integer) criteria.uniqueResult();
        return max;
    }
    
    public boolean ejecutaTx (Object o, Class c, int Operacion){
        boolean bnd = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            switch (Operacion){
                case AGREGAR : session.save(c.cast(o));
                                session.flush();
                                break;
                case ELIMINAR: session.delete(c.cast(o));
                                break;
                case ACTUALIZAR:session.update(c.cast(o));
                                break;
                case AGREGAR_ACTUALIZAR: session.saveOrUpdate(c.cast(o));
                                break;
            }
            tx.commit();
            session.close();
            bnd = true;
        }catch (Exception e) {
            tx.rollback();
            System.out.println("Ocurrio un error !!");
        }
        return bnd;
        
    }
    
}
