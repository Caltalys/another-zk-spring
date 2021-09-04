/**
 * 
 */
package vn.tcx.zk.module.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/**
 * @author caltalys
 *
 */
@Service
@AllArgsConstructor
public class VaiTroServiceImpl implements VaiTroService {

    private final VaiTroRepository vaiTroRepository;

    @Override
    public void add(VaiTro vaiTro) {
        vaiTroRepository.save(vaiTro);
    }

    @Override
    public void update(VaiTro vaiTro) {
        vaiTroRepository.save(vaiTro);
    }

    @Override
    public void delete(Long id) {
        vaiTroRepository.deleteById(id);
    }

    @Override
    public Optional<VaiTro> getById(Long id) {
        return vaiTroRepository.findById(id);
    }

    @Override
    public Page<VaiTro> getPaging(Pageable pageable) {
        return vaiTroRepository.findAll(pageable);
    }

}
