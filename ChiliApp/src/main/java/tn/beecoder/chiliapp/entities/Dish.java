package tn.beecoder.chiliapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dish", nullable = false)
    private Long id;
    private Short price;
    private String name;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private List<Image> imageList;
    private boolean enabled;
}
