package pl.booksagregator.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.booksagregator.model.dao.UserDao;
import pl.booksagregator.model.dto.UserDto;

import java.util.ArrayList;

@Component
public class UserMapper {

    public UserDao mapDtoToDao(UserDto userDto) {
        UserDao userDao = new UserDao();
        userDao.setId(userDto.getId());
        userDao.setUsername(userDto.getUsername());
        userDao.setPassword(new BCryptPasswordEncoder().encode(userDao.getPassword()));
        userDao.setEmail(userDto.getEmail());
        userDao.setBirth(userDto.getBirth());
        userDao.setSearched(new ArrayList<>());
        userDao.setFavorites(new ArrayList<>());
        userDao.setCompositions(new ArrayList<>());
        return userDao;
    }

    public UserDto mapDaoToDto(UserDao userDao) {
        UserDto userDto = new UserDto();
        userDto.setId(userDao.getId());
        userDto.setUsername(userDao.getUsername());
        userDto.setPassword(userDao.getPassword());
        userDto.setEmail(userDao.getEmail());
        userDto.setBirth(userDao.getBirth());
        return userDto;
    }




}
