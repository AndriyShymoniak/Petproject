package com.shymoniak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "square")
    private Integer square;

    @Column(name = "floor")
    private Integer floor;

    public Room(Integer square, Integer floor) {
        this.square = square;
        this.floor = floor;
    }
}
