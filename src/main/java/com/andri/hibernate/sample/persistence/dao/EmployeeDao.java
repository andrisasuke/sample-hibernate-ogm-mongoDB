package com.andri.hibernate.sample.persistence.dao;

import com.andri.hibernate.sample.persistence.domain.Employee;

import javax.persistence.*;
import java.util.List;

/**
 * Employee DAO (Data Access Object)
 * Created by andri.khrisharyadi@gmail.com
 * on 6/15/14.
 */
public class EmployeeDao {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("samplePersistenceUnit");
    private EntityManager em = emf.createEntityManager();

    public void save(Employee employee){
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        }catch (Exception e){
            if(transaction !=null && transaction.isActive())
                transaction.rollback();
        }

    }

    public void update(Employee employee){

        EntityTransaction transaction = em.getTransaction();

        try {
            if(findById(employee.getId())!=null) {
                transaction.begin();
                em.merge(employee);
                transaction.commit();
            }
        }catch (Exception e){
            if(transaction !=null && transaction.isActive())
                transaction.rollback();
        }

    }

    public void delete(Employee employee){
        EntityTransaction transaction = em.getTransaction();

        try {
            if(findById(employee.getId())!=null) {
                transaction.begin();
                em.remove(employee);
                transaction.commit();
            }
        }catch (Exception e){
            if(transaction !=null && transaction.isActive())
                transaction.rollback();
        }
    }

    public void deleteById(Integer id){
        EntityTransaction transaction = em.getTransaction();

        try {
            Employee find = findById(id);
            if(find != null) {
                transaction.begin();
                em.remove(find);
                transaction.commit();
            }
        }catch (Exception e){
            if(transaction !=null && transaction.isActive())
                transaction.rollback();
        }
    }

    public Employee findById(Integer id) {
        try {
            return em.find(Employee.class, id);
        } catch (Exception ex) {
            System.out.println("Could not find Employee with id: "  + id + "; " + ex.getMessage());
        }
        return null;
    }

    public List<Employee> findAll(){

        String query2 = "{ $query : { firstname : 'andri' }, $orderby : { lastname : 1 } }";

        Query query = em.createNativeQuery(query2, Employee.class );
        return query.getResultList();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
