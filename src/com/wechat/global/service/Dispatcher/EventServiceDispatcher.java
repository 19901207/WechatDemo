package com.wechat.global.service.Dispatcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.wechat.global.enums.MsgTypeEnum;
import com.wechat.global.service.EventService;
import com.wechat.global.service.inter.EventServiceInterface;
/**
 * 事件处理分发类
 * 
 * */
public class EventServiceDispatcher {
	private static Map<String, String> returnMap = new HashMap<String, String>();
	protected static String xmlstring;

	public static String processRequestMap(Map<String, String> returnMap)
			throws IOException {
		//TODO:事件处理部分需要重写，逻辑错误
		String msgType = returnMap.get("MsgType");
		if (MsgTypeEnum.MsgType_Event.equals(msgType)) {
			EventServiceInterface esInter = new EventService();
			xmlstring = esInter.execRequestMap(returnMap);
		} else {
			System.out.println("错误的请求信息");

		}

		return xmlstring;

	}

	public static Map<String, String> getReturnMap() {
		return returnMap;
	}

	public static void setReturnMap(Map<String, String> returnMap) {
		EventServiceDispatcher.returnMap = returnMap;
	}

}
