package pns.tst.cutr_list.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pns.tst.cutr_list.entities.Course;
import pns.tst.cutr_list.entities.Currency;
import pns.tst.cutr_list.repositories.CourseRepository;
import pns.tst.cutr_list.repositories.CurrencyRepository;
import pns.tst.cutr_list.services.AddDataService;

import java.time.LocalDate;
import java.util.List;

/**
 * creation/showing data
 */
@RestController
@RequestMapping("/")
@Slf4j
public class CurrencyController {

    @Autowired
    private AddDataService addDataService;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CourseRepository courseRepository;

    /**
     * creating data
     *
     * @return
     */
    @GetMapping("/make")
    public String createData() {
        List<Currency> data = addDataService.addCurrencyData();
        currencyRepository.saveAll(data);
        log.info("Data added " + data);
        return "Data added " + data;
    }

    /**
     * search currency   by name and output
     *
     * @param name
     * @return
     */
    @GetMapping("/currency/{name}")
    public String getCurrensyIdByName(
            @PathVariable String name
    ) {
        long npp = 0;
        Long currencyId = currencyRepository
                .getCurrensyIdByName(name);
        List<Course> courseList = courseRepository.getCuurseListByCurrencyId(currencyId);
        StringBuffer sbf = new StringBuffer(name).append(" <hr /> ");

        if (courseList == null) return "NOT DATA FOUND";
        for (Course course : courseList) {
            npp++;
            sbf.append(npp).append(" &nbsp; | &nbsp;")
                    .append(course.getCourseDate().getYear()).append('-')
                    .append(course.getCourseDate().getMonth()).append('-')
                    .append(course.getCourseDate().getDayOfMonth())
                    .append("  : &nbsp;&nbsp;&nbsp;  ")
                    .append(course.getValue())
                    .append(" <br />");
        }
        return sbf.toString();
        //name + "   " + currencyIdi;

    }

    /**
     * search currency   by name && date and output
     *
     * @param date
     * @param name
     * @return
     */
    @GetMapping("/currency/{name}/{date}")
    public String getCuurseListByCurrencyIdAndDate(
            @PathVariable String name, @PathVariable LocalDate date
    ) {
        long npp = 0;
        Long currencyId = currencyRepository
                .getCurrensyIdByName(name);
        List<Course> courseList = courseRepository
                .getCuurseListByCurrencyIdAndDate(currencyId, date);
        StringBuffer sbf = new StringBuffer(name)
                .append(" for ").append(date)
                .append(" <hr /> ");

        if (courseList == null) return "NOT DATA FOUND";
        for (Course course : courseList) {
            npp++;
            sbf.append(npp).append(" &nbsp; | &nbsp;")
                    .append(course.getCourseDate().getYear()).append('-')
                    .append(course.getCourseDate().getMonth()).append('-')
                    .append(course.getCourseDate().getDayOfMonth())
                    .append("  : &nbsp;&nbsp;&nbsp;  ")
                    .append(course.getValue())
                    .append(" <br />");
        }
        return sbf.toString();
        //name + "   " + currencyIdi;

    }

}
