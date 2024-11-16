package com.oyo.HotelManagment2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price_inventory_details")
public class PriceInventoryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "hotel_id")
    Integer hotelId;

    @Column(name = "room_id")
    Integer roomId;

    @Column(name = "available_rooms")
    Integer availableRooms;

    @Column(name = "price")
    Integer price;

    @Column(name="date")
    LocalDate date;

}
