package com.api.notes.utils.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.notes.models.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Tag(name = "User", description = "The User API")
@RequestMapping("/api/v1/users")
public interface ApiUser {

    @Operation(summary = "Find user by ID", description = "Returns a single user", tags = { "user" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = 
                @Content(schema = @Schema(implementation = User.class))),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
    @RequestMapping(value = "/{id}", produces = { "application/json",
            "application/vnd.api+json" }, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> findById(
            @Parameter(description = "ID of user", required = true) @PathVariable long id,
            @NotNull @Parameter(description = "select which kind of data to fetch", required = true) 
            @Valid @RequestHeader(value = "userAuthorization", required = true) String userAuthorization)
            throws Exception;

    @Operation(summary = "Get users", description = "Returns a users collection", tags = { "user" })
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<User> findUsers();

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable("id") final String id, @RequestBody final User user);

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User patchUser(@PathVariable("id") final String id, @RequestBody final User user);

    @Operation(summary = "Create user", description = "This can only be done by the logged in user.", tags = { "user" })
    @ApiResponses(value = { @ApiResponse(description = "successful operation", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)),
            @Content(mediaType = "application/xml", schema = @Schema(implementation = User.class)) }) })
    @PostMapping(value = "/", consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> postUser(
            @NotNull @Parameter(description = "Created user object", required = true) @Valid @RequestBody User body,
            @NotNull @Parameter(description = "select which kind of data to fetch", required = true) 
            @Valid @RequestHeader(value = "userAuthorization", required = true) String userAuthorization)
            throws Exception;

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public User headUser();

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteUser(@PathVariable final long id);
}
