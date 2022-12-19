package com.productuserapi.productUser.Controller;

import com.productuserapi.productUser.DTO.Existing;
import com.productuserapi.productUser.DTO.New;
import com.productuserapi.productUser.DTO.UserDto;
import com.productuserapi.productUser.Entity.User;
import com.productuserapi.productUser.Mapped.MapStructMapper;
import com.productuserapi.productUser.Service.EmailService;
import com.productuserapi.productUser.Service.UserService;
import com.productuserapi.productUser.validation.constraints.IdParametersEqual;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final MapStructMapper mapStructMapper;

    private final EmailService emailService;

    @GetMapping("/AllUser")
    public List<UserDto> getAllUser(){
        List<User> users = userService.getAllUsers();
        List<UserDto> userDtos = new ArrayList<UserDto>(users.size());
        for (User user:users){
            userDtos.add(mapStructMapper.userToUserDto(user));
        }
        return userDtos;
    }

    @GetMapping("/User/{UserID}")
    @Validated
    public ResponseEntity<UserDto> getUserID(@PathVariable("UserID") Integer userid){
        return userService.getUserID(userid)
                .map(mapStructMapper::userToUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/NewUser")
    public String newUser(@Validated(New.class) @RequestBody UserDto userDto){
        User user = mapStructMapper.userDtoToUser(userDto, User.getInstance());
        userService.saveNewUser(user);
        emailService.sendEmail(user.getEmail(), "New User", "Save to Users");
        return "Save to Users";
    }

    @PutMapping("/User/{UserID}")
    @IdParametersEqual
    public ResponseEntity<UserDto> editUser(@PathVariable("UserID") Integer userid, @Validated(Existing.class) @RequestBody UserDto userDto ){
        return userService.getUserID(userid)
                .map(user -> mapStructMapper.userDtoToUser(userDto,user))
                .map(userService::editUser)
                .map(mapStructMapper::userToUserDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
