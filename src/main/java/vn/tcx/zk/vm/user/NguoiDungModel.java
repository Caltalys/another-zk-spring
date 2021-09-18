/**
 * 
 */
package vn.tcx.zk.vm.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.Window;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import vn.tcx.zk.vm.AbstractViewModel;

/**
 * @author caltalys
 *
 */
@Slf4j
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class NguoiDungModel extends AbstractViewModel {
    
    private Long id;
    
    @NotBlank @Size(max=64)
    private String hoVaTen;
    
    @NotBlank @Size(max=255)
    private String email;
    
    @NotBlank @Size(max=64)
    private String matKhau;
    
    @NotBlank @Size(max=64)
    private String matKhauConfirm;
    
    private boolean active;
    
    @Command
    public void saveNguoiDung(@BindingParam("notifyModel") NguoiDungViewModel notifyModel, @BindingParam("attr") String attr, @BindingParam("wdn") Window wdn) {
        log.info("notifyModel : {}", notifyModel);
        log.info("attr : {}", attr);
        log.info("wdn : {}", wdn);
        notifyModel.getDanhSach().add(this);
        
        closeWindowCmd(notifyModel, attr, wdn);
    }
}
