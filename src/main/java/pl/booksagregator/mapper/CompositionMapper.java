package pl.booksagregator.mapper;

import org.bson.types.ObjectId;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.booksagregator.model.dao.CompositionDao;
import pl.booksagregator.model.dao.RatingDao;
import pl.booksagregator.model.dto.CompositionDto;

import java.util.ArrayList;

@Component
public class CompositionMapper {

    public CompositionDao mapDtoToDao(CompositionDto compositionDto) {
        CompositionDao compositionDao = new CompositionDao();
        compositionDao.setId(ObjectId.get());
        compositionDao.setName(compositionDto.getName());
        compositionDao.setDescription(compositionDto.getDescription());
        compositionDao.setTags(compositionDto.getTags());
        compositionDao.setOpen(compositionDto.getOpen());
        compositionDao.setRelease(compositionDto.getRelease());
        compositionDao.setRating(new RatingDao());
        compositionDao.setResources(new ArrayList<>());
        return compositionDao;
    }

    public CompositionDto mapDaoToDto(String username, CompositionDao compositionDao) {
        CompositionDto compositionDto = new CompositionDto();
        compositionDto.setName(compositionDao.getName());
        compositionDto.setCreator(username);
        compositionDto.setDescription(compositionDao.getDescription());
        compositionDto.setTags(compositionDao.getTags());
        compositionDto.setOpen(compositionDao.getOpen());
        compositionDto.setRelease(compositionDao.getRelease());
        compositionDto.setRating(calculateRating(compositionDao.getRating().getScore(), compositionDao.getRating().getCount()));
        compositionDto.setId(compositionDao.getId().toString());
        return compositionDto;
    }

    private double calculateRating(double score, int count) {
        return score/count;
    }
}
