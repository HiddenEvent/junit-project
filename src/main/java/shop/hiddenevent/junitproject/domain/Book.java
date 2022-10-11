package shop.hiddenevent.junitproject.domain;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "Book")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id
    @Column(length = 32, nullable = false)
    private String id;
    @Column(length = 50, nullable = false)
    private String title;
    @Column(length = 20, nullable = false)
    private String author;

    @Builder(builderClassName = "AllArgsSaveBuilder", builderMethodName = "AllArgsSaveBuilder")
    public Book(String id, String title, String author) {
        Assert.notNull(id, "id must not be null");
        Assert.notNull(title, "title must not be null");
        Assert.notNull(author, "author must not be null");
        this.id = id;
        this.title = title;
        this.author = author;
    }
}
