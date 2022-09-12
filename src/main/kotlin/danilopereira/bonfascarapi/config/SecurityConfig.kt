package danilopereira.bonfascarapi.config

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class SecurityConfig {

    @Bean
    fun bCryptPasswordEncoder() : BCryptPasswordEncoder{
        return BCryptPasswordEncoder()
    }
}