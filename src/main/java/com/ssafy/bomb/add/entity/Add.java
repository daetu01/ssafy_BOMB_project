package com.ssafy.bomb.add.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Add {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "title")
    private String title ;

    @Column(name = "href")
    private String href;

    @Column(name = "imageUrl")
    private String imageUrl;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endDate;

    @CreatedDate
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt ;
}
