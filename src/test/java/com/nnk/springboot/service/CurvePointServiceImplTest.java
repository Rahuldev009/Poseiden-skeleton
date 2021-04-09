package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurvePointServiceImplTest {

    @Mock
    CurvePointRepository curvePointRepository;
    @InjectMocks
    private CurvePointServiceImpl curvePointService;

    @Test
    public void getCurvePointById() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        curvePoint.setId(1);
        Mockito.when(curvePointRepository.findById(1)).thenReturn(java.util.Optional.of(curvePoint));
        CurvePoint curvePoint1 = curvePointService.getCurvePointById(1);
        Assert.assertTrue(curvePoint1.getId() == 1);
    }

    @Test
    public void getAllCurvePoint() {
        curvePointService.getAllCurvePoint();
        Mockito.verify(curvePointRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void saveCurvePoint() {
        curvePointService.saveCurvePoint(new CurvePoint());
        Mockito.verify(curvePointRepository, Mockito.times(1)).save(Mockito.any(CurvePoint.class));
    }

    @Test
    public void updateCurvePoint() {
        curvePointService.updateCurvePoint(new CurvePoint());
        Mockito.verify(curvePointRepository, Mockito.times(1)).save(Mockito.any(CurvePoint.class));
    }

    @Test
    public void deleteCurvePoint() {
        CurvePoint curvePoint = new CurvePoint();
        curvePoint.setCurveId(10);
        curvePoint.setTerm(10d);
        curvePoint.setValue(30d);
        curvePoint.setId(1);
        Mockito.when(curvePointRepository.findById(1)).thenReturn(java.util.Optional.of(curvePoint));
        curvePointService.deleteCurvePoint(1);
        Mockito.verify(curvePointRepository, Mockito.times(1)).delete(Mockito.any(CurvePoint.class));
    }

}