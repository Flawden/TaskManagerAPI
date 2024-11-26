package com.flawden.TaskManagerAPI.mapper;

import com.flawden.TaskManagerAPI.dto.user.Login;
import com.flawden.TaskManagerAPI.dto.user.Register;
import com.flawden.TaskManagerAPI.dto.user.UpdateUser;
import com.flawden.TaskManagerAPI.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserEntityToUser(UserEntity userEntity);

    UserEntity mapUserToUserEntity(User user);

    UpdateUser mapUserEntityToUpdateUser(UserEntity userEntity);

    UserEntity mapUpdateUserToUserEntity(UpdateUser updateUser);

    Register mapUserEntityToRegister(UserEntity userEntity);

    UserEntity mapRegisterToUserEntity(Register register);

    Login mapUserEntityToLogin(UserEntity userEntity);

    UserEntity mapLoginToUserEntity(Login login);

}
