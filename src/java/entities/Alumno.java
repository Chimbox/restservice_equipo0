 package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Alfonso Felix
 */
@Entity
public class Alumno extends EntityBase implements Serializable {

    @Column (name="nombre", length=100, nullable=false)
    private String nombre;
    
    @Column (name="matricula", length=11, nullable=false, unique=true)
    private String matricula;
    
    @Column (name="curp", length=18, nullable=false)
    private String curp;
    
    @Column (name="edad")
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", matricula=" + matricula + ", curp=" + curp + ", edad=" + edad + '}';
    }
}
