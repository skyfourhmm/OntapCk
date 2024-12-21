package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long candidateId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String phone;
    @Column(unique = true)
    private String email;
    @Column(name = "full_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate")
    private List<CandidateSkill> candidateSkills;

}