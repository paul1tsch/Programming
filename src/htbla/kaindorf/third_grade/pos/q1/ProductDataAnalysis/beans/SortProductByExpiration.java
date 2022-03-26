package htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.beans;

import java.util.Comparator;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        SortProductByExpiration.java
 */

public class SortProductByExpiration implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
