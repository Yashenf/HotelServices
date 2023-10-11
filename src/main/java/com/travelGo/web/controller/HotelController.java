package com.travelGo.web.controller;

import com.travelGo.web.dto.HotelReqDTO;
import com.travelGo.web.dto.HotelRespDTO;
import com.travelGo.web.model.Hotel;
import com.travelGo.web.service.aws.s3.S3Service;
import com.travelGo.web.service.core.HotelService;
import com.travelGo.web.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService service;
    private final S3Service s3Service;

    @Autowired
    public HotelController(HotelService service, S3Service s3Service) {
        this.service = service;
        this.s3Service = s3Service;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> saveHotel(@RequestBody HotelReqDTO hotel) {
        Hotel newHotel = service.create(hotel);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        201,
                        "Created New Hotel Profile Successfully",
                        newHotel
                ), HttpStatus.CREATED
        );
    }



    @GetMapping("{id}")
    public ResponseEntity<StandardResponse> getHotel(@PathVariable String id){
        HotelRespDTO hotel = service.findOne(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Found Data!",
                        hotel
                ), HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateHotel(@RequestBody HotelReqDTO hotel){
        Hotel modified = service.modify(hotel);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        204,
                        "Updated!",
                        hotel
                ), HttpStatus.NO_CONTENT
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StandardResponse> deleteHotel(@PathVariable String id){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Deleted!",
                        id
                ), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllHotels(){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "All Hotels!",
                        service.findAll()
                ), HttpStatus.OK
        );
    }

}
