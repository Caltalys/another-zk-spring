/**
 * 
 */
package vn.tcx.zk.core;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nullable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;

/**
 * @author caltalys
 *
 */
@Service
@Transactional
public class BaseServiceImpl<T extends BaseEntity<T>, ID> implements BaseService<T> {

    BaseRepository<T, Long> repository;
    
    @Override
    public Page<T> findAll(@Nullable Predicate predicate, Pageable pageable, OrderSpecifier<?>... orders) {
        if (predicate == null) {
            predicate = QBaseEntity.baseEntity.deleted.isFalse();
        }

        if (orders == null || orders.length == 0) {
            return new PageImpl<>(Collections.emptyList());
//            return repository.findPage(predicate, pageable, new OrderSpecifier<>(Order.DESC,
//                    Expressions.dateTimePath(LocalDateTime.class, repository.getPath(), "ngaySua")));
        }
        return new PageImpl<>(Collections.emptyList());
//        return repository.findPage(predicate, pageable, orders);
    }

    @Override
    public Iterable<T> findAll(@Nullable Predicate predicate, OrderSpecifier<?>... orders) {
        if (predicate == null) {
            predicate = QBaseEntity.baseEntity.deleted.isFalse();
        }

        if (orders == null || orders.length == 0) {
            return repository.findAll(predicate, new OrderSpecifier<>(Order.DESC,
                    Expressions.dateTimePath(LocalDateTime.class, repository.getPath(), "ngaySua")));
        }
        
        return repository.findAll(predicate, orders);
    }


}