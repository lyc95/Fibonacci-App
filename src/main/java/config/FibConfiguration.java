package config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class FibConfiguration extends Configuration {
    @NotNull
    private final String welcomeMsg;
    @JsonCreator
    public FibConfiguration(@JsonProperty("welcomeMsg") String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public String getwelcomeMsg() {
        return welcomeMsg;
    }
}
