package com.travelGo.web.service.core.impl;

import com.travelGo.web.dto.HotelReqDTO;
import com.travelGo.web.dto.HotelRespDTO;
import com.travelGo.web.model.Hotel;
import com.travelGo.web.repo.HotelRepo;
import com.travelGo.web.service.aws.s3.S3Service;
import com.travelGo.web.service.core.HotelService;
import com.travelGo.web.util.exception.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;
    private  S3Service s3Service;
    @Value("${aws.s3.bucket}")
    private String s3Bucket;

    @Autowired
    public HotelServiceImpl(HotelRepo hotelRepo, S3Service s3Service) {
        this.s3Service = s3Service;
        this.hotelRepo = hotelRepo;
    }


    @Override
    public Hotel create(HotelReqDTO hotel) {
        Hotel entity = new Hotel(
                hotel.getId(),
                hotel.getHotelName(),
                hotel.getLocation(),
                hotel.getGoogleLocationUrl(),
                hotel.getEmail(),
                hotel.getMobileNumber(),
                hotel.getPricePerDay(),
                hotel.getNumOfRoomsAvailable(),
                hotel.isAllowPets()
        );
        return hotelRepo.save(entity);
    }

    @Override
    public HotelRespDTO findOne(String id) {
        Optional<Hotel> byId = hotelRepo.findById(id);
        if (byId.isPresent()){
            Hotel hotel = byId.get();
            return new HotelRespDTO(
                    hotel.getId(),
                    hotel.getHotelName(),
                    hotel.getLocation(),
                    hotel.getGoogleLocationUrl(),
                    hotel.getEmail(),
                    hotel.getMobileNumber(),
                    hotel.getPricePerDay(),
                    hotel.getNumOfRoomsAvailable(),
                    hotel.isAllowPets()
            );
        }else {
            throw new EntryNotFoundException("Cant find hotel "+id);
        }
    }

    @Override
    public Hotel modify(HotelReqDTO hotel) {
        Hotel entity = new Hotel(
                hotel.getId(),
                hotel.getHotelName(),
                hotel.getLocation(),
                hotel.getGoogleLocationUrl(),
                hotel.getEmail(),
                hotel.getMobileNumber(),
                hotel.getPricePerDay(),
                hotel.getNumOfRoomsAvailable(),
                hotel.isAllowPets()
        );
        return hotelRepo.save(entity);
    }

    @Override
    public String remove(String id) {
        Optional<Hotel> hotel = hotelRepo.findById(id);
        if (hotel.isPresent()){
            hotelRepo.delete(hotel.get());
            return hotel.get().getId();
        }else{
            throw new EntryNotFoundException("Cant find hotel "+id);
        }
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepo.findAll();
    }


}
