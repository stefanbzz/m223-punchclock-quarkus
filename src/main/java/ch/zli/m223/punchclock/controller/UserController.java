package ch.zli.m223.punchclock.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.AuthenticationService;
import ch.zli.m223.punchclock.service.UserService;
import io.quarkus.security.UnauthorizedException;

@Path("/users")
@Tag(name = "User", description = "Handling of users")
public class UserController {

    @Inject
    UserService userService;

    @Inject
    AuthenticationService authorizationService;

    
    /** 
     * @param user
     */
    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "A new user gets created", description = "")
    public void create(@RequestBody User user) {
      userService.createUser(user);
    }

    
    /** 
     * @param user
     * @return String
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Login", description = "")
    public String authorize(User user) {
        var newUser = userService.findUser(user.getUsername());
        if(newUser.isPresent()) {
            String password = newUser.get().getPassword();
            String checkPasword = user.getPassword();
            if(password.equals(checkPasword)) {
                return authorizationService.generateValidJwtToken(user);
            }}
        throw new UnauthorizedException("Username or password invalid");
    }
}