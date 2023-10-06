package com.hmp.reactive.controller;

import com.hmp.reactive.model.documents.User;
import com.hmp.reactive.model.response.UserResponse;
import com.hmp.reactive.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("v1/user")
@Log4j2
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status 200 OK"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status 400 Bad Request",
                    useReturnTypeSchema = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResponse.class))
                    }

            )})
    @PostMapping
    public Mono<ResponseEntity<UserResponse<User>>> createUser(@RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "user information object",
            required = true
    ) User user) {
        return userService.saveUser(user)
                .flatMap(savedUser -> {
                    if (savedUser != null) {
                        UserResponse<User> userResponse = UserResponse.<User>builder()
                                .msg("User created successfully")
                                .statusCode(HttpStatus.CREATED.name())
                                .result(savedUser)
                                .build();
                        return Mono.just(ResponseEntity.ok().body(userResponse));
                    } else {
                        UserResponse<User> userResponse = UserResponse.<User>builder()
                                .msg("User is null")
                                .statusCode(HttpStatus.BAD_REQUEST.name())
                                .build();
                        return Mono.just(ResponseEntity.badRequest().body(userResponse));
                    }
                });
    }
    @Operation(
            summary = "Find User REST API",
            description = "Find User REST API is used to find user in a database"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status 200 CREATED"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status 400 Bad Request",
                    useReturnTypeSchema = true,
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = UserResponse.class))
                    }

            )})
    @GetMapping(value = "/{userId}")
    public Mono<ResponseEntity<UserResponse<User>>> findUserByUserId(@PathVariable(value = "userId") String userId) {
        return userService.findUserByUserId(userId).switchIfEmpty(Mono.empty()
        ).flatMap(dbUser -> {
            log.info("Response from database: {}", dbUser);
            UserResponse<User> userResponse = UserResponse.<User>builder()
                    .msg("User successfully fetched: " + userId)
                    .statusCode(HttpStatus.OK.name())
                    .result(dbUser)
                    .build();
            return Mono.just(ResponseEntity.ok().body(userResponse));
        }).switchIfEmpty(Mono.just(ResponseEntity.badRequest().body(UserResponse.<User>builder()
                .msg("Couldn't find user with: " + userId)
                .statusCode(HttpStatus.BAD_REQUEST.name())
                .build()
        )));
    }
}