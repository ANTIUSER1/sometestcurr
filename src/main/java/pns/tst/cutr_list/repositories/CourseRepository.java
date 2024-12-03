package pns.tst.cutr_list.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pns.tst.cutr_list.entities.Course;

import java.time.LocalDate;
import java.util.List;

/**
 * repo for Course
 */
@Transactional
@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    /**
     * getting courses from db dy currency id
     *
     * @param id
     * @return
     */
    @Query(
            value = " select * from course " +
                    "where currency_id = :id ",
            nativeQuery = true)
    List<Course> getCuurseListByCurrencyId(@Param("id") Long id);

    /**
     * getting courses from db dy currency id && date
     * @param id
     * @param date
     * @return
     */
    @Query(
            value = " select * from course " +
                    "where currency_id = :id and course_date = :d ",
            nativeQuery = true)
    List<Course> getCuurseListByCurrencyIdAndDate(
            @Param("id") Long id, @Param("d") LocalDate date);
}
