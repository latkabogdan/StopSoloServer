package com.bogdan.joinme.authorization.boundary;

import com.bogdan.joinme.authorization.control.AuthorizationService;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.internal.GetAccountInfoResponse;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

@ApplicationScoped
@Path("auth")
@RequiredArgsConstructor
public class AuthorizationResource {

    private final AuthorizationService authorizationService;

    @POST
    @Path("/create/{idToken}")
    public void verify(@PathParam("idToken") String idToken) throws FirebaseAuthException {
        authorizationService.saveUser(idToken);
    }

}
