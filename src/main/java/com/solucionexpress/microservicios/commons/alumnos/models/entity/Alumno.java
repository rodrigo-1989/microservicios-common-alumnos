package com.solucionexpress.microservicios.commons.alumnos.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    @NotEmpty
    @Email
    private String email;

    @Column(name = "create_At")
    private Date createAt;

    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if( !(obj instanceof Alumno) ) {
			return false;
		}
		
		Alumno a = (Alumno )obj;
		
		return this.id != null && this.id.equals(a.getId());
	}
    
    
}
