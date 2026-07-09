package SpringCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import SpringCore.com.library.service.BookService;

public class Exercise3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringCore/applicationContext.xml");
        BookService service = context.getBean(BookService.class);
        service.manageBooks();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
