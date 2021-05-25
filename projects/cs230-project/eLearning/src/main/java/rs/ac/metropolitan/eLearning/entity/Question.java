package rs.ac.metropolitan.eLearning.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "points")
    private Double points;
    @ManyToMany(mappedBy = "questions")
    private List<Test> tests;
}
