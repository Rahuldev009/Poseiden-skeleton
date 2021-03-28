package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurvePointServiceImpl implements CurvePointService {

    private CurvePointRepository curvePointRepository;

    @Autowired
    public CurvePointServiceImpl(CurvePointRepository curvePointRepository) {
        this.curvePointRepository = curvePointRepository;
    }

    @Override
    public CurvePoint getCurvePointById(int id) {
        return curvePointRepository.getOne(id);
    }

    @Override
    public List<CurvePoint> getAllCurvePoint() {
        return curvePointRepository.findAll();
    }

    @Override
    public void saveCurvePoint(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    @Override
    public void updateCurvePoint(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    @Override
    public void deleteCurvePoint(int id) {
        curvePointRepository.deleteById(id);
    }

}
