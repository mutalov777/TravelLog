package uz.mutalov.travellog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class tes {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate fi=LocalDate.parse("2022-02-11",formatter);
        System.out.println("fi = " + fi);
    }
}
