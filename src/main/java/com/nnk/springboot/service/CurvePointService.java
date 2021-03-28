package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;

import java.util.List;

public interface CurvePointService {

    public CurvePoint getCurvePointById(int id);

    public List <CurvePoint> getAllCurvePoint();

    public void saveCurvePoint(CurvePoint curvePoint);

    public void updateCurvePoint(CurvePoint curvePoint);

    public void deleteCurvePoint(int id);

}
