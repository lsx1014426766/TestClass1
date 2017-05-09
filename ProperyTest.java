import java.util.Properties;
import java.util.Map.Entry;

import org.ofbiz.base.util.UtilProperties;
import org.ofbiz.entity.util.EntityUtil;
import org.ofbiz.entity.util.EntityUtilProperties;

/**
 * 方法本身是基于web应用上下文，直接java运行得到位null
 * @author lsx
 *
 */
public class ProperyTest {
public static void main(String[] args) {
	Properties values1 = UtilProperties.getProperties("org.ofbiz.base.ultimate.common.config.common.properties");
	Properties values2 = UtilProperties.getProperties("common");
	Properties values3 = EntityUtilProperties.getProperties("common");
	System.out.println("显示该文件下的所有属性:");
	for( Entry<Object, Object> one : values1.entrySet()){
		System.out.println("属性【"+ one.getKey()+"】= " + one.getValue());
	}
	for( Entry<Object, Object> one : values2.entrySet()){
		System.out.println("属性【"+ one.getKey()+"】= " + one.getValue());
	}
	for( Entry<Object, Object> one : values3.entrySet()){
		System.out.println("属性【"+ one.getKey()+"】= " + one.getValue());
	}
}
}
