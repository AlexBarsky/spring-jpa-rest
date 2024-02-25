package ru.barsky.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

@Configuration
@EnableJpaAuditing
class AuditConfig {

    @Bean
    fun auditProvider(): AuditorAware<String> {
        /*
            Custom logic here
        */

        return AuditorAware { Optional.of("system") }
    }
}