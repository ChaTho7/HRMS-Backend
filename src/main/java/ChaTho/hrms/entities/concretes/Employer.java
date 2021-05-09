package ChaTho.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employers")
public class Employer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    public Employer(int id, String companyName, String website, String email, String phoneNumber, String password) {
        super();
        this.id = id;
        this.companyName = companyName;
        this.website = website;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
