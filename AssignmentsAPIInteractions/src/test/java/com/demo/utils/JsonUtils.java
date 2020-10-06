package com.demo.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class JsonUtils {
	
	public  String frameJsonRrquest(HashMap<String, String> map){
		JSONObject obj = new JSONObject();
		obj.putAll(map);
		return obj.toJSONString();
	}
	
	public HashMap<String, String> getJSonRequestMap(String[] keys,String[] values){
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0;i<keys.length;i++){
			map.put(keys[i].trim(),values[i].trim());
		}
		return map;
	}
	
	public Map getMapFromJsonObject(JSONObject jsonObj) throws JsonParseException, JsonMappingException, IOException{
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		Map<String, String> reqMap = mapper.readValue(jsonObj.toJSONString(),Map.class);
		return reqMap;
	}
	
	public  JSONObject parseJsonResponse(Response res){
		JSONObject obj = (JSONObject) JSONValue.parse(res.asString());
		return obj;
	}
	
	public List<JsonNode> getJsonNodes(String res,String nodeName) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=mapper.readTree(res);
		List<JsonNode> node1=node.findValues("list");
		List<JsonNode> lstNodes=null;
		//List<JsonNode> mainNode=null;
		
		for(int i=0;i<node1.size();i++){
			lstNodes = node1.get(i).findValues(nodeName);
			//mainNode = node1.get(i).findValues("main");
		}
		
		return lstNodes;
	}
	
	public ArrayList<String> getRespectiveNodeValuesInList(List<JsonNode> respectiveNodeLst,String nodeKey){
		ArrayList<String> nodeValesLst = new ArrayList<String>();
		//ArrayList<String> degLst = new ArrayList<String>();
		for(int i=0;i<respectiveNodeLst.size();i++){
			System.out.println("111111111111::"+respectiveNodeLst.get(i).get(nodeKey).asText());
			nodeValesLst.add(respectiveNodeLst.get(i).get(nodeKey).asText());
			//System.out.println("222222222222::"+windNode.get(i).get("deg").asText());
			//degLst.add(windNode.get(i).get("deg").asText());
		}
		return nodeValesLst;
	}
	
	public ArrayList<String> getRespectiveNodeValuesInList(List<JsonNode> respectiveNodeLst,int index,String nodeKey){
		ArrayList<String> nodeValueLst = new ArrayList<String>();
		System.out.println("the main node temp1 is::"+respectiveNodeLst.get(index).get(nodeKey).asText());
		nodeValueLst.add(respectiveNodeLst.get(index).get(nodeKey).asText());
		return nodeValueLst;
	}
	

}
