package rs.ac.metropolitan.eLearning.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "answer")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Answer implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;
    @Column(name = "text")
    private String text;
    @Column(name = "correct")
    private Boolean correct;

    public Answer(Question question, String text, Boolean correct) {
        this.question = question;
        this.text = text;
        this.correct = correct;
    }

    @Override
    public String toString() {
        return text;
    }
}
