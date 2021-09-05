/**
 * 
 */
package vn.tcx.zk.vm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import vn.tcx.zk.config.Action;
import vn.tcx.zk.config.Resource;
import vn.tcx.zk.module.log.Log;

/**
 * @author caltalys
 *
 */
@VariableResolver(DelegatingVariableResolver.class)
public class MainViewModel {

    @WireVariable Resource resource;
    @WireVariable Action action;
    
    Map<String, PageModel<?>> pages = new HashMap<>();
    private PageModel<?> currentPage;

    @Init
    public void init() {
        pages.put(resource.getLog().getName(), new LogPageModel(resource.getLog().getName(), Log.class));
    }

    @Command
    @NotifyChange("currentTime")
    public void updateTime() {
        // NOOP just for the notify change
    }

    public Date getCurrentTime() {
        return new Date();
    }

    @Command
    @NotifyChange("currentPage")
    public void navigate(@BindingParam("page") String page) {
        this.currentPage = pages.get(page);
    }

    public PageModel<?> getCurrentPage() {
        return currentPage;
    }

}
