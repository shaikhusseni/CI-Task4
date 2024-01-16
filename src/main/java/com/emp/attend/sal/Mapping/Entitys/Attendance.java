package com.emp.attend.sal.Mapping.Entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMPLOYEE_ATTENDANCE")
@Entity
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ATTEN_ID")
    private  Long attendId;

    public void setAttendId(Long attendId) {
        this.attendId = attendId;
    }

    @Column(name="ATTEND_STATUS")
    private  String attendStatus;
    @Column(name="ATTEND_CREATED_DATE")
    private Date attendCreate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_ID")
    private Employee employee;



}
