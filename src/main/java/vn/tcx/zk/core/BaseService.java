/**
 * 
 */
package vn.tcx.zk.core;

import javax.annotation.Nullable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

/**
 * @author caltalys
 *
 */
public interface BaseService<T extends BaseEntity<T>> {
    
    Page<T> findAll(@Nullable Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders);
    
    Iterable<T> findAll(@Nullable Predicate predicate, OrderSpecifier<?>... orders);
    
}
