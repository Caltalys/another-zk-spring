package vn.tcx.zk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Configuration
@ConfigurationProperties(prefix = "app.resource", ignoreUnknownFields = true)
public class Resource {

    private final Log log = new Log();
    private final NguoiDung nguoiDung = new NguoiDung();
    private final VaiTro vaitro = new VaiTro();
    
    @Getter
    @Setter
    public static class Log {
        private String name;
        private String description;
        private String[] permission;
    }
    
    @Getter
    @Setter
    public static class NguoiDung {
        private String name;
        private String description;
        private String[] permission;
    }
    
    @Getter
    @Setter
    public static class VaiTro {
        private String name;
        private String description;
        private String[] permission;
    }
}
