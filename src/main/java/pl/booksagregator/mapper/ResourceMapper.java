package pl.booksagregator.mapper;

import org.springframework.stereotype.Component;
import pl.booksagregator.model.dao.RatingDao;
import pl.booksagregator.model.dao.ResourceDao;
import pl.booksagregator.model.dto.ResourceDto;

@Component
public class ResourceMapper {

    public ResourceDto mapDaoToDto(ResourceDao resourceDao) {
        ResourceDto resourceDto = new ResourceDto();
        resourceDto.setId(resourceDao.getId());
        resourceDto.setKey(resourceDao.getKey());
        resourceDto.setRating(calculateRating(resourceDao.getRating().getScore(), resourceDao.getRating().getCount()));
        resourceDto.setType(resourceDao.getType());
        resourceDto.setViews(resourceDao.getViews());
        return resourceDto;
    }

    public ResourceDao mapDtoToDao(ResourceDto resourceDto) {
        ResourceDao resourceDao = new ResourceDao();
        resourceDao.setKey(resourceDto.getKey());
        resourceDao.setType(resourceDto.getType());
        resourceDao.setRating(new RatingDao());
        return resourceDao;
    }

    private double calculateRating(double score, int count) {
        return score/count;
    }


}
