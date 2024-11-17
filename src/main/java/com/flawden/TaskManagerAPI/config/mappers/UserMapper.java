package com.flawden.TaskManagerAPI.config.mappers;

import com.flawden.TaskManagerAPI.dto.*;
import com.flawden.TaskManagerAPI.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    User mapUserEntityToUser(UserEntity userEntity);

    UserEntity mapUserToUserEntity(User user);

    UpdateUser mapUserEntityToUpdateUser(UserEntity userEntity);

    UserEntity mapUpdateUserToUserEntity(UpdateUser updateUser);

    @Mapping(source = "email", target = "username")
    @Mapping(source = "role", target = "role") // Просто маппинг для enum
    Register mapUserEntityToRegister(UserEntity userEntity);

    @Mapping(source = "username", target = "email")
    @Mapping(source = "role", target = "role") // Просто маппинг для enum
    UserEntity mapRegisterToUserEntity(Register register);

    Login mapUserEntityToLogin(UserEntity userEntity);

    UserEntity mapLoginToUserEntity(Login login);

    default Role mapStringToRole(String role) {
        return role == null ? null : Role.valueOf(role.toUpperCase());
    }

    default String mapRoleToString(Role role) {
        return role == null ? null : role.name();
    }

}
