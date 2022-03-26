package htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.beans;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Product.java
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements Comparable<Product>{

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    @NonNull
    private String name;
    @NonNull
    private String details;
    private int quantity;
    private double price;
    private LocalDate expiration;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        if (details.isEmpty()) {
            return String.format("%s, expires on %s costs %.2f €.", name, expiration.format(dtf), price);
        }
        return String.format("%s - %s, expires on %s costs %.2f €.", name, details, expiration.format(dtf), price);
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.getPrice(), o.getPrice());
    }

}
