package com.quythuong.BakeryManagementSystem.Category;

import com.quythuong.BakeryManagementSystem.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "img_path")
    private String imgPath;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> productList;
}
