/**
 * 
 */
package vn.tcx.zk.core;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.OrderSpecifier;


/**
* Super repository for all resource. 
* 
* @author caltalys
*
* @param <T>
* @param <ID>
*/
@NoRepositoryBean
@Transactional(readOnly=true)
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T>{

   EntityPath<T> getPath();
   
   Page<T> findPage(@Param("predicate") Predicate<T> predicate, Pageable pageable, OrderSpecifier<?>... orders);
   
   List<T> findAll(@Param("predicate") Predicate<T> predicate, Pageable pageable, OrderSpecifier<?>... orders);
   
   T findById(@Param("id") Long id);
}
