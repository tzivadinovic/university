package rs.ac.metropolitan.eLearning.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "test")
@Data
public class Test implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Column(name = "max_points")
    private Double maxPoints;
    @ManyToMany
    @JoinTable(name = "question_test", joinColumns = @JoinColumn(name = "test_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;
    @ManyToMany
    @JoinTable(name = "user_test", joinColumns = @JoinColumn(name = "test_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
