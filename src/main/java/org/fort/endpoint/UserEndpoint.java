package org.fort.endpoint;

import lombok.AllArgsConstructor;
import org.fort.service.UserService;
import org.fort.shemas.application.GetUserRequest;
import org.fort.shemas.application.GetUserResponse;
import org.fort.shemas.application.UserList;
import org.fort.shemas.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

import static org.fort.mapper.UserMapper.USER_MAPPER;

@Endpoint
@AllArgsConstructor
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://www.fort.org/shemas/application";

    private final UserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        List<User> users = USER_MAPPER.toUserList(userService.getAllUsers());
        UserList userList = new UserList();
        users.stream().forEach(item -> userList.getUser().add(item));
        response.setUserList(userList);
        return response;
    }

}
