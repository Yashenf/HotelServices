package com.travelGo.web.service.core;

import com.travelGo.web.model.HotelImage;
import org.springframework.web.multipart.MultipartFile;

public interface HotelImageService {
    HotelImage saveUrl(String id , String url);
    String getUrl(String id);
    String uploadImage(String id, MultipartFile file);
}
