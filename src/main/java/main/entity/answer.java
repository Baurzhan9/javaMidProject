package main.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    private boolean true_answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    private question question;

    public main.entity.question getQuestion() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isTrue_answer() {
        return true_answer;
    }

    public void setTrue_answer(boolean true_answer) {
        this.true_answer = true_answer;
    }
}
