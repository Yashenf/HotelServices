package com.travelGo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelRespDTO {
    private String id;
    private String hotelName;
    private String location;
    private String googleLocationUrl;
    private String email;
    private String mobileNumber;
    private double pricePerDay;
    private int numOfRoomsAvailable;
    private boolean isAllowPets;
}
