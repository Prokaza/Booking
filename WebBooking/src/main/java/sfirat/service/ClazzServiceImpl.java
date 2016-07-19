package sfirat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfirat.dao.ClazzDAO;
import sfirat.entity.Clazz;

@Service
public class ClazzServiceImpl  implements ClazzService{

    @Autowired
    ClazzDAO clazzDAO;

    @Override
    @Transactional
    public Clazz getClazzByClazzName(String clazzName) {
        return clazzDAO.getClazzByClazzName(clazzName);
    }
}
