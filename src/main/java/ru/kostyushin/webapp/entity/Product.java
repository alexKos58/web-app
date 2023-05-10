package ru.kostyushin.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Наименование товара
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * Описание товара
     */
    @Column(name = "product_description")
    private String productDescription;

    /**
     * Производитель
     */
    @Column(name = "manufacturer")
    private String productManufacturer;

    /**
     * Цена
     */
    private Integer price;

    /**
     * Дата добавления
     */
    @Basic
    @Column(name = "date_add")
    private final LocalDate localDate = LocalDate.now();

    /**
     * Категория, к которой относится товар
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}
