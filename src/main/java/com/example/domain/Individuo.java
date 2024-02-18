
package com.example.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;




@Data
@Entity
@Table(name = "usuario")
public class Individuo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_individuo;
     private String usuario;
     private String correo;
     private String contrasena;
}