package htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis;

import htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.beans.Product;
import htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.beans.SortProductByExpiration;
import htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.io.ProductIO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        ProductBL.java
 */

public class ProductBL {

    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMMM-yyyy");
    private static final DateTimeFormatter EXPIRE_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static int totalProducts = 0;
    public static int differentProducts = 0;
    public static double totalPrice = 0;
    public static int totalNumber = 0;
    public static LocalDate maxExpDate = LocalDate.MIN;
    public static LocalDate minExpDate = LocalDate.MAX;
    private Map<YearMonth, List<Product>> productMap = new HashMap<>();

    public static void main(String[] args) {
        new ProductBL().run();
    }

    public void addProduct(Product product) {
        try {
            YearMonth yearMonth = YearMonth.from(product.getExpiration());
            List<Product> productList = productMap.get(yearMonth);
            totalProducts++;
            totalNumber += product.getQuantity();
            totalPrice += product.getPrice() * product.getQuantity();
            if (productList == null) {
                List<Product> products = new ArrayList<>();
                products.add(product);
                productMap.put(yearMonth, products);
            } else {
                if (product.getExpiration().isAfter(maxExpDate)) {
                    maxExpDate = product.getExpiration();
                }
                if (product.getExpiration().isBefore(minExpDate)) {
                    minExpDate = product.getExpiration();
                }
                if (productList.contains(product)) {
                    Product originalProduct = productList.get(productList.indexOf(product));
                    originalProduct.setQuantity(originalProduct.getQuantity() + product.getQuantity());
                } else {
                    productList.add(product);
                    differentProducts++;
                }
            }
        } catch (Exception e) {
            System.out.println("\t\t[-] Can't add Product");
        }

    }

    public void deleteProduct(String name, String details) {
        try {
            Product deletionProduct = new Product(name, details);
            for (Map.Entry<YearMonth, List<Product>> entry : productMap.entrySet()) {
                if (entry.getValue().contains(deletionProduct)) {
                    differentProducts--;
                    totalNumber -= entry.getValue().get(entry.getValue().indexOf(deletionProduct)).getQuantity();
                    totalPrice -= entry.getValue().get(entry.getValue().indexOf(deletionProduct)).getQuantity() *
                            entry.getValue().get(entry.getValue().indexOf(deletionProduct)).getPrice();
                    entry.getValue().remove(deletionProduct);
                }
            }
        } catch (Exception e) {
            System.out.println("\t\t[-] Can't delete Product");
        }
    }

    public void printProductsOfMonth(YearMonth yearMonth) {
        List<Product> productList = productMap.get(yearMonth);
        System.out.println("Products from " + yearMonth.format(YEAR_MONTH_FORMATTER));
        productList.sort(new SortProductByExpiration());
        for (Product product : productList) {
            System.out.println("\t" + product);
        }
    }

    public void printStatistics() {
        System.out.println("\nProduct Statistics:");
        System.out.println("\tProducts read: " + totalProducts);
        System.out.println("\tDifferent Products: " + differentProducts);
        System.out.printf("\tTotal price of all Products: %,.2f €\n", totalPrice);
        System.out.printf("\tTotal number of items: %,d\n", totalNumber);
        System.out.println("\tMinimum expiration date: " + minExpDate.format(EXPIRE_DATE_FORMATTER));
        System.out.println("\tMaximum expiration date: " + maxExpDate.format(EXPIRE_DATE_FORMATTER) + "\n");
    }

    public void run() {
        try {
            productMap = ProductIO.readProducts();
            printProductsOfMonth(YearMonth.of(2019, 5));
            printStatistics();
            deleteProduct("Turkey", "Breast, Smoked");
            Product p1 = new Product("Kaiserschmarrn", "Delicious", 12, 12.30, LocalDate.of(2019, Month.MAY, 12));
            addProduct(p1);
            printProductsOfMonth(YearMonth.of(2019, 5));
            printStatistics();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
