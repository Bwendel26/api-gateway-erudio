package com.spring.erudio.api_gateway.controllers;

import com.spring.erudio.api_gateway.data.vo.v1.PersonVO;
import com.spring.erudio.api_gateway.services.PersonService;
import com.spring.erudio.api_gateway.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Endpoints to manage person registry")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "List all people",
                description = "Returns a list with all people registered",
                tags = {"Person"},
                responses = {@ApiResponse(
                                description = "Success",
                                responseCode = "200",
                                content = @Content(mediaType = "application/json",
                                        array = @ArraySchema(
                                                schema = @Schema(implementation = PersonVO.class
                                                    )))),
                            @ApiResponse(
                                    description = "Bad Request",
                                    responseCode = "400",
                                    content = @Content(mediaType = "application/json",
                                            array = @ArraySchema(
                                                schema = @Schema(implementation = PersonVO.class
                                                                        )))),
                            @ApiResponse(description = "Internal Error",
                                        responseCode = "500",
                                        content = @Content(mediaType = "application/json",
                                        array = @ArraySchema(
                                                schema = @Schema(implementation = PersonVO.class)
                                        )))
        }
    )
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}",
                produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "List a people by id",
                description = "Returns a person registered by his id.",
                tags = {"Person"},
                responses = {@ApiResponse(
                                description = "Success",
                                responseCode = "200",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))),
                            @ApiResponse(
                                description = "Not Found",
                                responseCode = "404",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))
                            )}
)
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Create a person",
                description = "Create a new person register.",
                tags = {"Person"},
                responses = {@ApiResponse(
                                description = "Success",
                                responseCode = "200",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))),
                            @ApiResponse(
                                description = "Unauthorized",
                                responseCode = "401",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))
                            )}
            )
    public PersonVO create(@RequestBody PersonVO person) {
        return service.create(person);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
                produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
    @Operation(summary = "Update a person",
                description = "Update a person register.",
                tags = {"Person"},
                responses = {@ApiResponse(
                                description = "Success",
                                responseCode = "200",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))),
                            @ApiResponse(
                                description = "Unauthorized",
                                responseCode = "401",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))
                            )}
)
    public PersonVO update(@RequestBody PersonVO person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete a person by id",
                description = "Delete a person register.",
                tags = {"Person"},
                responses = {@ApiResponse(
                                description = "Success",
                                responseCode = "200",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))),
                            @ApiResponse(
                                description = "No Content",
                                responseCode = "204",
                                content = @Content(schema = @Schema(implementation = PersonVO.class))
                    )})
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}
