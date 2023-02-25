package br.com.jccf.room.web.app.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "special")
public class SpecialEndpoint {

    @ReadOperation
    public String special() {
        return "Special endpoint";
    }
}
