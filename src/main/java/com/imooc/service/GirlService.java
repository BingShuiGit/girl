package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by HD on 2018/7/13.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * @Transactional 事务注解：同时操作多条数据，如果有一条或多条数据操作失败，
     * 将不执行任何该事务中其他数据操作
     * 该例中将cupSize定义为长度为1，若girlB中的cupSize为“BBB”，
     * 则出错，girlA也不会插入表中，若没事务注解，girlB出错，girlA也会插入
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();

        if (age < 10){
            //返回“你还在上小学吧” code = 100
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            //你可能在上初中 code = 101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
