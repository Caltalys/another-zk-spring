/**
 * 
 */
package vn.tcx.zk.module.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author caltalys
 *
 */
@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Long>{

}
