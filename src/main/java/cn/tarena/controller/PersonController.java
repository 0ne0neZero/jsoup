package cn.tarena.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tarena.pojo.Person;
import cn.tarena.service.PersonService;
import cn.tarena.utils.HttpClientService;
import cn.tarena.utils.Queue;
import cn.tarena.utils.RedisService;
import cn.tarena.utils.cookies;
import cn.tarena.utils.fields;

@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	//private Queue<String> queue = new Queue<String>();
	@Autowired
	private RedisService redisServie;
	@Autowired
	private HttpClientService httpClientService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	ObjectMapper MAPPER = new ObjectMapper();
	@RequestMapping("input")
	public String ToIndex(){
		return "Input";
	}
	@RequestMapping("/search")
	public void InformationCaptur(String url){
		//Queue<String> queue = new Queue<String>();
		//List<String> idList = new ArrayList<String>();
		Document doc;	
			try {
				if(url.contains("jQuery")){
					int i=2;
					while(true){
						i++;
						if(i>2){
							 url= url.replace("pageId="+(i-1), "pageId="+i);
						}
						String data = httpClientService.doGet(url);	
						String bol = data.substring(data.indexOf("NextPage\":")+10, data.indexOf(",\"location"));
						if("false".equals(bol)){
							System.out.println("出来了");
							break;
						}
						String userId = data.substring(data.indexOf("result\":\"")+9, data.indexOf("\",\"status\":\"ok\"})"));
						String bodyHtml = "<input type='hidden' id='userIds' name='userIds' value='"+userId+"'>";
						System.out.println(bodyHtml);
						doc = Jsoup.parseBodyFragment(bodyHtml);
						getUrl(doc);
						System.out.println(i);
					}
				}else{
					String data2 = httpClientService.doGet(url);
					doc = Jsoup.parseBodyFragment(data2);
					getUrl(doc);
				}
				int i=0;
				/*while(!queue.isQueueEmpty()){
					personService.SavePerson(queue.deQueue(),idList.get(i++));	
				}*/
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}	
	//将个人信息的地址存入到队列中
	public void getUrl(Document doc){
		Element userIds = doc.select("#userIds").first();
		String userId = userIds.attr("value");
		String[] arrayUserIds = userId.split(",");
		System.out.println(arrayUserIds.length);
		for (int i = 0; i < arrayUserIds.length; i++) {
			//String url = "http://profile1.baihe.com/?oppId="
								//+arrayUserIds[i].substring(0,arrayUserIds[i].indexOf(":"))+"&showType=2012";
			//queue.inQueue(url);
			//1.判断redis中是否包含该用户
			String id = redisServie.get(arrayUserIds[i].substring(0,arrayUserIds[i].indexOf(":")));
			if(id == null){
				//2.非空加入消息队列
				rabbitTemplate.convertAndSend("personIdQueue", arrayUserIds[i].substring(0,arrayUserIds[i].indexOf(":")));
			}
			
			//idList.add(arrayUserIds[i].substring(0,arrayUserIds[i].indexOf(":")));
		}
		
	}
}
