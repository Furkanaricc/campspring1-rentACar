package kodlama.io.rentACar.entitiy.concretes;

import lombok.*;
import java.util.*;
import javax.persistence.*;

@Table(name="brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //Varlık sınıfımız
public class Brand {

    @Id // PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id otomatik ilerlemesini sağlar.
    @Column(name="id") //Sütun
    private int id; //Primary Key


    @Column(name="name") //Sütun
    private String name;


    @OneToMany(mappedBy="brand")
    private List<Model> models;


}
