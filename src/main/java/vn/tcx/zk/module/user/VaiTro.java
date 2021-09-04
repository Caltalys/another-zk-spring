/**
 * 
 */
package vn.tcx.zk.module.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
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
@Table(name="vai_tro")
@Data
@ToString
@EqualsAndHashCode(callSuper=true)  
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class VaiTro extends BaseEntity<VaiTro>{
    
    @NotBlank
    @Size(max=255)
    private String ten = "";
    
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "vaitro_quyen", joinColumns = { @JoinColumn(name = "vai_tro_id") })
    private Set<String> quyens = new HashSet<>();
}