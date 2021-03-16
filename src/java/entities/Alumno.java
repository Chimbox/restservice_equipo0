package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Alfonso Felix
 */
@Entity
public class Alumno extends EntityBase implements Serializable {

    private String nombre;

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
