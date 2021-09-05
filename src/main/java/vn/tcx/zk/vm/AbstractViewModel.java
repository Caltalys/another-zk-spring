/**
 * 
 */
package vn.tcx.zk.vm;

import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

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
}
