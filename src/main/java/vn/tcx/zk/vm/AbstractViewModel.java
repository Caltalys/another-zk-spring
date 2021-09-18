/**
 * 
 */
package vn.tcx.zk.vm;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Window;

import vn.tcx.zk.config.Action;
import vn.tcx.zk.config.Resource;
import vn.tcx.zk.vm.user.NguoiDungModel;

/**
 * @author caltalys
 *
 */
@VariableResolver(DelegatingVariableResolver.class)
public abstract class AbstractViewModel implements ViewModel {

    @WireVariable protected Action action;
    @WireVariable protected Resource resource;
    
    protected String pageTitle;
    protected ViewModel parent;
    
    @Override
    public String getPageTitle() {
        return pageTitle;
    }
    
    @Override
    public ViewModel getParent() {
        return parent;
    }
    
    public NguoiDungModel getCurrentUser() {
        return new NguoiDungModel();
    }
    
    @Command
    public void redirectPageCmd(@BindingParam("zul") String zul, @BindingParam("vmArgs") Object vmArgs, @BindingParam("vm") Object vm) {
        Map<String, Object> args = new HashMap<>();
        args.put("vmArgs", vmArgs);
        args.put("vm", vm);
        Executions.createComponents(zul, null, args);
    }
    
    @Command
    public void redirectPageWithTypeCmd(@BindingParam("zul") String zul, @BindingParam("vmArgs") Object vmArgs, 
            @BindingParam("type") String type) throws InstantiationException, IllegalAccessException, IllegalArgumentException, 
            InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        Map<String, Object> args = new HashMap<>();
        args.put("vmArgs", vmArgs);
        if(type!=null) {
            args.put("vm", Class.forName(type).getConstructor().newInstance());
        }
        Executions.createComponents(zul, null, args);
    }
    
    @Command
    public void closeWindowCmd(@BindingParam("notifyModel") Object notifyModel, @BindingParam("attr") String attrs,
            @BindingParam("detach") final Window wdn) {
        for (final String field : attrs.split("\\|")) {
            if (!field.isEmpty()) {
                BindUtils.postNotifyChange(null, null, notifyModel, field);
            }
        }
        if (wdn != null) {
            wdn.detach();
        }
    }
}
