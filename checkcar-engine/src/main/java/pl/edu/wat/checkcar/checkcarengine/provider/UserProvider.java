package pl.edu.wat.checkcar.checkcarengine.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.checkcar.checkcardomain.base.BaseCrudProvider;
import pl.edu.wat.checkcar.checkcardomain.dto.UserDto;
import pl.edu.wat.checkcar.checkcardomain.entity.User;
import pl.edu.wat.checkcar.checkcarengine.repository.UserRepository;

/**
 * Created by Aleksander Małkowicz, Date: 25.05.2018
 * Copyright by Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2018
 */
@Component
public class UserProvider extends BaseCrudProvider<User,UserDto> {

    @Autowired
    UserRepository repo;

    public UserDto createUser(UserDto userDto){
        return convert(repo.save(convertToEntity(userDto,null)));
    }

    public UserDto getUser(Long userId){
        return convert(repo.findOne(userId));
    }

    public void updateUser(Long userId,UserDto userDto){
        repo.save(convertToEntity(userDto,repo.findOne(userId)));
    }

    public void deleteUser(Long userId){
        repo.delete(userId);
    }

    @Override
    protected User convertToEntity(UserDto dto, User entity) {
        if (entity == null) {
            entity = new User();
        }
        if(dto.getName() != null){
            entity.setName(dto.getName());
        }
        if(dto.getSurname() != null){
            entity.setSurname(dto.getSurname());
        }
        if(dto.getBirthday() != null){
            entity.setBirthday(dto.getBirthday());
        }
        if(dto.getEmail() != null){
            entity.setEmail(dto.getEmail());
        }
        if(dto.getPassword() != null){
            entity.setPassword(dto.getPassword());
        }
        if(dto.getCarList() != null){
            entity.setCarList(dto.getCarList());
        }

        return entity;
    }
}
