package id.co.mii.overtimeserverapp.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reimburse")
public class Reimburse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nominal", nullable = false)
    private int nominal;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime date_time;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private Type type;

    @OneToMany(mappedBy="reimburse")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HistoryReimburse> HistoryReimburse;
}
