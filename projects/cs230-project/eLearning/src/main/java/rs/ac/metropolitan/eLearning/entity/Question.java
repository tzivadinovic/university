package rs.ac.metropolitan.eLearning.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;
    @Column(name = "text")
    private String text;
    @Column(name = "answer")
    private String answer;
    @Column(name = "points")
    private Double points;
    @ToString.Exclude
    @ManyToMany(mappedBy = "questions")
    private List<Test> tests;

    @Override
    public String toString() {
        return text + ", " + points + " points";
    }
}
