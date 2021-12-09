package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.RestaurantDTO;
import com.example.foodorderingapplication.dto.UserProfile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RestaurantController {

    @Operation(description = "Gets all the restaurants from the database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of restaurants",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurants found",content = @Content)
            }
    )
    List<RestaurantDTO> getRestaurants();

    @Operation(description = "creates a restaurant")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",description = "restaurant created succesfully",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "Couldnt create restaurant",content = @Content)
            }
    )
    ResponseEntity<RestaurantDTO> createRestaurant(RestaurantDTO restaurantDTO);

    @Operation(description = "Gets all the restaurants from a specific owner")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of restaurants",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurants found",content = @Content)
            }
    )
    List<RestaurantDTO> getRestaurantByOwner(Long id);

    @Operation(description = "Edits restaurant details")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Edit succesfull",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurant found",content = @Content),
                    @ApiResponse(responseCode = "409",description = "Same restaurant name",content = @Content)
            }
    )
    ResponseEntity<RestaurantDTO> editRestaurant(RestaurantDTO restaurantDTO);

    @Operation(description = "Delete a restaurant from database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "deletes the restaurant",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurant found to delete",content = @Content)
            }
    )
    void deleteRestaurant(Long id);
}
