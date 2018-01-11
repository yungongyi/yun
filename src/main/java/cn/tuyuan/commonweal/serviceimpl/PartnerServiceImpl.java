package cn.tuyuan.commonweal.serviceimpl;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tuyuan.commonweal.dao.PartnerDao;
import cn.tuyuan.commonweal.pojo.Partner;
import cn.tuyuan.commonweal.service.PartnerService;

/**
 * 
 * @author 高俊东
 *
 */

@Service("partnerService")
public class PartnerServiceImpl implements PartnerService{
    @Resource
    private PartnerDao partnerDao;
	
    /**
     * 查询所有合作
     */
	@Override
	public List<Partner> getPartner() {
		System.out.println("请问");
		List<Partner> p= partnerDao.getPartner();
		System.out.println(p.get(0).getPartnerName());
		return p;
	}
	/**
	 * 根据合作姓名查询合作对象
	 */
	@Override
	public List<Partner> getPartnerByName(String name) {
		List<Partner> p= partnerDao.getPartnerByName(name);
		p.get(0).getPartnerName();
		return p;
	}
	/**
	 * 添加合作对象
	 */
	@Override
	public void addPartner(Partner p) {
		partnerDao.addPartner(p);	
	}
	/**
	 * 删除合作对象
	 */
	@Override
	public void delPartner(int id) {
		System.out.println("自行车"+id);
		partnerDao.delPartner(id);
	}
	/**
	 * 根据合作ID查询合作对象
	 */
	@Override
	public List<Partner> getPartnerById(Integer id) {
		return partnerDao.getPartnerById(id);
	}

}
