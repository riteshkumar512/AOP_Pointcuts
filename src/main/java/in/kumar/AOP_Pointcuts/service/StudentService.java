package in.kumar.AOP_Pointcuts.service;

import in.kumar.AOP_Pointcuts.annotation.TrackExecutionTime;
import in.kumar.AOP_Pointcuts.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creating Student"
    )
    public Student createStudent(Student student){
        System.out.println("Student saved");
        return student;
    }
    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public String getStudent(String s){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(s);
        return s;
    }
    public int dummyMethod(){
        return 0;
    }
}
