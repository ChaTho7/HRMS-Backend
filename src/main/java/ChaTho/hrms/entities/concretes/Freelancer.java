package ChaTho.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "freelancers")
public class Freelancer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "birth_year")
    private String birthYear;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public Freelancer(){};

    public Freelancer(int id, String name, String surname, String nationalityId, String birthYear, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationalityId = nationalityId;
        this.birthYear = birthYear;
        this.email = email;
        this.password = password;
    }
}
