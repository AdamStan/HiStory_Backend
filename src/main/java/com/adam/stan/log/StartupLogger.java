package com.adam.stan.log;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StartupLogger  {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupLogger.class);
    private final String apiHostPropertyName = "history.py.apihost";

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        final Environment env = event.getApplicationContext().getEnvironment();
        LOGGER.info("====== Environment and configuration ======");
        LOGGER.info("Active profiles: {}", Arrays.toString(env.getActiveProfiles()));
        LOGGER.info("{}: {}", apiHostPropertyName, env.getProperty(apiHostPropertyName));
        LOGGER.info("===========================================");
    }
}