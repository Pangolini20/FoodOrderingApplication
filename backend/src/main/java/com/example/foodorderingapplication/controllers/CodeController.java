package com.example.foodorderingapplication.controllers;

import com.example.foodorderingapplication.dto.CodeDetails;
import com.example.foodorderingapplication.dto.CodeDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CodeController {


    @Operation(description = "creates a discount code")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",description = "discount code created succesfully",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = CodeDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "restaurant not found",content = @Content),
                    @ApiResponse(responseCode = "409",description = "Name conflict",content = @Content)
            }
    )
    ResponseEntity<CodeDto> createCode(Long id,CodeDetails codeDetails);


    @Operation(description = "edits a discount code")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "discount code edited succesfully",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = CodeDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "Couldnt find code",content = @Content),
                    @ApiResponse(responseCode = "409",description = "Name conflict",content = @Content)
            }
    )
    ResponseEntity<CodeDto> editCode(Long id,CodeDetails codeDetails);

    @Operation(description = "Deletes a discount code")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "deletes code",
                            content = {@Content(mediaType = "application/json",schema = @Schema)}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No code found to delete",content = @Content)
            }
    )
    void deleteCode(Long id);

    @Operation(description = "Gets all the discount codes from a specific restaurant")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",description = "Gets a list of discount codes",
                            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = CodeDto.class))}),
                    @ApiResponse(responseCode = "400",description = "Invalid request",content = @Content),
                    @ApiResponse(responseCode = "404",description = "No codes found",content = @Content)
            }
    )
    List<CodeDto> getCodesFromRestaurant(Long id);


}
