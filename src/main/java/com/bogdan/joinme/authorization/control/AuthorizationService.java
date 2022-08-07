package com.bogdan.joinme.authorization.control;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;

@Dependent
@Slf4j
public class AuthorizationService {

    private final FirebaseAuth firebaseAuth = AuthorizationConfigProvider.init();

    public FirebaseToken saveUser(String idToken) throws FirebaseAuthException {
        try {
            FirebaseToken firebaseToken = firebaseAuth.verifyIdToken(idToken);

            return firebaseToken;
        } catch (FirebaseAuthException e) {
            log.info("Token " + idToken + " can't be authorized");
            throw e;
        }
    }
}
