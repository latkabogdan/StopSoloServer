package com.bogdan.joinme.authorization.control;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import io.quarkus.runtime.Startup;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

@ApplicationScoped
public class AuthorizationConfigProvider {

    public static FirebaseAuth init() {
/*        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream())
                .build();*/
        FirebaseOptions options = FirebaseOptions.builder().build();

        FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
        return FirebaseAuth.getInstance(firebaseApp);
    }
}
