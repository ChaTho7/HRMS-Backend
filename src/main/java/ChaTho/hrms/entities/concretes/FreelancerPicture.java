package ChaTho.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "freelancer_pictures")
public class FreelancerPicture {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "freelancer_id")
    private int freelancerId;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "uuid")
    private String uuid;

    public FreelancerPicture() {}

    public FreelancerPicture(int freelancerId, String imagePath, LocalDate date, byte[] picture, String guid) {
        super();
        this.freelancerId = freelancerId;
        this.imagePath = imagePath;
        this.date = date;
        this.picture = picture;
        this.uuid = guid;
    }

    public FreelancerPicture(int id, int freelancerId, String imagePath, LocalDate date, byte[] picture, String guid) {
        super();
        this.id = id;
        this.freelancerId = freelancerId;
        this.imagePath = imagePath;
        this.date = date;
        this.picture = picture;
        this.uuid = guid;
    }
}
