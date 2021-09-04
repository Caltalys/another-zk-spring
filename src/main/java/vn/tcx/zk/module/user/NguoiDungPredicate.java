/**
 * 
 */
package vn.tcx.zk.module.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * @author caltalys
 *
 */
public class NguoiDungPredicate {

    private static final Logger log = LoggerFactory.getLogger(NguoiDungPredicate.class);
    private static final QNguoiDung QCLASS = QNguoiDung.nguoiDung;
    private BooleanExpression base = QCLASS.deleted.isFalse();
    
    // Should use SearchDto for method signature
    private Predicate searchByHoVaTen(NguoiDung search) {
        BooleanExpression predicate = base;
        if (search != null && search.getHoVaTen() != null && StringUtils.isNoneBlank(search.getHoVaTen().trim())) {
            predicate = predicate.and(QCLASS.hoVaTen.contains(search.getHoVaTen()));
        }
        return predicate;
    }
    
}

