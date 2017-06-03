package cn.tarena.service;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.mapper.PersonMapper;
import cn.tarena.pojo.Person;
import cn.tarena.utils.RedisService;
import cn.tarena.utils.cookies;
import cn.tarena.utils.fields;



@Service
public class PersonService {
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private RedisService redisService;
	
	public void SavePerson(String userId){
		try{
			String url = "http://profile1.baihe.com/?oppId="+userId+"&showType=2012";
		Document doc = Jsoup.connect(url).cookies(cookies.getMap()).get();
		Elements all = doc.select("#BAIHE");
		Elements userData = all.select("div.inter");
		//昵称
		Element link = userData.select("div.name").get(0);
		String nikeName1 = link.text();
		String nikeName2 = nikeName1.substring(0, nikeName1.length()-1);
		Elements inter = userData.select("p");
		String interText=inter.text();
		String [] interTexts = interText.split("/");
		String age = interTexts[0].substring(0, 2);//年龄
		String height = interTexts[1].substring(0, 3);//身高
		String education = interTexts[2];//学历
		String addr = interTexts[3];//地址
		String marry = interTexts[4];//结婚
		Person person = new Person();
		person.setId(userId);
		person.setNickName(nikeName2);
		person.setAge(age);
		person.setHeight(height);
		person.setEducation(education);
		person.setAddr(addr);
		person.setMarry(marry);
		
		
		Elements others = all.select("div.perData");
		//自我介绍
		Elements descripEle = others.select("div.intr");
		String descrip=descripEle.text();
		person.setDescrip(descrip);
		//图片
		Elements image = all.select("div.big_pic").select("img[src]");
		String imageHtml = image.attr("src");
		person.setImage(imageHtml);
		//个人及工作状况
		Elements personInfo = others.select("dl>dd");
		
		List infos = new ArrayList();
		for(int i=0;i<46;i++){
			Element message = personInfo.get(i);
			infos.add(message.text());	
		}
		 fields.getFields(person, infos);
		 String weightOdd = person.getWeight();
		 if(weightOdd.contains("公斤")){
				String weight = weightOdd.substring(0, person.getWeight().lastIndexOf("公斤"));
				person.setWeight(weight);
				}else{
					person.setWeight("null");
				}
			System.out.println(person);
			personMapper.insert(person);
		 if(personMapper.selectByPrimaryKey(userId)!=null){
				redisService.set(userId, userId);
			}
		 Thread.sleep(100);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
