package indi.Lucius.service.impl;

import indi.Lucius.mapper.CardMapper;
import indi.Lucius.mapper.EmpMapper;
import indi.Lucius.service.ICardService;
import indi.Lucius.vo.CardShowVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: CardServiceImpl
 * @Description: 卡片管理业务管理逻辑实现类
 * @Author: Lucius Pan
 * @Date: 2023/6/3 23:16
 */

@Service
public class CardServiceImpl implements ICardService {
    @Resource
    CardMapper cardMapper;

    @Resource
    EmpMapper empMapper;
    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 查询所有卡片信息
    * @DateTime: 2023/6/4 11:27
    * @Params: [cardNum, empName, beginTime, endTime, bState, page]
    * @Return java.util.List
    */
    public List selectAll(String cardNum, String empName, String beginTime, String endTime, String bState, Integer page) {
        page = (page - 1) * 5;
        List<CardShowVo> list = cardMapper.selectAll(cardNum, empName, beginTime, endTime, bState, page);
        return list;
    }

    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 查询所有卡片数量
    * @DateTime: 2023/6/4 11:28
    * @Params: [cardNum, empName, beginTime, endTime, bState]
    * @Return java.lang.Integer
    */
    public Integer selectAllNum(String cardNum, String empName, String beginTime, String endTime, String bState) {
        Integer num = cardMapper.selectAllNum(cardNum, empName, beginTime, endTime, bState);
        return num;
    }


    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 删除卡片
    * @DateTime: 2023/6/4 11:28
    * @Params: [cardNum]
    * @Return java.lang.Integer
    */
    public Integer deleteCard(String cardNum) {
        Integer num = cardMapper.deleteCard(cardNum);
        return num;
    }


    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 重置卡片
    * @DateTime: 2023/6/4 11:28
    * @Params: [cardNum]
    * @Return java.lang.Integer
    */
    public Integer resetCard(String cardNum) {
        Integer num = cardMapper.resetCard(cardNum);
        return num;
    }


    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 分配卡片
    * @DateTime: 2023/6/4 11:29
    * @Params: [cardNum, empId, endTime]
    * @Return java.lang.Integer
    */
    public Integer allocateCard(String cardNum, String empId,String endTime) {
       Integer num = empMapper.checkEmpId(empId);
       if (num == 0){
           num = -1;
         }else {
              num = cardMapper.allocateCard(cardNum, empId ,endTime);
       }
        return num;
    }

    @Override
    /**
    * @Author: Lucius Pan
    * @Description: 插入卡片
    * @DateTime: 2023/6/4 11:29
    * @Params: [cardNum]
    * @Return java.lang.Integer
    */
    public Integer insertCard(String cardNum) {
       return cardMapper.insertCard(cardNum);
    }
}
