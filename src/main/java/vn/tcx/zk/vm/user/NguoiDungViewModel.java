/**
 * 
 */
package vn.tcx.zk.vm.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import vn.tcx.zk.module.user.NguoiDung;
import vn.tcx.zk.module.user.NguoiDungService;
import vn.tcx.zk.vm.AbstractViewModel;

/**
 * @author caltalys
 *
 */
@VariableResolver(DelegatingVariableResolver.class)
public class NguoiDungViewModel extends AbstractViewModel {

    @WireVariable
    NguoiDungService nguoiDungService;

    @Init
    public void init() {
        pageTitle = resource.getNguoiDung().getDescription();
    }

    /**
     * @return the nguoiDungService
     */
    public NguoiDungService getNguoiDungService() {
        return nguoiDungService;
    }
    
    public List<NguoiDung> getDanhSach() {
        NguoiDung entry = new NguoiDung();
        entry.setHoVaTen("Đinh Trân");
        return Arrays.asList(entry);
    }
}