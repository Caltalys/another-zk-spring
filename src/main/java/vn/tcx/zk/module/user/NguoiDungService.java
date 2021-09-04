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
public interface NguoiDungService {

    void add(NguoiDung nguoiDung);
    
    void update(NguoiDung nguoiDung);
    
    void delete(final Long id);
    
    Optional<NguoiDung> getById(final Long id);
    
    Page<NguoiDung> getPaging(Pageable pageable);
}
