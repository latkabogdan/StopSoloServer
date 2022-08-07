package com.bogdan.joinme.authorization.boundary;

import com.google.firebase.FirebaseException;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@ApplicationScoped
public class FirebaseExceptionMapper implements ExceptionMapper<FirebaseException> {

    @Override
    public Response toResponse(FirebaseException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Authorization failed")
                .build();
    }
}
