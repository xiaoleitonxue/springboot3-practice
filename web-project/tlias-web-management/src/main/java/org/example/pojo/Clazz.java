package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer id;
    private String name;
    private String room;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Integer masterId;
    private String masterName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String status;
}
