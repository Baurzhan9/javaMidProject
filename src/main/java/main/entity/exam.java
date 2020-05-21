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
public class exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long time;
    private String description;

    @OneToOne
    @MapsId
    private lesson lesson;

    @OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
    private List<question> question;

    public lesson getLesson() {
        return null;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<main.entity.question> getQuestion() {
        return question;
    }

    public void setQuestion(List<main.entity.question> question) {
        this.question = question;
    }
}
