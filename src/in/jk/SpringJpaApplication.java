package in.jk;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = null;
		EntityManagerFactory entityManagerFactory =null;
		
		context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		entityManagerFactory = (EntityManagerFactory) context.getBean("entityManagerFactory");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		User user = new User();
		user.setUserId(100);
		user.setName("JK");
		user.setEmail("jk@gmail.com");

		// For persist Object
		entityManager.persist(user);
		System.out.println("User saved in Database ..");

		// For find Object
		User user1 = entityManager.find(User.class, 100);
		System.out.println("User from Database.." + user1);

		// For delete Object
		entityManager.remove(user1);
		System.out.println("User Deleted from Database.." + user1);

		entityManager.getTransaction().commit();

        System.out.println();
        System.out.println("Using Second Way :: ");
		System.out.println("Persist and find the Object using Dao with Declative Transatcion");

		UserDao userDao = (UserDao) context.getBean("userDao");

		User userObj = new User();
		userObj.setUserId(101);
		userObj.setName("JK");
		userObj.setEmail("jk@gmail.com");

		// For persist Object
		userDao.save(userObj);

		// For find Object
		User userEntity = userDao.get(101);
		System.out.println("User from database.." + userEntity);
		
		
		System.out.println("Completed  Succussfully ....");
		

	}

}
