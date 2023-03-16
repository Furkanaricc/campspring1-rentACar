package kodlama.io.rentACar.entitiy.concretes;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="models")
@Entity
public class Model {
    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id otomatik ilerlemesini sağlar.
    @Column(name="id") //Sütun
    private int id; //Primary Key

    @Column(name="name") //Sütun
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
