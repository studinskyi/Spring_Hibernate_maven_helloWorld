
import dao.PersonDAO;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

@Test
@ContextConfiguration(locations = {"classpath:spring4.xml"})
public class TestSpring extends AbstractTestNGSpringContextTests{

    @Autowired
    PersonDAO personDao;

    @Test()
    void testEmailGenerator() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = null;
        // save person 1
        person = new Person();
        person.setName("Denis");
        person.setCountry("Brasil"+ (new Random()).nextInt());
        //person.setCountry("Brasil"+ (new Random()).nextInt());
        personDAO.save(person);
        System.out.println("new Person::"+person);
        // save person 2
        person = new Person();
        person.setName("Ivan");
        person.setCountry("Belarussia");
        personDAO.save(person);
        System.out.println("new Person::"+person);
        // save person 3
        person = new Person();
        person.setName("Piter");
        person.setCountry("Germany");
        personDAO.save(person);
        System.out.println("new Person::"+person);

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