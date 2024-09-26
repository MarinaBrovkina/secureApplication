package org.example.configuration;

import org.example.profile.DevProfile;
import org.example.profile.ProductionProfile;
import org.example.profile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfiguration {

    @ConditionalOnProperty(name = "netology.profile.dev", havingValue = "true")
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(name = "netology.profile.prod", havingValue = "true")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }

    @Bean
    @ConditionalOnMissingBean(SystemProfile.class)
    public SystemProfile defaultProfile() {
        return new DevProfile();
    }
}

