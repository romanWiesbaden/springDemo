package de.sva.bootcamp.devops.springdemo.mapper;

import de.sva.bootcamp.devops.springdemo.dto.UserDto;
import de.sva.bootcamp.devops.springdemo.repository.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserMapper {


    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName());
    }

    public List<UserDto> toUserDtos(List<User> users) {
        if (users == null) {
            return null;
        }

        var userDtos = new ArrayList<UserDto>(users.size());
        for (var user : users) {
            if (user != null) {
                userDtos.add(toUserDto(user));
            }
        }

        return Collections.unmodifiableList(userDtos);
    }
}

