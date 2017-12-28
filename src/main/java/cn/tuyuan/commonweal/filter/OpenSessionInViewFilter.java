package cn.tuyuan.commonweal.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * @author 孙家伟
 * 2017年12月23日
 *
 */
public class OpenSessionInViewFilter extends HibernateDaoSupport implements Filter{
  
	@Override
	public void init(FilterConfig filterConfig)  throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 Transaction tx = null;
		 try {
			//请求到达时，打开Session并启动事物
			 tx= this.getSessionFactory().getCurrentSession().beginTransaction();
			 //执行请求处理链
			 chain.doFilter(request,response);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
  
}

