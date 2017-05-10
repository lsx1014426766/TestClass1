Set<String> sets = new HashSet<String>();
	//set为无序结合，不能添加重复的内容
	boolean f = sets.add("a");
	System.out.println(f);
    boolean ff = sets.add("a");
    System.out.println(ff);

	   String[]aa={"333","555","444"};
   
   List<String>g=new ArrayList<String>();
   Collections.addAll(g, aa);//把数组放入集合中
   System.out.println("g:"+g.size());
   
   List<String>a=new ArrayList<String>();
   a.add("a1");
   List<String>t=new ArrayList<String>();
   t.add("t1");
   t.add("t2");
   a.addAll(t);//把集合放入集合中
   System.out.println(a.size());
   
   //map放同一个key，以后者覆盖值为终值
   Map<String,Object>map=new HashMap<String,Object>();
   map.put("a", 1);
   map.put("a", 2);
   System.out.println(map.get("a"));
}
}
