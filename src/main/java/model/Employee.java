package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Studinskyi
 *
 */

@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    @Column(name="insert_Time")
    private Date insertTime;

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    //@OneToOne(optional = false, mappedBy = "employee")
    //@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    //@PrimaryKeyJoinColumn
    //@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        String strEmployee = "Employee: " + id + " " + name + " " + role + " " + insertTime + " " + person.toString();
        return strEmployee;
    }

    //    public static List<Employee> getListEmployeeByName(String nameEmpl) {
    //
    //        Session session = null;
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        try {
    //            // вывод Employee по имени
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("from Employee where name = :nameEmployee ");
    //            query.setParameter("nameEmployee", nameEmpl);
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        return listEmployees;
    //    }
    //
    //    public static List<Employee> getListAllEmployee() {
    //        Session session = null;
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        try {
    //            // вывод всего списка записанных в базу Employee
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("from Employee");
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        return listEmployees;
    //    }
    //
    //    public static void showAllNicknamesEmployee() {
    //        Session session = null;
    //        List<Object> listNikEmpl = new ArrayList<Object>();
    //
    //        try {
    //            // вывод всего списка записанных в базу Employee
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("SELECT OBJECT(rrr) FROM Nickname AS N JOIN N.employee rrr");
    //            listNikEmpl = (List<Object>) query.list();
    //            for (Object strNikEmpl : listNikEmpl)
    //                System.out.println(strNikEmpl.toString());
    //
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        //return listEmployees;
    //    }
    //
    //    public static List<Employee> getListEmployeeByDate(String dateSelect) {
    //        Session session = null;
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        try {
    //            // вывод Employee по точной дате добавления
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("from Employee where insertTime = '" + dateSelect + "'");
    //            //query.setParameter("insertTime", dateSelect);
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        return listEmployees;
    //    }
    //
    //    public static List<Employee> getListEmployeeAfterDate(String dateAfter) {
    //        Session session = null;
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        try {
    //            // вывод Employee добавленные после даты
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("from Employee where insertTime > '" + dateAfter + "'");
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        return listEmployees;
    //    }
    //
    //    public static List<Employee> getListEmployeeBetweenDate(String sincePeriod, String tillPeriod) {
    //        Session session = null;
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        try {
    //            // вывод Employee добавленные между датами
    //            session = HibernateUtil.getSessionFactory().getCurrentSession();
    //            session.beginTransaction();
    //            Query query = session.createQuery("from Employee where insertTime > '" + sincePeriod + "' and insertTime < '" + tillPeriod + "'");
    //            listEmployees = (List<Employee>) query.list();
    //            session.getTransaction().commit();
    //        } finally {
    //            if (session != null && session.isOpen()) {
    //                session.close();
    //            }
    //        }
    //        return listEmployees;
    //    }
    //
    //    public static List<Employee> getListAllEmployee_Criteria(Session session) {
    //        List<Employee> listEmployees = new ArrayList<Employee>();
    //
    //        Transaction tx = session.beginTransaction();
    //        Criteria cr = session.createCriteria(Employee.class);
    //        listEmployees = cr.list();
    //        tx.commit();
    //
    //
    //        return listEmployees;
    //
    //    }
}
