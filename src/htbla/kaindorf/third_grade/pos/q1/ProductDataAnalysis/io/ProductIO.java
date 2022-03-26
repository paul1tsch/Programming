package htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.io;

import htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.ProductBL;
import htbla.kaindorf.third_grade.pos.q1.ProductDataAnalysis.beans.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        ProductIO.java
 */

public class ProductIO {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Map<YearMonth, List<Product>> readProducts() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "src", "resources", "products.csv");
        List<String> lines = Files.readAllLines(path);

        lines.remove(0);

        Map<YearMonth, List<Product>> productMap = new HashMap<>();

        String name;
        String details;
        LocalDate expirationDate;
        double price;
        int quantity;
        String dateText;
        YearMonth yearMonth;

        for (String line : lines) {
            dateText = line.substring(line.lastIndexOf(',') + 1);
            try {
                expirationDate = LocalDate.parse(dateText, DATE_TIME_FORMATTER);
                yearMonth = YearMonth.parse(dateText, DATE_TIME_FORMATTER);
                line = line.substring(0, line.lastIndexOf(','));
                if (expirationDate.isAfter(ProductBL.maxExpDate)) {
                    ProductBL.maxExpDate = expirationDate;
                }
                if (expirationDate.isBefore(ProductBL.minExpDate)) {
                    ProductBL.minExpDate = expirationDate;
                }
            } catch (DateTimeParseException e) {
                expirationDate = null;
                yearMonth = null;
            }

            price = Double.parseDouble(line.substring(line.lastIndexOf(',') + 1));
            line = line.substring(0, line.lastIndexOf(','));
            quantity = Integer.parseInt(line.substring(line.lastIndexOf(',') + 1));
            line = line.substring(0, line.lastIndexOf(','));
            line = line.replace("\"", "");
            name = line;
            details = "";

            if (line.contains("-")) {
                name = line.substring(0, line.indexOf('-') - 1);
                details = line.substring(line.indexOf('-') + 2);
            }

            ProductBL.totalPrice += price * quantity;
            ProductBL.totalNumber += quantity;

            Product insertionProduct = new Product(name, details, quantity, price, expirationDate);
            List<Product> productList;
            if (!productMap.containsKey(yearMonth)) {
                productMap.put(yearMonth, new ArrayList<>());
            }
            productList = productMap.get(yearMonth);
            ProductBL.totalProducts++;
            if (productList.contains(insertionProduct)) {
                Product product = productList.get(productList.indexOf(insertionProduct));
                product.setQuantity(product.getQuantity() + quantity);
            } else {
                productList.add(insertionProduct);
                ProductBL.differentProducts++;
            }
        }
        return productMap;
    }
}
