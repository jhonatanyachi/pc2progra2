package com.pc2.quintacat.repository;

import com.pc2.quintacat.model.Asalariado;
import org.springframework.data.repository.Repository;
import java.lang.Integer;
import java.util.List;

/**
 * Created by vfconsulting1 on 27/04/2018.
 */
public interface asalariadoRepository
extends Repository<Asalariado,Integer> {
    void save(Asalariado asalariado);
    List<Asalariado> findAll();
}
