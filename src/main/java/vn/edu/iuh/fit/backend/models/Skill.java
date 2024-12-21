package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.backend.enums.SkillType;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long skillId;
    private String skillName;
    @Column(name = "skill_desc")
    private String skillDescription;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;

    @OneToMany(mappedBy = "skill")
    private List<CandidateSkill> candidateSkills;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;
}