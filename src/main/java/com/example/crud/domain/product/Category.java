package com.example.crud.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="category")
@Entity(name="category")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Boolean active;

    public Category(RequestCategoryDTO requestCategory){
        this.name = requestCategory.name();
        this.active = true;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}