package pl.booksagregator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.booksagregator.model.dao.ResourceDao;
import pl.booksagregator.model.dto.ResourceDto;

import java.util.List;

@Repository
public interface ResourceRepository extends MongoRepository<ResourceDao, String> {



}
