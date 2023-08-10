package com.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            // If at the time of fetching data of course material , course should also be fetched then it should be eager otherwise it should be lazy
            fetch = FetchType.EAGER,
            // whenever we are saving a course material compulsory there should be a course is there with course material
            optional = false

    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"

    )
    private Course course;
}
