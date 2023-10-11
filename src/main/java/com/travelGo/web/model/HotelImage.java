package com.travelGo.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document("hotelImage")
public class HotelImage {
    private String id;
    private String fileUrl;
}
