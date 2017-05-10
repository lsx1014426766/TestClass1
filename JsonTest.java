import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;



public class TestJson {
	@Test
	public void test1() {
		// 将数据转换为json字符串
		JSONObject j = new JSONObject();
		j.put("name", "lsx");
		j.put("sex", "m");
		j.put("id", 4);
		System.out.println(j.toString());
		//将此json字符串转化为User对象
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", "lsx");
		map1.put("sex", "m");
		map1.put("id", 12);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "lsx");
		map2.put("sex", "m");
		map2.put("id", 13);
		List<Map> list = new ArrayList<Map>();
		list.add(map1);
		list.add(map2);
		User u = new User(2, "ee", "w");
		//数组形式
		JSONArray arrayMap1 = JSONArray.fromObject(map1);
		JSONArray arrayList = JSONArray.fromObject(list);
		JSONArray arrayU = JSONArray.fromObject(u);
		System.out.println(arrayMap1);//[{"id":12,"sex":"m","name":"lsx"}]
		System.out.println(arrayList);//[{"id":12,"sex":"m","name":"lsx"},{"id":13,"sex":"m","name":"lsx"}]
		System.out.println(arrayU);   //[{"id":2,"name":"ee","sex":"w"}]
	
	}
	@Test
	public void test2(){
		//jackon包
		String str = "{users:[{id:2,name:\"eee\"},{id:3,name:\"fff\"}]}";
		/*// List<User>
		// us=(List<User>)Json.parseJson("{users:[{id:2,name:\"eee\"},{id:3,name:\fff\"}]}",
		// new TypeToken<List<User>>(){}.getType());
		try {
			// 导包问题
			ObjectMapper mapper = new ObjectMapper();
			// key有无双引号的问题
			mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,
					true);
			JsonNode root = mapper.readTree(str);
			// 提取 data
			JsonNode data = root.path("users");
			Iterator<JsonNode> it = data.iterator();
			if (it.hasNext()) {
				User u = (User) Json
						.parseJson(it.next().toString(), User.class);
				System.out.println(u.getName());
			}
		} catch (Exception e) {
		}*/
	}
	@Test
	public void test3(){
		/* String str=  "{users:[{id:2,name:\"eee\"},{id:3,name:\"fff\"}]}";
	      //关于解析不合法的json格式： 
		    JSONObject jsonObject = JSONObject.fromObject(str); 
		    JSONArray jsArray = jsonObject.getJSONArray("users");  
		    Iterator it = jsArray.iterator();
		   if( it.hasNext()){
			   //此处的json为andy封装的类
			   User u = (User)Json.parseJson(it.next().toString(), User.class);
			   System.out.println(u.getName());
		   }*/
	}
}
