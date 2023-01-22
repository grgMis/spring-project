package com.example.mainproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.annotations.CollectionId;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.util.List;

@Entity
public class DeptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dept_id;

    @Column(nullable = false)
    private Integer dept_parent_id;

    @ManyToOne
    @JoinColumn(name = "dept_type_id", nullable = false)
    private DeptTypeEntity dept_type_id;

    @Column(nullable = false)
    private Integer dept_number;

    @Column(nullable = false, length = 40)
    private String dept_name;

    @Column(nullable = true, length = 20)
    private String dept_sname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dept_id")
    private List<WellEntity> wellEntityList;


    public DeptEntity() {
    }

    public List<WellEntity> getWellEntityList() {
        return wellEntityList;
    }

    public void setWellEntityList(List<WellEntity> wellEntityList) {
        this.wellEntityList = wellEntityList;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getDept_parent_id() {
        return dept_parent_id;
    }

    public void setDept_parent_id(Integer dept_parent_id) {
        this.dept_parent_id = dept_parent_id;
    }

    public DeptTypeEntity getDept_type_id() {
        return dept_type_id;
    }

    public void setDept_type_id(DeptTypeEntity dept_type_id) {
        this.dept_type_id = dept_type_id;
    }

    public Integer getDept_number() {
        return dept_number;
    }

    public void setDept_number(Integer dept_number) {
        this.dept_number = dept_number;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDept_sname() {
        return dept_sname;
    }

    public void setDept_sname(String dept_sname) {
        this.dept_sname = dept_sname;
    }
}
