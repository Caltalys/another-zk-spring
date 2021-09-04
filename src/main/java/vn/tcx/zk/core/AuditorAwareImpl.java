/**
 * 
 */
package vn.tcx.zk.core;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

/**
 * @author caltalys
 *
 */
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("system");
        //return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
    }

}
