package com.travelGo.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotelReqDTO {
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
