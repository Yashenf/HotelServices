package com.travelGo.web.service.core;

import com.travelGo.web.dto.HotelReqDTO;
import com.travelGo.web.dto.HotelRespDTO;
import com.travelGo.web.model.Hotel;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.io.File;
import java.util.List;

public interface HotelService {
    Hotel create(HotelReqDTO hotel);
    HotelRespDTO findOne(String id);
    Hotel modify(HotelReqDTO hotel);
    String remove(String id);
    List<Hotel> findAll();

}
