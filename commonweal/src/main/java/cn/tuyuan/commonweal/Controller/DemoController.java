package cn.tuyuan.commonweal.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tuyuan.commonweal.Service.PersonService;
import cn.tuyuan.commonweal.pojo.Person;

@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private PersonService persondao;

    @RequestMapping(value = "jsonCompare", method = RequestMethod.POST)
    @ResponseBody
    public List<Person>  jsonCompare(@RequestParam("expect") String expect, @RequestParam("actual") String actual, ModelMap model,
            HttpSession session) {

    	List<Person> pLsit=persondao.getAllPerson();
		if(pLsit!=null){
			for(Person pl:pLsit) {
				System.out.println(pl.getName());
			}
		}else{
			System.out.println("错的");
		}

        return pLsit;
    }

}