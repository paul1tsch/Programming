package htbla.kaindorf.second_grade.pos.q2.Currency.beans;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Rate.java
 */

public class Rate {

    public static void main(String[] args) throws IOException {
        new Rate().downloadRate();
    }

    public String downloadRate() {
        String result = "1.0";

        try {
            URL url = new URL("https://currencies.apps.grandtrunk.net/getlatest/eur/usd");

            Scanner scan = new Scanner(url.openStream());
            StringBuilder sb = new StringBuilder();

            while (scan.hasNext()) {
                sb.append(scan.next());
            }

            result = sb.toString();
            System.out.println(result);

            result = result.replaceAll("<[^>]*>", "");
            System.out.println("Contents of the web page: " + result);

        } catch (Exception ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
