package cn.tarena.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitService.class);

    @Autowired
    private PersonService personService;

    //消息体有类型，自动转换类型
    public void savePersonId(String userId) {
        LOGGER.info("接受到MQ的消息，内容为：{}", userId);
       this.personService.SavePerson(userId);
    }

}
