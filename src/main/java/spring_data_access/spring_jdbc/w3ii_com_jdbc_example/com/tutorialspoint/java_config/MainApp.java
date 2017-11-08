package spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config.dao.StudentJDBCTemplate;
import spring_data_access.spring_jdbc.w3ii_com_jdbc_example.com.tutorialspoint.java_config.model.Student;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentJDBCTemplate studentJDBCTemplate =
                (StudentJDBCTemplate)context.getBean(StudentJDBCTemplate.class);

        System.out.println("------Records Creation--------" );
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);

        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        studentJDBCTemplate.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----" );
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.println(", Age : " + student.getAge());

    }
}
