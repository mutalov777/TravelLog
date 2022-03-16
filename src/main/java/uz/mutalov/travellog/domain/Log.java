package uz.mutalov.travellog.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "childbuilder")
@Table(schema = "log")
public class Log extends Auditable{

    @CreatedDate
    @CreationTimestamp
    @Column(name = "date",columnDefinition = "timestamp default now()",nullable = false)
    private LocalDate date;

    @Column(name = "first_odometr_value",nullable = false)
    private Integer firstOdometrvalue;

    @Column(name = "last_odometr_value",nullable = false)
    private Integer lastOdometrvalue;

    @Column(name = "owner_name",nullable = false)
    private String ownerName;

    @Column(name = "registration_number",nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String route;
}
