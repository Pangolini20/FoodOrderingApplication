package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.db.entities.User;
import com.example.foodorderingapplication.dto.RegisterDetails;
import com.example.foodorderingapplication.dto.UserProfile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserController {

    @Operation(description = "Gets all the user profiles from the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of users",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UserProfile.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No user profile found in the database",content = @Content)
            }
    )
    List<UserProfile> getAllUsers();

    @Operation(description = "gets a user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Found the user succesfully",
                    content ={@Content(mediaType = "application/json",schema = @Schema(implementation = UserProfile.class)) }),
            @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
            @ApiResponse(responseCode = "404",description = "User not found",content = @Content)
    })
    Optional<UserProfile> getUser(Long id);

    @Operation(description = "creates a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "User created succesfully",content =
                    {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400" ,description = "Invalid request",content = @Content),
            @ApiResponse(responseCode = "404",description = "Could not create the user",content = @Content)
    })
    ResponseEntity<User> createUser(RegisterDetails registerDetails);

    @Operation(description = "edits users profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "User profile edited succesfully ",content ={
                    @Content(mediaType = "application/json",schema = @Schema(implementation = UserProfile.class))
            }),
            @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
            @ApiResponse(responseCode = "404", description = "Could not edit user",content = @Content)
    })
    ResponseEntity<UserProfile> editUser(UserProfile userProfile);

}
