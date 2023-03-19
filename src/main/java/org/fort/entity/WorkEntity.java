package org.fort.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "work")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<UserEntity> users;


}
