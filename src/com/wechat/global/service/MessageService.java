package com.wechat.global.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

import com.wechat.global.entity.MessageImage;
import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.inter.MessageServiceInterface;
import com.wechat.global.util.MessageUtil;

/**
 * 消息业务处理类
 * */
public class MessageService {
	private static Map<String, String> returnMap = new HashMap<String, String>();
	protected static String xmlstring;

	/**
	 * @throws IOException
	 * */
	public static String processRequest(HttpServletRequest request)
			throws IOException {

		// String xmlstring = "";
		// returnMap=new HashMap<String, String>();
		try {
			returnMap = (MessageUtil.xmlToMap(request));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// String toUserName = returnMap.get("FromUserName");
		// String fromUserName = returnMap.get("ToUserName");//
		// 发送消息的人和接收消息的人是一个人，所以要相反赋值
		String msgType = returnMap.get("MsgType");
		// String content = returnMap.get("Content");
		// String msgId = returnMap.get("MsgId");
		MessageServiceInterface msInter = null;
		if (MsgTypeEnum.MsgType_Text.equals(msgType)) {
			msInter = new MessageTextService();
			xmlstring = msInter.execRequest(returnMap);
		} else if (MsgTypeEnum.MsgType_Image.equals(msgType)) {
			MessageImage msi = new MessageImage();
			

		}
		return xmlstring;

	}

	public String getXmlstring() {
		return xmlstring;
	}

}
