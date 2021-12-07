package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.db.entities.Category;
import com.example.foodorderingapplication.dto.FoodDetails;
import com.example.foodorderingapplication.dto.FoodDto;
import com.example.foodorderingapplication.dto.RestaurantDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FoodController {
    @Operation(description = "Gets all the food from a specific restaurant")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of food",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = FoodDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No food found",content = @Content)
            }
    )
    List<FoodDto> getFoodByRestaurant(Long id);

    @Operation(description = "creates food")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",description = "food created succesfully",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "Couldnt create food",content = @Content),
                    @ApiResponse(responseCode = "409",description = "Name conflict",content = @Content)
            }
    )
    ResponseEntity<FoodDto> createFood(Long id,FoodDetails foodDetails);

    @Operation(description = "Edits food details")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Edit succesfull",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = FoodDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurant found",content = @Content),
                    @ApiResponse(responseCode = "409",description = "Same food name at same restaurant",content = @Content)
            }
    )
    ResponseEntity<FoodDto> editFood(Long id,FoodDetails foodDetails);

    @Operation(description = "Delete a food from database")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "deletes the food",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = RestaurantDTO.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No restaurant found to delete",content = @Content)
            }
    )
    void deleteFood(Long id);

    @Operation(description = "Gets all the food from a specific category")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of food",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = FoodDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No food found",content = @Content)
            }
    )
    List<FoodDto> getByCategory(Category category);
}
