package pl.jacek;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class Utils {
    //TODO

    // URL of the webpage
    static String url = "https://www.margonem.pl/";

    // ID of the div to check for
    static String divClassName = "Szybkie Newsy";

    public static boolean checkIfClassExists(String priority, int durationInMinutes, int delayInSeconds) {
        boolean divPresent = false;
        try {
            // Make an HTTP request to the webpage and retrieve its HTML content
            Document doc = Jsoup.connect(url).get();

            // Find all div elements in the HTML document
            Elements divElements = doc.getElementsByTag("span");

            // Iterating over each div element
            for (Element div : divElements) {
                if (Objects.equals(div.text(), priority)) {
                    divPresent = true;
                    break;
                }
            }

            if (divPresent) {
                System.out.println("The div with ID '" + divClassName + "' is present.");
            } else {
                System.out.println("The div with ID '" + divClassName + "' is not present.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return divPresent;
    }
}