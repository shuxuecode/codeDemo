import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @date 2022/7/4
 */
public class JWTTest {


    @Test
    void t1() {

        String secret = "testSecret";

        String token = JWT.create()
                .withHeader(new HashMap<>())
                .withClaim("key", "value")
                .withExpiresAt(new Date())
                .withIssuedAt(Calendar.getInstance().getTime())
                .sign(Algorithm.HMAC256(secret));

        System.out.println(token);

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();

        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (TokenExpiredException e) {
            //e.printStackTrace();
        }

        Date expiresAt = decodedJWT.getExpiresAt();

        System.out.println(expiresAt);

    }


}
