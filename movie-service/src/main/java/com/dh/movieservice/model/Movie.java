package com.dh.movieservice.model;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author vaninagodoy
 * @author JGalvisS
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
    private String name;

    private String genre;

    private String urlStream;


}
