package ChaTho.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
public class JobPositon {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public JobPositon(){}

    public JobPositon(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
