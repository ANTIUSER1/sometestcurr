package pns.tst.cutr_list.services;

import org.springframework.stereotype.Service;
import pns.tst.cutr_list.entities.Course;

import java.time.LocalDate;

/**
 * creating course
 */
@Service
public class CourseService {
    /**
     * create course
     *
     * @param day
     * @return
     */
    public Course create(long day) {
        Course result = new Course();
        result.setValue(Math.random() * 100);
        LocalDate today = LocalDate.now();
        result.setCourseDate(today.plusDays(day));
        return result;
    }
}
