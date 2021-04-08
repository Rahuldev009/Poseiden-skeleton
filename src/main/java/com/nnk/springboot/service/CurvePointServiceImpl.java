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

    /**
     * find the curvepoint item by Id
     * @param id this is the id of curvepoint item to be searched
     * @return curvepoint object with the same Id
     */
    @Override
    public CurvePoint getCurvePointById(int id) {
        return curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid curvePoint Id:" + id));
    }

    /**
     * find all items of curvepoint
     * @return list of all curvepoint items
     */
    @Override
    public List<CurvePoint> getAllCurvePoint() {
        return curvePointRepository.findAll();
    }

    /**
     * save the curvepoint item in the DB
     * @param curvePoint this is the item to be saved in the DB
     */
    @Override
    public void saveCurvePoint(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    /**
     * update the curvepoint item in the DB
     * @param curvePoint this is the item to be updated in the DB
     */
    @Override
    public void updateCurvePoint(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    /**
     * delete the curvepoint item in the DB
     * @param id this is the id of curvepoint item to be deleted
     */
    @Override
    public void deleteCurvePoint(int id) {
        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid curvePoint Id:" + id));
        curvePointRepository.delete(curvePoint);
    }

}
