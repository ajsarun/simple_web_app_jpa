/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sarun
 */
public class EmployeeTable {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeWebAppPU");
    public static List<Employee> findAllEmployee() {
        EntityManager em = emf.createEntityManager();
        List<Employee> empList = null;
        try {
            empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();         
        } catch (Exception e) {
            throw new RuntimeException(e);
            
        }
        finally {
            em.close();
        }
        return empList;
    }
    public static Employee findEmployeeById(int id) {
        EntityManager em = emf.createEntityManager();
        Employee emp = null;
        try {
            emp = em.find(Employee.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            em.close();
        }
        return emp;
    }
    
    public static int updateEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee target = em.find(Employee.class, emp.getId());
            if (target == null) {
                return 0;
            }
            target.setName(emp.getName());
            target.setSalary(emp.getSalary());
            em.persist(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
        }
        return 1;
        
    }
    public static int removeEmployee(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee target = em.find(Employee.class, id);
            if (target == null) {
                return 0;
            }
            em.remove(target);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
        }
        return 1;
    }
    
    
    public static int insertEmployee(Employee emp) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Employee target = em.find(Employee.class, emp.getId());
            if (target != null) {
                return 0;
            }
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            
        }
        finally {
            em.close();
        }
        return 1;
    }
}
