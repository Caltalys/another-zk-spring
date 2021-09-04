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
public class NguoiDungServiceImpl implements NguoiDungService {

    private final NguoiDungRepository nguoiDungRepository;

    @Override
    public void add(NguoiDung nguoiDung) {
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void update(NguoiDung nguoiDung) {
        nguoiDungRepository.save(nguoiDung);
    }

    @Override
    public void delete(Long id) {
        nguoiDungRepository.deleteById(id);
    }

    @Override
    public Optional<NguoiDung> getById(Long id) {
        return nguoiDungRepository.findById(id);
    }

    @Override
    public Page<NguoiDung> getPaging(Pageable pageable) {
        return nguoiDungRepository.findAll(pageable);
    }

}
