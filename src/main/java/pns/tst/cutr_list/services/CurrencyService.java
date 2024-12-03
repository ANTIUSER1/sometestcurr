package pns.tst.cutr_list.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pns.tst.cutr_list.entities.Course;
import pns.tst.cutr_list.entities.Currency;

/**
 * creating currency
 */
@Service
@Slf4j
public class CurrencyService {

    @Autowired
    private CourseService courseService;

    /**
     * create currency
     *
     * @param currName
     * @return
     */
    public Currency create(String currName) {
        Currency result = new Currency();
        result.setName(currName);
        for (long k = -20; k < 20; k++) {
            Course course = courseService.create(k);
            course.setCurrency(result);
            result.addCourse(course);
     }
        return result;
    }
}
