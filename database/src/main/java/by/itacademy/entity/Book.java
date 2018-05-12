package by.itacademy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book", schema = "library_storage")
public class Book extends BaseEntity<Long> {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "image")
    private String image;

    @Column(name = "number_copies")
    private Integer numberCopies;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "book")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Vote> votes = new ArrayList<>();

    public Book(String name, Genre genre, Author author, Publisher publisher,
                Integer pageCount, String image, Integer numberCopies, String description) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.image = image;
        this.numberCopies = numberCopies;
        this.description = description;
    }
}
