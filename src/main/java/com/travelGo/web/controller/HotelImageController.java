package com.travelGo.web.controller;

import com.travelGo.web.service.core.HotelImageService;
import com.travelGo.web.util.response.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/hotels/img")
public class HotelImageController {

    private final HotelImageService service;

    @Autowired
    public HotelImageController(HotelImageService service) {
        this.service = service;
    }

    @PostMapping("{id}")
    public ResponseEntity<StandardResponse> uploadHotelImage(
            @PathVariable String id,
            @RequestParam("file") MultipartFile file
    ) {
        String url = service.uploadImage(id, file);
        saveInDb(id,url);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Url of Hotel img",
                        url
                ), HttpStatus.OK
        );

    }
    public void saveInDb(String id, String url) {
        service.saveUrl(id,url);
    }

    @GetMapping("{id}")
    public ResponseEntity<StandardResponse> getImage(@PathVariable String id){
        String url = service.getUrl(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        200,
                        "Url of Hotel img",
                        url
                ), HttpStatus.OK
        );
    }
}
