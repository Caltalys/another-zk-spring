/**
 * 
 */
package vn.tcx.zk.vm;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import lombok.extern.slf4j.Slf4j;
import vn.tcx.zk.config.Action;
import vn.tcx.zk.config.Resource;

/**
 * @author caltalys
 *
 */
@Slf4j
@VariableResolver(DelegatingVariableResolver.class)
public class MainViewModel {

    @WireVariable(value = "resource") Resource resources;
    @WireVariable(value = "action") Action actions;
    
    Map<String, PageModel<?>> pages = new HashMap<>();
    private PageModel<?> defaultPage;
    private PageModel<?> currentPage;

//    @Init
    public void init() {
//        log.debug("resources {}", resources);
//        log.debug("actions {}", actions);
//        Using as SPA in wiich browser url not change
//        defaultPage = new LogPageModel("log/list.zul", "log", "list", Log.class);
//        if(currentPage==null)
//            currentPage = defaultPage;
//        pages.put("log", new LogPageModel("log/list.zul", "log", "list", Log.class));
    }
    
    

    @Command
    @NotifyChange("currentPage")
    public void navigate(@BindingParam("page") String page) {
        this.currentPage = pages.get(page);
    }

    /**
     * @return the defaultPage
     */
    public PageModel<?> getDefaultPage() {
        return defaultPage;
    }
    
    /**
     * @return the currentPage
     */
    public PageModel<?> getCurrentPage() {
        return currentPage;
    }
}
