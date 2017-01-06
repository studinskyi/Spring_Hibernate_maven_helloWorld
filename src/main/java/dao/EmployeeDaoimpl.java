package dao;

//import com.journaldev.hibernate.model.Employee;
//import com.journaldev.hibernate.util.HibernateUtil;
//import org.hibernate.Query;
//import org.hibernate.Session;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoimpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Employee p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> list() {
        Session session = this.sessionFactory.openSession();
        List<Employee> personList = session.createQuery("from Employee").list();
        session.close();
        return personList;
    }

    //    public List<Employee> getListAllEmployee() {
    //        // вывод списка всех Employee
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //        //Get Session
    //        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //        //start transaction
    //        session.beginTransaction();
    //        try {
    //            Query query = session.createQuery(SQL_FIND_ALL);
    //            //Query query = session.createQuery("from Employee");
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } catch (Exception e) {
    //            session.getTransaction().rollback();
    //        }
    //        return listEmployees;
    //    }
    //
    //    public List<Employee> getListEmployeeByName(String nameEmpl) {
    //        // вывод Employee по имени
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //        //Get Session
    //        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //        //start transaction
    //        session.beginTransaction();
    //        try {
    //            Query query = session.createQuery("from Employee where name = :nameEmployee ");
    //            query.setParameter("nameEmployee", nameEmpl);
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } catch (Exception e) {
    //            session.getTransaction().rollback();
    //        }
    //        return listEmployees;
    //    }
    //
    //    public void showAllNicknamesEmployee() {
    //        // вывод всего списка записанных в базу Employee
    //        List<Object> listNikEmpl = new ArrayList<Object>();
    //        //Get Session
    //        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //        //start transaction
    //        session.beginTransaction();
    //        try {
    //            Query query = session.createQuery("SELECT OBJECT(rrr) FROM Nickname AS N JOIN N.employee rrr");
    //            listNikEmpl = (List<Object>) query.list();
    //            for (Object strNikEmpl : listNikEmpl)
    //                System.out.println(strNikEmpl.toString());
    //
    //            session.getTransaction().commit();
    //        } catch (Exception e) {
    //            session.getTransaction().rollback();
    //        }
    //    }
    //
    //    public List<Employee> getListEmployeeByDate(String dateSelect) {
    //        // вывод Employee по точной дате добавления
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //        //Get Session
    //        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //        //start transaction
    //        session.beginTransaction();
    //        try {
    //            Query query = session.createQuery("from Employee where insertTime = '" + dateSelect + "'");
    //            //query.setParameter("insertTime", dateSelect);
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } catch (Exception e) {
    //            session.getTransaction().rollback();
    //        }
    //        return listEmployees;
    //    }
    //
    //    public List<Employee> getListEmployeeAfterDate(String dateAfter) {
    //        // вывод Employee добавленные после даты
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //        //Get Session
    //        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //        //start transaction
    //        session.beginTransaction();
    //        try {
    //            Query query = session.createQuery("from Employee where insertTime > '" + dateAfter + "'");
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } catch (Exception e) {
    //            session.getTransaction().rollback();
    //        }
    //        return listEmployees;
    //    }

}
