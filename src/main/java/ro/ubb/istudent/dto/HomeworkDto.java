package ro.ubb.istudent.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.ubb.istudent.domain.Homework;

import java.sql.Date;

/**
 * Created by M. B. on 1/23/2018.
 */
@Getter
@Setter
@ToString
@Builder
public class HomeworkDto implements Dto {

    private Date deadline;
    private int delayedDays;

    public Homework get() {
        return Homework.builder()
                .deadline(deadline)
                .delayedDays(delayedDays)
                .build();
    }

}
