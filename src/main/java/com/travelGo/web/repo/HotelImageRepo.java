package com.travelGo.web.repo;

import com.travelGo.web.model.HotelImage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelImageRepo extends MongoRepository<HotelImage,String> {
}
