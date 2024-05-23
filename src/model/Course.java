package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    private String id;
    private String title;
    private String[] requirement;
    private String [] instructor;
    private LocalDate date;
}
