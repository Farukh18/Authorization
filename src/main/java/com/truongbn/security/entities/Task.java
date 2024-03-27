package com.truongbn.security.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "describe")
    String describe;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    Status status;
    @ManyToOne
    @JoinColumn(name = "owner")
    User owner;
}
