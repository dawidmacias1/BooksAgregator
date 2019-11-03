package pl.booksagregator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import pl.booksagregator.model.dao.UserDao;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDao, String> {

    Optional<UserDao> findByUsername(String username);
    boolean existsByUsername(String username);

    @Query("{ 'compositions': { $elemMatch: { '_id': ?0} } }")
    Optional<UserDao> findUserByCompositionId(String id);

}
