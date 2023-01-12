package br.com.jccf.room.web.app;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.*;

import java.lang.annotation.*;

@Component
public class LondonEndpoint implements Endpoint {

    @Override
    public String id() {
        return "london";
    }

    @Override
    public boolean enableByDefault() {
        return true;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
