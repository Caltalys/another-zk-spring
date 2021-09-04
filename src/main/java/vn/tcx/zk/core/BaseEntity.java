/**
 * 
 */
package vn.tcx.zk.core;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author caltalys
 *
 */
@Data
@ToString
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public class BaseEntity<T extends BaseEntity<T>> extends Auditable<String> implements Persistable<Long>{

    @Id
    @GeneratedValue
    private Long id;
    
    private boolean deleted;

    @Override
    public boolean isNew() {
        return id == null || id == 0;
    }
    
}