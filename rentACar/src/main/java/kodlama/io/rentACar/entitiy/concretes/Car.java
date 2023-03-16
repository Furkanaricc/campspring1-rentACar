package kodlama.io.rentACar.entitiy.concretes;

import lombok.*;

import javax.persistence.*;

@Table(name = "Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="plate")
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;
}
