package org.lessons.java.progetto_finale.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videogames")
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "campo obbligatorio")
    @Size(max=30, message = "il titolo non può superare i 30 caratteri")
    private String title;

    @NotBlank(message = "campo obbligatorio")
    @Size(min=10, message = "la descrizione deve contenere almeno 10 caratteri")
    @Lob
    private String description;

    @NotBlank(message = "campo obbligatorio")
    @Size(min=1, message = "inserire classificazione per età ")
    private String ageRating;

    @NotNull(message = "campo obbligatorio")
    private LocalDate releaseDate;

    @PositiveOrZero(message = "campo obbligatorio")
    private Integer download;

    @PositiveOrZero(message = "campo obbligatorio")
    private float sizeGB;

    @NotBlank(message = "campo obbligatorio")
    @Lob
    private String image;

    @PositiveOrZero(message = "campo obbligatorio")
    private float price;

    @ManyToOne
    @JoinColumn(name= "publisher_id", nullable = false) 
    @JsonBackReference
    private Publisher publisher;

    @ManyToMany()
    @JoinTable(
        name="category-videogame",
        joinColumns = @JoinColumn(name="videogame_id"),
        inverseJoinColumns = @JoinColumn(name="category-id")
    )
    private List<Category> categories;
    

    public String getAgeRating() {
        return this.ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDownload() {
        return this.download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public float getSizeGB() {
        return this.sizeGB;
    }

    public void setSizeGB(float sizeGB) {
        this.sizeGB = sizeGB;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}
