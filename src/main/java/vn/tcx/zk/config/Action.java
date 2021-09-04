package vn.tcx.zk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Configuration
@ConfigurationProperties(prefix = "app.action", ignoreUnknownFields = true)
public class Action {

    private final List list = new List();
    private final View view = new View();
    private final Add add = new Add();
    private final Edit edit = new Edit();
    private final Delete delete = new Delete();
    
    @Getter
    @Setter
    public static class List {
        private String name;
        private String description;
    }
    
    @Getter
    @Setter
    public static class View {
        private String name;
        private String description;
    }
    
    @Getter
    @Setter
    public static class Add {
        private String name;
        private String description;
    }
    
    @Getter
    @Setter
    public static class Edit {
        private String name;
        private String description;
    }
    
    @Getter
    @Setter
    public static class Delete {
        private String name;
        private String descripion;
    }
    
}
