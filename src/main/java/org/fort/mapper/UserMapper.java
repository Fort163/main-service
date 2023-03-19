package org.fort.mapper;

import org.fort.entity.UserEntity;
import org.fort.shemas.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserEntity entity);

    UserEntity toUserEntity(User user);

    List<User> toUserList(Collection<UserEntity> collection);

}
