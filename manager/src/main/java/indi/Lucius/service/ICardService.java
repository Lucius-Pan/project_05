package indi.Lucius.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @InterfaceName: ICardService
 * @Description: 关于卡片管理的service逻辑处理接口
 * @Author: Lucius Pan
 * @Date: 2023/6/3 23:15
 */


public interface ICardService {


 List selectAll(String cardNum, String empName, String  beginTime, String endTime, String bState, Integer page);

 Integer selectAllNum(String cardNum, String empName, String  beginTime, String endTime, String bState);


 Integer deleteCard(String cardNum);

 Integer resetCard(String cardNum);

 Integer allocateCard(String cardNum, String empId,String endTime);

 Integer insertCard(String cardNum);
}
