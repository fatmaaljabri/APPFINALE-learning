
package com.APPJAVAFSTELEARNIN.repository;

import com.APPJAVAFSTELEARNIN.entity.Module;
import com.APPJAVAFSTELEARNIN.entity.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findByCours(Cours cours);

    List<Module> findByCoursOrderByOrdreAsc(Cours cours);
}
