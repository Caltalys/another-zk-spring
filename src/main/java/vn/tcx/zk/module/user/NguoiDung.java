/**
 * 
 */
package vn.tcx.zk.module.user;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import vn.tcx.zk.core.BaseEntity;

/**
 * @author caltalys
 *
 */
@Entity
@Table(name="nguoi_dung")
@Data
@ToString
@EqualsAndHashCode(callSuper=true)  
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class NguoiDung extends BaseEntity<NguoiDung>{
    
    @NotBlank @Size(max=64)
    private String hoVaTen;
    
    @NotBlank @Size(max=255)
    private String email;
    
    @NotBlank @Size(max=64)
    private String matKhau;
    
    @Size(max=64)
    private String salkey;
    
    private boolean active;
    
    @ManyToMany//(fetch=FetchType.EAGER)
    @JoinTable(name = "nguoidung_vaitro", joinColumns = @JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "vai_tro_id", referencedColumnName = "id"))
    private Set<VaiTro> vaiTros;
    
    
}
