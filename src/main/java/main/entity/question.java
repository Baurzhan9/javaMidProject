package main.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam")
    private exam exam;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<answer> answer;

    public main.entity.exam getExam() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<main.entity.answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<main.entity.answer> answer) {
        this.answer = answer;
    }
}
