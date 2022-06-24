package Runner;

import Repo.FibonacciRepository;
import config.FibConfiguration;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.FibonacciResource;

public class FibApplication extends Application<FibConfiguration> {
    public static void main(String[] args) throws Exception {
        new FibApplication().run("server", "config.yml");
    }

    @Override
    public void run(FibConfiguration fibConfiguration, Environment environment) {
        String welcomeMsg = fibConfiguration.getwelcomeMsg();
        FibonacciRepository fibonacciRepository = new FibonacciRepository();
        FibonacciResource fibonacciResource = new FibonacciResource(welcomeMsg, fibonacciRepository);
        environment.jersey().register(fibonacciResource);
    }
    @Override
    public void initialize(Bootstrap<FibConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }
}
