
import dao.EmployeeDao;
import dao.PersonDAO;
import model.Employee;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Test
@ContextConfiguration(locations = {"classpath:spring4.xml"})
public class TestSpring_one_to_one extends AbstractTestNGSpringContextTests{

    @Autowired
    PersonDAO personDao;

    @Test()
    void testEmailGenerator() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);
        EmployeeDao employeeDao = context.getBean(EmployeeDao.class);

        String namePerson = "";

        Person person = null;
        Employee empl = null;
        // save person 1
        person = new Person();
        namePerson = "Denis" + (new Random()).nextInt();
        person.setName(namePerson);
        person.setCountry("Brasil"+ (new Random()).nextInt());
        //person.setCountry("Brasil"+ (new Random()).nextInt());

        empl = new Employee();
        empl.setName(namePerson);
        empl.setRole("QAAut" + (new Random()).nextInt());
        empl.setInsertTime(new Date());
        empl.setPerson(person);
        //employeeDao.save(empl);
        person.setEmployee(empl);
        //personDAO.save(person);
        employeeDao.save(empl);
        System.out.println("new Person::"+person);

        // save person 2
        person = new Person();
        namePerson = "Ivan" + (new Random()).nextInt();
        person.setName(namePerson);
        person.setCountry("Belarussia");

        empl = new Employee();
        empl.setName(namePerson);
        empl.setRole("Develop");
        empl.setInsertTime(new Date());
        empl.setPerson(person);
        //employeeDao.save(empl);

        person.setEmployee(empl);
        //personDAO.save(person);
        employeeDao.save(empl);
        System.out.println("new Person::"+person);

        //        // save person 3
        //        person = new Person();
        //        person.setName("Piter");
        //        person.setCountry("Germany");
        //
        //        empl = new Employee();
        //        empl.setName("Piter" + (new Random()).nextInt());
        //        empl.setRole("QAMan");
        //        empl.setInsertTime(new Date());
        //        person.setEmployee(empl);
        //        personDAO.save(person);
        //        employeeDao.save(empl);
        //        System.out.println("new Person::"+person);

        // output list of persons
        List<Person> providers = null;
        try {
            providers = personDao.list();
            for (Person provider : providers) {
                System.out.println(provider.toString());
                //System.out.println(provider.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}