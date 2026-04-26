
package com.APPJAVAFSTELEARNIN.repository;

import com.APPJAVAFSTELEARNIN.entity.Lecon;
import com.APPJAVAFSTELEARNIN.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeconRepository extends JpaRepository<Lecon, Long> {

    List<Lecon> findByModule(Module module);

    long countByModule(Module module);
}