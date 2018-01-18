package cn.tuyuan.commonweal.service;

import java.util.List;

import cn.tuyuan.commonweal.pojo.Partner;

/**
 * 
 * @author 高俊东
 *
 */

public interface PartnerService {
	/**
	 * 查询所有合作信息
	 * @return
	 */
    List<Partner> getPartner();
    
    /**
     * 根据合作姓名查询合作对象
     */
    List<Partner> getPartnerByName(String name);
    
    /**
     * 添加合作对象
     */
    int addPartner(Partner p);
    
    /**
     * 删除合作对象
     */
    void delPartner(int id);
    
    /**
     * 根据合作ID查询合作对象
     */
    List<Partner> getPartnerById(Integer id);
}
