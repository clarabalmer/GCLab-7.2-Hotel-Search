package co.grandcircus.HotelSearch;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
	List<Hotel> findAll();
	List<Hotel> findByCityOrderByPricePerNightAsc(String city);
	Optional<Hotel> findById(String id);
	
}
