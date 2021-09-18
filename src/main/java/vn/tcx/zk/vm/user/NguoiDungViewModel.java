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

    List<NguoiDungModel> danhSach = new ArrayList<>();
    
    @Init
    public void init() {
        pageTitle = resource.getNguoiDung().getDescription();
        NguoiDungModel entry = new NguoiDungModel();
        entry.setHoVaTen("Đinh Trân");
        danhSach.add(entry);
    }

    /**
     * @return the nguoiDungService
     */
    public NguoiDungService getNguoiDungService() {
        return nguoiDungService;
    }
    
    public List<NguoiDungModel> getDanhSach() {
        return danhSach;
    }
}