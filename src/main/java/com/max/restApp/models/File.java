package com.max.restApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "file", schema = "public")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "file_status")
    private FileStatus fileStatus;
    @Column(name = "text")
    private String text;
    @Column(name = "format")
    private String format;
    @Column(name = "created")
    private LocalDateTime created;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
}
