package indi.Lucius.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: CardMapper
 * @Description: 关于卡片表的SQL语句
 * @Author: Lucius Pan
 * @Date: 2023/6/3 23:17
 */
public interface CardMapper {
    List selectAll(@Param("cardNum") String cardNum, @Param("empName") String empName, @Param("beginTime") String  beginTime, @Param("endTime") String endTime, @Param("bState") String bState, @Param("page") Integer page);
    Integer selectAllNum(@Param("cardNum") String cardNum, @Param("empName") String empName, @Param("beginTime") String  beginTime, @Param("endTime") String endTime, @Param("bState") String bState);

    Integer deleteCard(@Param("cardNum") String cardNum);

    Integer resetCard(@Param("cardNum") String cardNum);

    Integer allocateCard(@Param("cardNum") String cardNum, @Param("empId") String empId,@Param("endTime") String endTime);

    Integer insertCard(@Param("cardNum") String cardNum);
}
