package tn.beecoder.chiliapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo", nullable = false)
    private Long id_photo;
    private String namePhoto;
    private String contentType;
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish ;
}
