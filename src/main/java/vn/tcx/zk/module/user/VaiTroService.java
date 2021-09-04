/**
 * 
 */
package vn.tcx.zk.module.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author caltalys
 *
 */
public interface VaiTroService {

    void add(VaiTro vaiTro);
    
    void update(VaiTro vaiTro);
    
    void delete(final Long id);
    
    Optional<VaiTro> getById(final Long id);
    
    Page<VaiTro> getPaging(Pageable pageable);
}
