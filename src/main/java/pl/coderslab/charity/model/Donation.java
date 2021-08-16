package pl.coderslab.charity.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private int quantity;
    @ManyToMany
    private List<Category> categoryList;
    @ManyToOne
    private Institution institution;
    @NotEmpty
    private String street;
    @NotEmpty
    private String city;
    @NotEmpty
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    @NotEmpty
    private String pickUpComment;

}
