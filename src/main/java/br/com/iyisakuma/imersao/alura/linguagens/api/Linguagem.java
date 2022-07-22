package br.com.iyisakuma.imersao.alura.linguagens.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Linguagens")
public class Linguagem {
    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public Linguagem(){}

    public Linguagem(String id, String title, String image, int ranking) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public Linguagem(String title, String image, int ranking) {
        this.title = title;
        this.image = image;
        this.ranking = ranking;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
