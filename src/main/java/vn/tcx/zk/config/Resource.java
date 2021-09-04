package vn.tcx.zk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Configuration
@ConfigurationProperties(prefix = "app.resource", ignoreUnknownFields = true)
public final class Resource {

    private final Log log = new Log();
    
    @Getter
    @Setter
    public static class Log {
        private String name;
        private String descripion;
        private String[] permission;
    }
    
}
