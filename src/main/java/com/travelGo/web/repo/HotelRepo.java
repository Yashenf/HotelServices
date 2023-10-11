package com.travelGo.web.repo;

import com.travelGo.web.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends MongoRepository<Hotel,String> {

}
