package com.travelGo.web.service.core.impl;

import com.travelGo.web.model.HotelImage;
import com.travelGo.web.repo.HotelImageRepo;
import com.travelGo.web.repo.HotelRepo;
import com.travelGo.web.service.aws.s3.S3Service;
import com.travelGo.web.service.core.HotelImageService;
import com.travelGo.web.util.exception.AwsS3ImageUpOrDownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class HotelImageSurviveImpl implements HotelImageService {

    private HotelImageRepo repo;
    private final HotelRepo hotelRepo;
    private S3Service s3Service;
    @Value("${aws.s3.bucket}")
    private String s3Bucket;

    @Autowired
    public HotelImageSurviveImpl(HotelImageRepo repo, HotelRepo hotelRepo, S3Service s3Service) {
        this.repo = repo;
        this.hotelRepo = hotelRepo;
        this.s3Service = s3Service;
    }

    @Override
    public HotelImage saveUrl(String id, String url) {
        return repo.save(new HotelImage(id, url));
    }

    @Override
    public String getUrl(String id) {
        return repo.findById(id).get().getFileUrl();
    }

    @Override
    public String uploadImage(String id, MultipartFile file) {
        try {
            return s3Service.putObject(
                    s3Bucket,
                    "hotelImages/%s".formatted(id),
                    file
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new AwsS3ImageUpOrDownException("Image not uploaded");
    }
}
