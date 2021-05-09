package ChaTho.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "JobPositions")
public class JobPositon {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public JobPositon(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
