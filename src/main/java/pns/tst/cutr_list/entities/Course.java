package pns.tst.cutr_list.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Course
 */
@Entity
@Setter
//@ToString
public class Course {

    /**
     * identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * course value
     */
    @Getter
    private double value;
    /**
     * date when course set
     */
    @Getter
    private LocalDate courseDate;
    /**
     * link to currency
     */
    @ManyToOne(cascade = CascadeType.ALL)
    private Currency currency;

}
