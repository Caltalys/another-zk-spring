package vn.tcx.zk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Getter;

@Getter
@Controller
public class Entry {

    @Autowired private Action action;
    @Autowired private Resource resource;
    
    private String[] actions;
    private String[] resources;
    
    
    public String[] getActions() {
        if(actions==null) {
            actions = new String[] { 
                    action.getList().getName(),
                    action.getView().getName(),
                    action.getAdd().getName(),
                    action.getEdit().getName(),
                    action.getDelete().getName()
                };
        }
        return actions;
    }

    public String[] getResources() {
        if(resources==null) {
            resources = new String[] { 
                    resource.getLog().getName(), 
                    resource.getNguoiDung().getName(), 
                    resource.getVaitro().getName() 
                };
        }
        return resources;
    }
    
    @RequestMapping(value = "/cp")
    public String cp() {
        return "forward:/WEB-INF/cp/home.zul"
                + "?resource=" + resource.getLog().getName()
                + "&action=" + action.getList().getName()
                + "&file=/WEB-INF/cp/" + resource.getLog().getName() + "/list.zul";
    }

    @RequestMapping(value = "/cp/{path:.+$}")
    public String cpWithPath(@PathVariable String path) {
        return "forward:/WEB-INF/cp/home.zul"
                + "?resource=" + path
                + "&action=" + action.getList().getName()
                + "&file=/WEB-INF/cp/" + path + "/list.zul";
    }
    
}
