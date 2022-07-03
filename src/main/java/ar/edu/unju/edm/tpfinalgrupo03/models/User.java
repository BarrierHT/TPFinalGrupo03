package ar.edu.unju.edm.tpfinalgrupo03.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo Obligatorio")
    @Min(value = 1000000, message = "El DNI debe ser mayor que 1.000.000")
    @Max(value = 99999999, message = "El DNI debe ser menor que 99.999.999")
    @Column(unique = true, nullable = false)
    private Integer idCard;
    // @NotEmpty(message = "Campo Obligatorio")
    // @Size(min = 4, max = 12, message = "La contraseña debe tener entre 4 y 12
    // caracteres")
    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{4,12}$", message = "Siga el
    // formato indicado")
    private String password;
    private String role = "CLIENT";
    @NotEmpty(message = "Campo Obligatorio")
    @Size(max = 30, message = "El nombre ingresado es demasiado largo")
    @NotBlank(message = "Ingrese un nombre posible")
    private String name;
    @NotEmpty(message = "Campo Obligatorio")
    @Size(max = 30, message = "El apellido ingresado es demasiado largo")
    @NotBlank(message = "Ingrese un apellido posible")
    private String surname;
    private Boolean status = true;

    public User() {
    }

    public User(Integer id, Integer idCard, String password, String role, String name, String surname,
            Boolean status) {
        this.id = id;
        this.idCard = idCard;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}