package uz.mutalov.travellog.dto.log;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class DataSort {

    private String numOrName;

    private LocalDate firstDate;

    private LocalDate lastDate;

    public DataSort() {

    }

    public DataSort(String numOrName) {
        this.numOrName = numOrName;
    }

    public DataSort(String firstDate, String lastDate) {
        this.firstDate = LocalDate.parse(firstDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.lastDate = LocalDate.parse(lastDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public DataSort(String numOrName, String firstDate, String lastDate) {
        this(firstDate,lastDate);
        this.numOrName = numOrName;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = LocalDate.parse(firstDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public void setLastDate(String lastDate) {
        this.lastDate = LocalDate.parse(lastDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }



}
